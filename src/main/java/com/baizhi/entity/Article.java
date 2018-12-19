package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Article implements Serializable {

    private String id;

    private String title;

    private String articlePic;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicTime;

    private String guruId;

    private Guru guru;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", articlePic='" + articlePic + '\'' +
                ", content='" + content + '\'' +
                ", publicTime=" + publicTime +
                ", guruId='" + guruId + '\'' +
                ", guru=" + guru +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(title, article.title) &&
                Objects.equals(articlePic, article.articlePic) &&
                Objects.equals(content, article.content) &&
                Objects.equals(publicTime, article.publicTime) &&
                Objects.equals(guruId, article.guruId) &&
                Objects.equals(guru, article.guru);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, articlePic, content, publicTime, guruId, guru);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Article(String id, String title, String articlePic, String content, Date publicTime, String guruId, Guru guru) {
        this.id = id;
        this.title = title;
        this.articlePic = articlePic;
        this.content = content;
        this.publicTime = publicTime;
        this.guruId = guruId;
        this.guru = guru;
    }

    public Article() {
    }
}
