package com.briup.app.dao.extend;

import java.util.List;

import com.briup.app.bean.Comment;

public interface CommentExtendMapper {
	List<Comment> selectByArticle(long id);
}
