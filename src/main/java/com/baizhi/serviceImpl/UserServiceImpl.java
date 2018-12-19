package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Error;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User selectUserByName(String name) {
        User user = userDao.selectUserByName(name);
        return user;
    }

    @Override
    public Error addUser(User user) {
        try {
            userDao.addUser(user);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return new Error("19", "注册失败！");
        }
    }

    @Override
    public Error updateUser(User user) {
        try {
            userDao.updateUser(user);
            return null;
        } catch (Exception e) {
            return new Error("21", "修改失败！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User selectUserById(String id) {
        User user = userDao.selectUserById(id);
        return user;
    }
}
