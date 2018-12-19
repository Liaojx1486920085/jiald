package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    //分页专辑
    public List<Album> selectAlbum();

    //总条数
    public Integer selectAlbumCount();

    //增加专辑
    public void addAlbum(Album album);

    //删除专辑
    public void deleteAlbum(String id);
}
