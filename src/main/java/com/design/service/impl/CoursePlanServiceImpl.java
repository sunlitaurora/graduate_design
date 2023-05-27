package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.CourseGrade;
import com.design.domain.CoursePlan;
import com.design.domain.Grade;
import com.design.mapper.CoursePlanMapper;
import com.design.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CoursePlanServiceImpl extends ServiceImpl<CoursePlanMapper, CoursePlan> implements CoursePlanService, Serializable {
    @Autowired
    private CoursePlanMapper coursePlanMapper;

    @Override
    public CoursePlan findByCoursetimeAndClassroom(String coursetime, String classroom) {
        LambdaQueryWrapper<CoursePlan> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CoursePlan::getCoursetime, coursetime).eq(CoursePlan::getClassroom, classroom);
        return coursePlanMapper.selectOne(lqw);
    }

    @Override
    public CoursePlan findByCoursetimeAndTid(String coursetime, String tid) {
        LambdaQueryWrapper<CoursePlan> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CoursePlan::getCoursetime, coursetime).eq(CoursePlan::getTid, tid);
        return coursePlanMapper.selectOne(lqw);
    }

    @Override
    public int addCoursePlan(String courseweek, String coursetime, String cid, String tid, String classroom, Integer credits, Integer period, Integer totalNum) {
        return coursePlanMapper.insertCoursePlan(courseweek, coursetime, cid, tid, classroom, credits, period, totalNum);
    }

    @Override
    public IPage<CoursePlan> getCoursePlanPageByTid(int currentPage, int pageSize, String tid) {
        Page<CoursePlan> page = new Page<>(currentPage, pageSize);
        return coursePlanMapper.getCoursePlanPageByTid(page, tid);
    }

    @Override
    public void updateCoursePlan(CoursePlan coursePlan) {
        LambdaUpdateWrapper<CoursePlan> luw = new LambdaUpdateWrapper<>();
        luw.eq(CoursePlan::getCourseclass, coursePlan.getCourseclass());
        coursePlanMapper.update(coursePlan, luw);
    }

    @Override
    public void deleteCoursePlan(String courseclass) {
        LambdaQueryWrapper<CoursePlan> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CoursePlan::getCourseclass, courseclass);
        coursePlanMapper.delete(lqw);
    }

    @Override
    public Integer getCreditsByCidAndTid(String cid, String tid) {
        return coursePlanMapper.getCreditsByCidAndTid(cid, tid);
    }

    @Override
    public IPage<CourseGrade> getCourseGrade(int currentPage, int pageSize, String cid) {
        Page<Grade> page = new Page<>(currentPage, pageSize);
        return coursePlanMapper.getCourseGrade(page, cid);
    }

    @Override
    public IPage<CoursePlan> getCourseResult(int currentPage, int pageSize, String sid) {
        Page<CoursePlan> page = new Page<>(currentPage, pageSize);
        return coursePlanMapper.getCourseResult(page, sid);
    }
}
