package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Error;
import com.baizhi.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumDao albumDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Album> selectAlbum() {
//        int integer = albumDao.selectAlbumCount();
//        Long result = 0L;
//        result = new Long(integer+"");
//        page.setTotalCount(result.intValue());
        List<Album> albums = albumDao.selectAlbum();
//        System.out.println(albums == null);
//        for (Album album : albums) {
//            System.out.println(album);
//        }
//        ArticleJson pageJson = new ArticleJson();
//        pageJson.setRows(albums);
//        pageJson.setTotal(integer);
        return albums;
    }

    @Override
    public Error addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setPublicTime(new Date());
        album.setCount("0");
        try {
            albumDao.addAlbum(album);
            return new Error("13", "增加专辑成功");
        } catch (Exception e) {
            return new Error("14", "增加专辑失败");
        }
    }

    @Override
    public Error deleteAlbum(String id) {
        try {
            albumDao.deleteAlbum(id);
            return new Error("17", "删除专辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Error("17", "删除专辑成功");
        }
    }
}
