package com.baizhi.service;

import com.baizhi.entity.Error;
import com.baizhi.entity.User;

public interface UserService {

    public User selectUserByName(String name);

    public Error addUser(User user);

    public Error updateUser(User user);

    public User selectUserById(String id);

}
