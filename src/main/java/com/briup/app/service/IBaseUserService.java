package com.briup.app.service;

import com.briup.app.bean.extend.BaseUserExtend;

/**
 * @program: cms_jd1911
 * @description: 用户接口
 * @author: charles
 * @create: 2019-11-15 15:17
 **/

public interface IBaseUserService {
    BaseUserExtend findById(long id);
}
