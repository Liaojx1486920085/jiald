package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Error;

public interface AdminService {

    public Admin selectAdmin(String name);

    public Error updateAdmin(Admin admin);

}
