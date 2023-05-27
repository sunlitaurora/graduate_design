package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.CourseGrade;
import com.design.domain.CoursePlan;

import java.util.List;

public interface CoursePlanService extends IService<CoursePlan> {
    public CoursePlan findByCoursetimeAndClassroom(String coursetime, String classroom);

    public CoursePlan findByCoursetimeAndTid(String coursetime, String tid);

    public int addCoursePlan(String courseweek, String coursetime, String cid, String tid, String classroom, Integer credits, Integer period, Integer totalNum);

    public IPage<CoursePlan> getCoursePlanPageByTid(int currentPage, int pageSize, String tid);

    public void updateCoursePlan(CoursePlan coursePlan);

    public void deleteCoursePlan(String courseclass);

    public Integer getCreditsByCidAndTid(String cid, String tid);

    public IPage<CourseGrade> getCourseGrade(int currentPage, int pageSize, String cid);

    public IPage<CoursePlan> getCourseResult(int currentPage, int pageSize, String sid);
}
