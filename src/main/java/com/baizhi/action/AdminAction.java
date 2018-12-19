package com.baizhi.action;


import com.baizhi.entity.Admin;
import com.baizhi.entity.Error;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Resource
    private AdminService adminService;

    //用户登录验证
    @RequestMapping("/selectAdmin")
    @ResponseBody
    public Error selectAdmin(String name, String password, String enCode, Model model, HttpSession httpSession) {
        Admin admin = adminService.selectAdmin(name);
        String code = (String) httpSession.getAttribute("code");
        if (admin == null) {
            return new Error("1", "用户名不存在!");
        } else if (!(admin.getPassword().equals(password))) {
            return new Error("2", "密码错误！");
        } else if (!(httpSession.getAttribute("code").equals(enCode))) {
            return new Error("3", "验证码错误！");
        } else {
            httpSession.setAttribute("admin", admin);
            return null;
        }
    }

    //退出系统
    @RequestMapping("/exitAdmin")
    public String exitAdmin(HttpSession session) {
        session.removeAttribute("admin");
        return "login";
    }

    //修改密码
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public Error updateAdmin(String passwordes, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        System.out.println(passwordes);
        System.out.println(admin.toString());
        admin.setPassword(passwordes);
        Error error = adminService.updateAdmin(admin);
        if (error == null) {
            session.setAttribute("admin", admin);
            return new Error("6", "修改成功");
        } else {
            return error;
        }

    }
}
