package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Teacher;
import com.design.mapper.TeacherMapper;
import com.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService, Serializable {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public IPage<Teacher> getTeacherPage(int currentPage, int pageSize) {
        Page<Teacher> page = new Page<>(currentPage, pageSize);
        return teacherMapper.selectPage(page, null);
    }

    @Override
    public IPage<Teacher> getTeacherPageBySid(int currentPage, int pageSize, String tid) {
        Page<Teacher> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        LambdaQueryWrapper<Teacher> lqw = new LambdaQueryWrapper<>();
        lqw.like(Teacher::getTid, tid);
        return teacherMapper.selectPage(page, lqw);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateById(teacher);
    }

    @Override
    public void deleteTeacher(String tid) {
        teacherMapper.deleteById(tid);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public Teacher queryByNamePwd(String tid, String pwd) {
        LambdaQueryWrapper<Teacher> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Teacher::getTid, tid).eq(Teacher::getTpassword, pwd);
        return teacherMapper.selectOne(lqw);
    }
}
