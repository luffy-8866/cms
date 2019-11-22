package com.briup.app.service.impl;

import org.springframework.stereotype.Service;

import com.briup.app.bean.extend.BaseUserExtend;
import com.briup.app.dao.extend.BaseUserExtendMapper;
import com.briup.app.service.IBaseUserService;

import javax.annotation.Resource;

/**
 * @program: cms_jd1911
 * @description: 用户业务实现类
 * @author: charles
 * @create: 2019-11-15 15:18
 **/
@Service
public class BaseUserServiceImpl implements IBaseUserService {
    @Resource
    private BaseUserExtendMapper baseUserExtendMapper;
    @Override
    public BaseUserExtend findById(long id) {
        return baseUserExtendMapper.selectById(id);
    }
}
