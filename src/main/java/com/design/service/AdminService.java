package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Admin;

public interface AdminService extends IService<Admin> {
    /**
     * 管理员登录设置
     *
     * @param aname     管理员账号（唯一）
     * @param apassword 密码
     * @return
     */
    public Admin queryByNamePwd(String aname, String apassword);
}
