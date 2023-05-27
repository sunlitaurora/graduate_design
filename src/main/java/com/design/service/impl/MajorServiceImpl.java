package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Major;
import com.design.mapper.MajorMapper;
import com.design.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService, Serializable {
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> queryStudentMajor(Integer collegeId) {
        LambdaQueryWrapper<Major> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Major::getCollegeId, collegeId);
        return majorMapper.selectList(lqw);
    }

    @Override
    public List<Major> queryCourseMajor(Integer collegeId) {
        LambdaQueryWrapper<Major> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Major::getCollegeId, collegeId);
        return majorMapper.selectList(lqw);
    }
}
