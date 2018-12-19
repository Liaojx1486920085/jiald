package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Guru implements Serializable {

    private String id;

    private String dharnaName;

    private String photo;

    private Integer status;

    private Date createTime;

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", dharnaName='" + dharnaName + '\'' +
                ", photo='" + photo + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guru guru = (Guru) o;
        return Objects.equals(id, guru.id) &&
                Objects.equals(dharnaName, guru.dharnaName) &&
                Objects.equals(photo, guru.photo) &&
                Objects.equals(status, guru.status) &&
                Objects.equals(createTime, guru.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dharnaName, photo, status, createTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDharnaName() {
        return dharnaName;
    }

    public void setDharnaName(String dharnaName) {
        this.dharnaName = dharnaName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Guru(String id, String dharnaName, String photo, Integer status, Date createTime) {
        this.id = id;
        this.dharnaName = dharnaName;
        this.photo = photo;
        this.status = status;
        this.createTime = createTime;
    }

    public Guru() {
    }
}
