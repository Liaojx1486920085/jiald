package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Album implements Serializable {

    private String id;

    private String name;

    private Integer score;

    private String brodecast;

    private String author;

    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicTime;

    private String count;

    private String coverImg;

    private Integer status;

    private List<Chapter> children;

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", brodecast='" + brodecast + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publicTime=" + publicTime +
                ", count='" + count + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", status=" + status +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(name, album.name) &&
                Objects.equals(score, album.score) &&
                Objects.equals(brodecast, album.brodecast) &&
                Objects.equals(author, album.author) &&
                Objects.equals(description, album.description) &&
                Objects.equals(publicTime, album.publicTime) &&
                Objects.equals(count, album.count) &&
                Objects.equals(coverImg, album.coverImg) &&
                Objects.equals(status, album.status) &&
                Objects.equals(children, album.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score, brodecast, author, description, publicTime, count, coverImg, status, children);
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getBrodecast() {
        return brodecast;
    }

    public void setBrodecast(String brodecast) {
        this.brodecast = brodecast;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String name, Integer score, String brodecast, String author, String description, Date publicTime, String count, String coverImg, Integer status, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.brodecast = brodecast;
        this.author = author;
        this.description = description;
        this.publicTime = publicTime;
        this.count = count;
        this.coverImg = coverImg;
        this.status = status;
        this.children = children;
    }
}
