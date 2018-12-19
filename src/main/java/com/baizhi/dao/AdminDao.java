package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {

    public Admin selectAdmin(String name);

    public void updateAdmin(Admin admin);

}
