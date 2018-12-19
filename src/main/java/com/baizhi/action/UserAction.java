package com.baizhi.action;


import com.baizhi.entity.Error;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserAction {

    @Resource
    private UserService userService;

    @RequestMapping("/selectUserByNname")
    public Error selectUserByNname(String name) {
        User user = userService.selectUserByName(name);
        if (user == null) {
            return new Error("18", "用户名或密码错误");
        } else {
            return null;
        }
    }

    @RequestMapping("/addUser")
    public Error addUser(String phone, String password) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(phone);
        user.setPhoneNum(phone);
        user.setPassword(password);
        Error error = userService.addUser(user);
        if (error == null) {
            return null;
        } else {
            return new Error("20", "注册失败！");
        }
    }

    @GetMapping("/updateUser")
    public Error updateUser(String uid, Integer gender, String photo, String locattion, String description, String nickname, String province, String city, String passowrd) {
        User user = userService.selectUserById(uid);
        if (user != null) {
            user.setSex(gender);
            user.setPhoto(photo);
            user.setSign(description);
            user.setName(nickname);
            user.setPrivoince(province);
            user.setCity(city);
            user.setPassword(passowrd);
            Error error = userService.updateUser(user);
            return error;
        } else {
            return new Error("22", "用户名不存在");
        }
    }
}
