package com.briup.app.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app.bean.Category;
import com.briup.app.service.ICategoryService;
import com.briup.app.utils.Message;
import com.briup.app.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@ApiOperation(value="查询所有栏目")
	@GetMapping("findAll")
	public Message findAll() {
		List<Category> list=categoryService.findAll();
		return MessageUtil.success(list);
	}
	@ApiOperation(value="保存更新栏目")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="主键",paramType="form"),
			@ApiImplicitParam(name="name",value="栏目名称",paramType="form",required = true),
			@ApiImplicitParam(name="description",value="栏目描述",paramType="form"),
			@ApiImplicitParam(name="no",value="栏目序号",paramType="form"),
			@ApiImplicitParam(name="parent_id",value="父栏目id",paramType="form")
	
	})
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdatec(
						Long id,
						@NotNull String name,
						String description,
						Integer no,
						Long parent_id
			) {
		Category category=new Category();
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		category.setNo(no);
		category.setParentId(parent_id);
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	}
	@ApiOperation(value="通过Id查询栏目")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	@ApiOperation(value="批量删除栏目")
	@PostMapping("batchDelete")
	public Message batchDelete(long[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("删除成功");
	}
}
