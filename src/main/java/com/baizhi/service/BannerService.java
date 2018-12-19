package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Error;
import com.baizhi.entity.Page;
import com.baizhi.entity.PageJson;

public interface BannerService {
    //分页查询
    public PageJson selectBanner(Page page);

    //增加
    public Error addBanner(Banner banner);

    //修改
    public Error updateBanner(Banner banner);

    //删除
    public Error deleteBanner(String id);


}
