package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Classes;
import com.design.mapper.ClassesMapper;
import com.design.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService, Serializable {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> queryStudentClasses(Integer majorId) {
        LambdaQueryWrapper<Classes> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Classes::getMajorId, majorId);
        return classesMapper.selectList(lqw);
    }
}
