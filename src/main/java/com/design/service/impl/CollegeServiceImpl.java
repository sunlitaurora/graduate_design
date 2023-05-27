package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.College;
import com.design.mapper.CollegeMapper;
import com.design.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService, Serializable {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> queryStudentCollege() {
        LambdaQueryWrapper<College> lqw = new LambdaQueryWrapper<>();
        lqw.ne(College::getId, 1);
        return collegeMapper.selectList(lqw);
    }

    @Override
    public List<College> queryCourseCollege() {
        return collegeMapper.selectList(null);
    }
}
