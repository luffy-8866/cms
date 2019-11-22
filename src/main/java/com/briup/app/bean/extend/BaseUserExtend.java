package com.briup.app.bean.extend;

import com.briup.app.bean.BaseRole;
import com.briup.app.bean.BaseUser;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 用户拓展类
 * @author: charles
 * @create: 2019-11-15 15:08
 **/

public class BaseUserExtend extends BaseUser {
    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
