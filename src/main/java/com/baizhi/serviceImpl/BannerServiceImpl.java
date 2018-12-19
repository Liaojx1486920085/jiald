package com.baizhi.serviceImpl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Error;
import com.baizhi.entity.Page;
import com.baizhi.entity.PageJson;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerDao bannerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PageJson selectBanner(Page page) {
        int integer = bannerDao.selectBannerCount();
        Long result = 0L;
        result = new Long(integer + "");
        page.setTotalCount(result.intValue());
        List<Banner> banners = bannerDao.selectBanner(page.getFirstResult() - 1, page.getPageSize());
        PageJson pageJson = new PageJson();
        pageJson.setRows(banners);
        pageJson.setTotal(integer);
        return pageJson;
    }

    @Override
    public Error addBanner(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setCreateTime(new Date());
        try {
            bannerDao.addBanner(banner);
            return new Error("8", "添加成功");
        } catch (Exception e) {
            return new Error("7", "添加失败");
        }
    }

    @Override
    public Error updateBanner(Banner banner) {

        try {
            bannerDao.updateBanner(banner);
            return new Error("9", "修改成功");
        } catch (Exception e) {
            return new Error("10", "修改失败");
        }

    }

    @Override
    public Error deleteBanner(String id) {

        try {
            bannerDao.deleteBanner(id);
            return new Error("11", "删除成功");
        } catch (Exception e) {
            return new Error("12", "删除失败");
        }

    }
}
