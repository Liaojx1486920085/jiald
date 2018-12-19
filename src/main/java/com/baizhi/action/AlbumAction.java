package com.baizhi.action;


import com.baizhi.entity.Album;
import com.baizhi.entity.Error;
import com.baizhi.service.AlbumService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/album")
//@SessionAttributes("albums")
public class AlbumAction {
    @Resource
    private AlbumService albumService;

    @PostMapping("/selectAlbum")
    //专辑查询
    public List<Album> selectAlbum(Model model, HttpSession session) {
//        System.out.println(page);
//        System.out.println(rows);
//        Page page1 = new Page();
//        page1.setPageSize(rows);
//        page1.setPageIndex(page);
        List<Album> albumJson = albumService.selectAlbum();
        /*model.addAttribute("albums",albumJson);*/
        session.setAttribute("albums", albumJson);
        return albumJson;
    }

    @PostMapping("/addAlbum")
    public Error adaAlbum(MultipartFile picPathUpdate, HttpSession session, Album album) throws IOException {
        String sp = session.getServletContext().getRealPath("/");
        System.out.println("服务器绝对路径为：    " + sp.toString());
        File f = new File(sp + "/picture/");
        if (!f.exists()) {
            f.mkdir();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(sf);
        System.out.println(picPathUpdate.getOriginalFilename());
        album.setCoverImg(sf.format(new Date()) + picPathUpdate.getOriginalFilename());
        File ff = new File(sp + "/picture/" + picPathUpdate.getOriginalFilename());
        System.out.println("文件绝对路径为：        " + sp + "/picture/" + picPathUpdate.getOriginalFilename());
        System.out.println(ff == null);
        System.out.println(picPathUpdate == null);
        picPathUpdate.transferTo(ff);
        Error error = albumService.addAlbum(album);
        return error;
    }

    @PostMapping("/deleteAlbum")
    public Error deleteAlbum(String id) {
        Error error = albumService.deleteAlbum(id);
        return error;
    }

}
