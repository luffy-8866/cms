package com.briup.app.dao.extend;

import java.util.List;

import com.briup.app.bean.extend.ArticleExtend;

public interface ArticleExtendMapper {
	List<ArticleExtend> selectAll();
	ArticleExtend selectById(long id);
}
