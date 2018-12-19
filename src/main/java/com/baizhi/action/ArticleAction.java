package com.baizhi.action;

import com.baizhi.entity.*;
import com.baizhi.entity.Error;
import com.baizhi.service.ArticleService;
import com.baizhi.service.GuruService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleAction {
    @Resource
    private ArticleService articleService;
    @Resource
    private GuruService guruService;

    //分页查询
    @PostMapping("/selectArticle")
    public ArticleJson selectArticle(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, HttpSession session) {
        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        ArticleJson articleJson = articleService.selectArticle(page1);
        for (Article row : articleJson.getRows()) {
            System.out.println(row.getPublicTime());
        }
        List<Guru> gurus = guruService.selectGuru();
        session.setAttribute("gurus", gurus);
        return articleJson;
    }

    //增加
    @PostMapping("/addArticle")
    public Error addArticle(@RequestParam("picPathUpdate") MultipartFile picPathUpdate, Article article, HttpSession session) throws IllegalAccessException, IOException {
        System.out.println("进入Action层" + article.toString());
        String sp = session.getServletContext().getRealPath("/");
        System.out.println("服务器绝对路径为：    " + sp.toString());
        File f = new File(sp + "/picture/");
        if (!f.exists()) {
            f.mkdir();
        }
        File ff = new File(sp + "/picture/" + picPathUpdate.getOriginalFilename());
        article.setArticlePic("/picture/" + picPathUpdate.getOriginalFilename());
        System.out.println("文件绝对路径为：        " + "/picture/" + picPathUpdate.getOriginalFilename());
        System.out.println(ff == null);
        System.out.println(picPathUpdate == null);
        picPathUpdate.transferTo(ff);
        System.out.println("进入add中的Banner对象为：     " + article.toString());
        Error error = articleService.addArticle(article);
        System.out.println(error);
        return error;
    }


}
