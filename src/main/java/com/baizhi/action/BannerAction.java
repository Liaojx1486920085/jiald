package com.baizhi.action;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Error;
import com.baizhi.entity.Page;
import com.baizhi.entity.PageJson;
import com.baizhi.service.BannerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/banner")
public class BannerAction {
    @Resource
    private BannerService bannerService;

    //分页查询轮播图
    @RequestMapping(value = "/selectBanner", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
//处理json中文乱码
    public PageJson selectBanner(Integer page, Integer rows) {
        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        PageJson pageJson = bannerService.selectBanner(page1);
        return pageJson;
    }

    //增加轮播图
    @PostMapping("/addBanner")
    public Error addBanner(MultipartFile picPathUpdate, Banner banner, HttpSession session) throws IllegalAccessException, IOException {
        String sp = session.getServletContext().getRealPath("/");
        System.out.println("服务器绝对路径为：    " + sp.toString());
        File f = new File(sp + "/picture/");
        if (!f.exists()) {
            f.mkdir();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        banner.setPicPath(sf.format(new Date()) + banner.getPicName());
        File ff = new File(sp + "/picture/" + banner.getPicPath() + ".png");
        System.out.println("文件绝对路径为：        " + sp + "/picture/" + banner.getPicPath());
        System.out.println(ff == null);
        System.out.println(picPathUpdate == null);
        picPathUpdate.transferTo(ff);
        System.out.println("进入add中的Banner对象为：     " + banner.toString());
        Error error = bannerService.addBanner(banner);
        System.out.println(error);
        return error;
    }

    //修改轮播图
    @RequestMapping("/updateBanner")
    public Error updateBanner(Banner banner) {

        Error error = bannerService.updateBanner(banner);
        return error;
    }

    //删除轮播图
    @RequestMapping("/deleteBanner")
    public Error deleteBanner(@RequestParam(value = "id") String id) {
        System.out.println(id);
        Error error = bannerService.deleteBanner(id);
        return error;
    }

}
