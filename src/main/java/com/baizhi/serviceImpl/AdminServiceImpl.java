package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Error;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Admin selectAdmin(String name) {
        Admin admin = adminDao.selectAdmin(name);
        if (admin == null) {
            return null;
        }
        return admin;
    }

    @Override
    public Error updateAdmin(Admin admin) {
        try {
            adminDao.updateAdmin(admin);
            return null;
        } catch (Exception e) {
            return new Error("5", "修改失败！");
        }
    }
}
