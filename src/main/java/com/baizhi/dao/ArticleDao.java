package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    public List<Article> selectArticle(@Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd);

    public Integer selectArticleCount();

    public void addArticle(Article article);
}
