package com.briup.app.service;

import java.util.List;

import com.briup.app.bean.Article;
import com.briup.app.bean.extend.ArticleExtend;
import com.briup.app.utils.CustomerExcepion;

public interface IArticleService {
	List<Article> findAll();
	List<ArticleExtend> cascadeFindAll();
	ArticleExtend findById(long id);
	void saveOrUpdate(Article article) throws CustomerExcepion;
}
