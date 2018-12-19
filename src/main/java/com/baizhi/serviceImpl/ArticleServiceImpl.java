package com.baizhi.serviceImpl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.ArticleJson;
import com.baizhi.entity.Error;
import com.baizhi.entity.Page;
import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ArticleJson selectArticle(Page page) {
        int integer = articleDao.selectArticleCount();
        Long result = 0L;
        result = new Long(integer + "");
        page.setTotalCount(result.intValue());
        List<Article> articles = articleDao.selectArticle(page.getFirstResult() - 1, page.getPageSize());
        ArticleJson articleJson = new ArticleJson();
        articleJson.setRows(articles);
        articleJson.setTotal(integer);
        return articleJson;
    }

    @Override
    public Error addArticle(Article article) {
        System.out.println("进入Service层的对象" + article.toString());
        article.setId(UUID.randomUUID().toString());
        article.setPublicTime(new Date());
        try {
            articleDao.addArticle(article);
            return new Error("17", "增加章节成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Error("18", "增加章节失败");
        }
    }
}
