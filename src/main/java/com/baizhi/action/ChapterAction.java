package com.baizhi.action;


import com.baizhi.entity.Chapter;
import com.baizhi.entity.Error;
import com.baizhi.service.ChapterService;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/chapter")
public class ChapterAction {
    @Resource
    private ChapterService chapterService;

    @RequestMapping("/addChapter")
    //增加音乐
    public Error addChapter(@RequestParam("picPathUpdate") MultipartFile picPathUpdate, HttpSession session, Chapter chapter) throws IOException {
        String sp = session.getServletContext().getRealPath("/");
        File f = new File(sp + "/musics/");
        if (!f.exists()) {
            f.mkdir();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        chapter.setName(sf.format(new Date()) + picPathUpdate.getOriginalFilename());
        chapter.setUrl("/musics/" + picPathUpdate.getOriginalFilename());
        File ff = new File(sp + "/musics/" + picPathUpdate.getOriginalFilename());
        picPathUpdate.transferTo(ff);
        double a = ff.length();
        chapter.setSize(a / 1024 / 1024);
        try {
            MP3File f1 = (MP3File) AudioFileIO.read(ff);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f1.getAudioHeader();
            Integer trackLength = audioHeader.getTrackLength();
            if (trackLength > 60) {
                Integer aa = trackLength % 60;
                Integer aa1 = trackLength / 60;
                aa.toString();
                chapter.setLength(aa.toString() + "分" + aa1.toString() + "秒");
            } else if (trackLength == 60) {
                chapter.setLength("1分00");
            } else {
                chapter.setLength("0分" + trackLength.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Error error = chapterService.addChapter(chapter);
        return error;
    }

    @PostMapping("/deleteChapter")
    public Error deleteChapter(String id) {
        Error error = chapterService.deleteChapter(id);
        return error;
    }

    @RequestMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取目标文件
        String realPath = request.getSession().getServletContext().getRealPath("/musics");
        File f = new File(realPath, fileName.substring(14));
        //获取文件输入流
        FileInputStream fis = new FileInputStream(f);
        //设置响应类型
        String ext = fileName.substring(fileName.lastIndexOf("."));
        response.setContentType(request.getSession().getServletContext().getMimeType(ext));
        //设置响应头
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        //获取响应流
        ServletOutputStream os = response.getOutputStream();
        //下载 SpringFreemark
        FileCopyUtils.copy(fis, os);
    }


}
