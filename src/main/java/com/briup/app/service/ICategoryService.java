package com.briup.app.service;

import java.util.List;

import com.briup.app.bean.Category;
import com.briup.app.utils.CustomerExcepion;

public interface ICategoryService {
	List<Category> findAll();
	void saveOrUpdate(Category category) ;
	void deleteById(long id) throws CustomerExcepion;
	void batchDelete(long[] ids) throws CustomerExcepion;


}
