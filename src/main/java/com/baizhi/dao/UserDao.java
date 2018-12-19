package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {

    public User selectUserByName(String name);

    public void addUser(User user);

    public void updateUser(User user);

    public User selectUserById(String id);
}
