package com.baizhi.WebService;


import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.*;
import com.baizhi.entity.Error;
import com.baizhi.service.*;
import com.baizhi.util.MD5Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/WenService")
public class 你个傻逼 {

    @Resource
    private BannerService bannerService;
    @Resource
    private AlbumService albumService;
    @Resource
    private ArticleService articleService;
    @Resource
    private GuruService guruService;
    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    //分页查询轮播图
    //http://localhost:9999/jiald/WenService/selectBanner?page=1&rows=5&uid=1&type=all
    @RequestMapping(value = "/selectBanner", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
//处理json中文乱码
    public JSONObject selectBanner(Integer page, Integer rows, String type, String uid, HttpSession session) {
        String sp = session.getServletContext().getRealPath("/");
        JSONObject jsonObjects = new JSONObject();

        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        PageJson pageJson = bannerService.selectBanner(page1);
        List list = new ArrayList();
        for (Banner row : pageJson.getRows()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("thumbnail", sp + row.getPicPath() + ".png");
            jsonObject.put("desc", row.getDescription());
            jsonObject.put("id", row.getId());
            list.add(jsonObject);
        }
        jsonObjects.put("header", list);
        User user = userService.selectUserById(uid);
        if (uid == null || user == null || !type.equals("all")) {
            return null;
        }
        return jsonObjects;
    }

    @GetMapping("/selectAlbum")
    //专辑查询
    //http://localhost:9999/jiald/WenService/selectAlbum?uid=1&type=wen
    public JSONObject selectAlbum(String uid, String type, HttpSession session) {
        String sp = session.getServletContext().getRealPath("/");
        JSONObject jsonObjects = new JSONObject();
        List<Album> albumJson = albumService.selectAlbum();
        List list = new ArrayList();
        for (Album album : albumJson) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("thumbnail", sp + album.getCoverImg() + ".png");
            jsonObject.put("title", album.getName());
            jsonObject.put("author", album.getDescription());
            jsonObject.put("type", "0");
            jsonObject.put("set_count", album.getCount());
            jsonObject.put("create_date", album.getPublicTime());
            list.add(jsonObject);
        }
        jsonObjects.put("body", list);
        User user = userService.selectUserById(uid);
        if (uid == null || user == null || !type.equals("wen")) {
            return null;
        }
        return jsonObjects;
    }


    //分页查询
    @GetMapping("/selectArticle")
    //文章
    //http://localhost:9999/jiald/WenService/selectArticle?page=1&rows=5&uid=1&type=si&sub_type=ssyj
    //老师
    //http://localhost:9999/jiald/WenService/selectArticle?page=1&rows=5&uid=阿尔托莉雅&type=si&sub_type=xmfy
    public JSONObject selectArticle(String uid, String type, String sub_type, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, HttpSession session) {
        String sp = session.getServletContext().getRealPath("/");
        JSONObject jsonObjects = new JSONObject();
        User user = userService.selectUserById(uid);
        if (uid == null || user == null || !type.equals("si") || sub_type == null) {
            return null;
        } else {
            if (sub_type.equals("ssyj")) {
                Page page1 = new Page();
                page1.setPageSize(rows);
                page1.setPageIndex(page);
                ArticleJson articleJson = articleService.selectArticle(page1);
                List list = new ArrayList();
                for (Article row : articleJson.getRows()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("thumbnail", sp + row.getArticlePic() + ".png");
                    jsonObject.put("title", row.getTitle());
                    jsonObject.put("author", row.getGuru().getDharnaName());
                    jsonObject.put("type", "1");
                    jsonObject.put("set_count", "");
                    jsonObject.put("create_date", row.getPublicTime());
                    list.add(jsonObject);
                }
                jsonObjects.put("body", list);
            } else if (sub_type.equals("xmfy")) {
                List<Guru> gurus = guruService.selectGuru();
                List list1 = new ArrayList();
                for (Guru guru : gurus) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("photo", sp + guru.getPhoto() + ".png");
                    jsonObject.put("dharnaName", guru.getDharnaName());
                    jsonObject.put("status", guru.getStatus());
                    jsonObject.put("createTime", guru.getCreateTime());
                    list1.add(jsonObject);
                }
                jsonObjects.put("body", list1);

            }
            return jsonObjects;
        }

    }

    @GetMapping("selectArticleById")
    //http://localhost:9999/jiald/WenService/selectArticleById?page=1&rows=5&uidc=1&id=d1
    public JSONObject selectArticleById(String id, String uidc, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, HttpSession session) {
        JSONObject jsonObjects = new JSONObject();
        Page page1 = new Page();
        page1.setPageSize(rows);
        page1.setPageIndex(page);
        ArticleJson articleJson = articleService.selectArticle(page1);
        Article article = null;
        for (Article row : articleJson.getRows()) {
            if (row.getId().equals(id)) {
                article = row;
            }
        }
        jsonObjects.put("Link", "http://localhost:9999/jiald/text/" + article.getArticlePic() + ".html");
        jsonObjects.put("id", article.getId());
        jsonObjects.put("ext", "");
        User user = userService.selectUserById(uidc);
        if (user == null || !article.getId().equals(id)) {
            return null;
        }
        return jsonObjects;
    }

    @GetMapping("/selectAlbums")
    //专辑查询
    //http://localhost:9999/jiald/WenService/selectAlbums?uid=1&id=1
    public JSONObject selectAlbums(String id, String uid, HttpSession session) {
        List<Album> albumJson = albumService.selectAlbum();
        JSONObject jsonObject = new JSONObject();//最外层存储专辑List集合的JSONObject
        List list = new ArrayList();//存储专辑List集合
        Page page1 = new Page();
        page1.setPageSize(10);
        page1.setPageIndex(1);
        //遍历外层专辑
        String a = null;
        for (Album album : albumJson) {
            if (album.getId().equals(id)) {
                a = album.getId();
                JSONObject jsonObject1 = new JSONObject();//存储单个专辑以及里面的音乐专辑
                jsonObject1.put("thumbnail", "http://localhost:9999/jiald/picture/" + album.getCoverImg() + ".jpg");
                jsonObject1.put("title", album.getName());
                jsonObject1.put("score", album.getScore());
                jsonObject1.put("author", album.getAuthor());
                jsonObject1.put("broadcast", album.getBrodecast());
                jsonObject1.put("set_count", album.getCount());
                jsonObject1.put("brief", album.getDescription());
                jsonObject1.put("create_date", album.getPublicTime());
                JSONObject jsonObject2 = new JSONObject();//存储单个专辑以及里面的音乐专辑
                List list1 = new ArrayList();//存储音乐List集合
                int aa = 0;
                for (Chapter child : album.getChildren()) {
                    aa += 1;
                    jsonObject2.put("title", "第" + aa + "集");
                    jsonObject2.put("download_url", "jiald/" + child.getUrl());
                    jsonObject2.put("size", child.getSize() + "MB");
                    jsonObject2.put("duration", child.getLength());
                    list1.add(jsonObject2);
                }
                jsonObject1.put("list", list1);
                list.add(jsonObject1);
            }
        }
        jsonObject.put("introduction", list);
        User user = userService.selectUserById(uid);
        if (user == null || !id.equals(a)) {
            return null;
        }
        return jsonObject;
    }


    //用户登录验证
    @GetMapping("/selectUserByName")
    //http://localhost:9999/jiald/WenService/selectUserByName?phone=阿尔托莉雅&password=123456
    public JSONObject selectUserByName(String phone, String password, HttpSession session) {
        String sp = session.getServletContext().getRealPath("/");
        JSONObject jsonObject = new JSONObject();
        User user = userService.selectUserByName(phone);
        if (user.getPassword().equals(password)) {
            jsonObject.put("password", MD5Utils.getPassword(user.getPassword()));
            jsonObject.put("farmington", user.getDharmaName());
            jsonObject.put("uid", user.getId());
            jsonObject.put("nickname", user.getName());
            jsonObject.put("gender", user.getSex());
            jsonObject.put("photo", "" + user.getPhoto());
            jsonObject.put("location", sp + user.getPrivoince() + user.getCity());
            jsonObject.put("province", sp + user.getPrivoince());
            jsonObject.put("city", user.getCity());
            jsonObject.put("description", user.getSign());
            jsonObject.put("phone ", user.getPhoto());
        } else if (!user.getPassword().equals(password)) {
            jsonObject.put("error", "-200");
            jsonObject.put("errmsg", "密码错误");
        }
        return jsonObject;
    }

    @GetMapping("/addUser")
    //http://localhost:9999/jiald/WenService/addUser?phone=2111111111&password=123456
    public JSONObject addUser(String phone, String password) {
        JSONObject jsonObject = new JSONObject();
        User user1 = userService.selectUserByName(phone);
        if (user1 != null) {
            jsonObject.put("error", "-200");
            jsonObject.put("error-msg", "该手机号已存在");
            return jsonObject;
        } else {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName(phone);
            user.setPhoneNum(phone);
            user.setDharmaName(phone);
            user.setPassword(password);
            user.setCreatTime(new Date());
            user.setStatus(1);
            Error error = userService.addUser(user);
            if (error == null) {
                jsonObject.put("password", user.getPassword());
                jsonObject.put("uid", user.getId());
                jsonObject.put("phone", user.getPhoneNum());
            } else {
                return null;
            }
            return jsonObject;
        }
    }

    @GetMapping("/updateUser")
    //http://localhost:9999/jiald/WenService/updateUser?uid=1&gender=1&photo=123&location=北京&description=我好饿&nickname=阿尔托莉雅&province=不列颠&city=皇城&password=1245
    public JSONObject updateUser(String uid, Integer gender, String photo, String location, String description, String nickname, String province, String city, String passowrd) {
        User user = userService.selectUserById(uid);
        JSONObject jsonObject = new JSONObject();
        if (user != null) {
            user.setSex(gender);
            user.setPhoto(photo);
            user.setSign(description);
            user.setName(nickname);
            user.setPrivoince(province);
            user.setCity(city);
            user.setPassword(passowrd);
            Error error = userService.updateUser(user);
            if (error == null) {
                User user1 = userService.selectUserById(uid);
                jsonObject.put("password", user1.getPassword());
                jsonObject.put("farmington", user.getDharmaName());
                jsonObject.put("uid", user1.getId());
                jsonObject.put("nickname", user1.getName());
                if (user1.getSex() == 1) {
                    jsonObject.put("gender", "f");
                } else {
                    jsonObject.put("gender", "m");
                }
                jsonObject.put("photo", "jiald/" + user1.getPhoto() + ".jpg");
                jsonObject.put("location", user1.getPrivoince() + user1.getCity());
                jsonObject.put("province", user1.getPrivoince());
                jsonObject.put("city", user1.getCity());
                jsonObject.put("description", user1.getSign());
                jsonObject.put("phone", user1.getPhoneNum());
            } else {
                jsonObject.put("error", "-200");
                jsonObject.put("error_msg", "修改失败");
            }
        } else {
            jsonObject.put("error", "-200");
            jsonObject.put("error_msg", "该用户不存在");
        }
        return jsonObject;
    }


}
