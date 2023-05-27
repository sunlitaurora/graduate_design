package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    public IPage<Course> getCoursePage(int currentPage, int pageSize);

    public IPage<Course> getCoursePageByCid(int currentPage, int pageSize, String cid);

    public IPage<Course> getCoursePageByCname(int currentPage, int pageSize, String cname);

    public IPage<Course> getCoursePageByType(int currentPage, int pageSize, String type);

    public List<Course> getCourseByCollege(String college);

    public IPage<Course> getCoursePageByCollege(int currentPage, int pageSize, String college);

    public IPage<Course> getAllCoursePage(int currentPage, int pageSize);

    public IPage<Course> getAllCoursePageByCid(int currentPage, int pageSize, String cid);

    public IPage<Course> getAllCoursePageByCname(int currentPage, int pageSize, String cname);

    public IPage<Course> getAllCoursePageByType(int currentPage, int pageSize, String type);

    public List<Course> getAllCourseByCollege(String college);

    public IPage<Course> getAllCoursePageByCollege(int currentPage, int pageSize, String college);

    public void updateCourse(Course course);

    public void deleteCourse(String cid);

    public int addCourse(Course course);
}
