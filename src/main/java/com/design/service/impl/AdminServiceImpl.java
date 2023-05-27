package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Admin;
import com.design.mapper.AdminMapper;
import com.design.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService, Serializable {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登录设置
     *
     * @param aname     管理员账号（唯一）
     * @param apassword 密码
     * @return
     */
    @Override
    public Admin queryByNamePwd(String aname, String apassword) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Admin::getAname, aname).eq(Admin::getApassword, apassword);
        return adminMapper.selectOne(lqw);
    }
}
