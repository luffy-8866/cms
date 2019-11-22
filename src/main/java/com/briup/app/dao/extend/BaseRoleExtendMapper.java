package com.briup.app.dao.extend;

import com.briup.app.bean.BaseRole;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description:
 * @author: charles
 * @create: 2019-11-15 15:13
 **/

public interface BaseRoleExtendMapper {
    List<BaseRole> selectByUserId(long id);
}
