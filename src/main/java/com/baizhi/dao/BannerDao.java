package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    //分页查询
    public List<Banner> selectBanner(@Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd);

    //总条数
    public Integer selectBannerCount();

    //增加
    public void addBanner(Banner banner);

    //修改
    public void updateBanner(Banner banner);

    //删除
    public void deleteBanner(String id);
}
