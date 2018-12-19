package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Chapter implements Serializable {

    private String id;

    private String name;

    private String url;

    private Double size;

    private String length;

    private String times;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String AlbumId;

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", length='" + length + '\'' +
                ", times='" + times + '\'' +
                ", createTime=" + createTime +
                ", AlbumId='" + AlbumId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(id, chapter.id) &&
                Objects.equals(name, chapter.name) &&
                Objects.equals(url, chapter.url) &&
                Objects.equals(size, chapter.size) &&
                Objects.equals(length, chapter.length) &&
                Objects.equals(times, chapter.times) &&
                Objects.equals(createTime, chapter.createTime) &&
                Objects.equals(AlbumId, chapter.AlbumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, size, length, times, createTime, AlbumId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(String albumId) {
        AlbumId = albumId;
    }

    public Chapter(String id, String name, String url, Double size, String length, String times, Date createTime, String albumId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.size = size;
        this.length = length;
        this.times = times;
        this.createTime = createTime;
        AlbumId = albumId;
    }
}
