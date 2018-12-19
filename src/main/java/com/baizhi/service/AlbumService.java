package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Error;

import java.util.List;

public interface AlbumService {

    public List<Album> selectAlbum();

    //增加专辑
    public Error addAlbum(Album album);

    //删除专辑
    public Error deleteAlbum(String id);

}
