package com.briup.app.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.app.bean.Article;
import com.briup.app.bean.ArticleExample;
import com.briup.app.bean.extend.ArticleExtend;
import com.briup.app.dao.ArticleMapper;
import com.briup.app.dao.extend.ArticleExtendMapper;
import com.briup.app.service.IArticleService;
import com.briup.app.utils.CustomerExcepion;

/**
 * @program: cms_jd1911
 * @description: 文章的业务实现类
 * @author: charles
 * @create: 2019-11-12 10:21
 **/
@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerExcepion {
        if(article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        } else {
            // 标题不能重名
            ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());

            List<Article> articles = articleMapper.selectByExample(example);
            if(articles.size()>0){
                throw new CustomerExcepion("标题不能重复");
            }
            // 初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpDown(0l);
            article.setThumpUp(0l);
            articleMapper.insert(article);
        }
    }
}
