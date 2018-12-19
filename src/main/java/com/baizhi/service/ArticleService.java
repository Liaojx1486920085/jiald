package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.ArticleJson;
import com.baizhi.entity.Error;
import com.baizhi.entity.Page;

public interface ArticleService {

    public ArticleJson selectArticle(Page page);

    public Error addArticle(Article article);

}
