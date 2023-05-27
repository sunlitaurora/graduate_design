package com.design.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Grade;
import com.design.mapper.GradeMapper;
import com.design.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService, Serializable {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public void insertGrade(Grade grade) {
        gradeMapper.insert(grade);
    }

    @Override
    public IPage<Grade> getEedCourseBySid(int currentPage, int pageSize, String sid) {
        Page<Grade> page = new Page<>(currentPage, pageSize);
        return gradeMapper.getEedCourseBySid(page, sid);
    }

    @Override
    public Integer queryCreditsSum(String sid) {
        return gradeMapper.queryCreditsSum(sid);
    }
}
