package com.design.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Course;
import com.design.mapper.CourseMapper;
import com.design.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService, Serializable {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public IPage<Course> getCoursePage(int currentPage, int pageSize) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getCoursePage(page);
    }

    @Override
    public IPage<Course> getCoursePageByCid(int currentPage, int pageSize, String cid) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getCoursePageByCid(page, cid);
    }

    @Override
    public IPage<Course> getCoursePageByCname(int currentPage, int pageSize, String cname) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getCoursePageByCname(page, cname);
    }

    @Override
    public IPage<Course> getCoursePageByType(int currentPage, int pageSize, String type) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getCoursePageByType(page, type);
    }

    @Override
    public List<Course> getCourseByCollege(String college) {
        return courseMapper.getCourseByCollege(college);
    }

    @Override
    public IPage<Course> getCoursePageByCollege(int currentPage, int pageSize, String college) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return courseMapper.getCoursePageByCollege(page, college);
    }

    @Override
    public IPage<Course> getAllCoursePage(int currentPage, int pageSize) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getAllCoursePage(page);
    }

    @Override
    public IPage<Course> getAllCoursePageByCid(int currentPage, int pageSize, String cid) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getAllCoursePageByCid(page, cid);
    }

    @Override
    public IPage<Course> getAllCoursePageByCname(int currentPage, int pageSize, String cname) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getAllCoursePageByCname(page, cname);
    }

    @Override
    public IPage<Course> getAllCoursePageByType(int currentPage, int pageSize, String type) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        return courseMapper.getAllCoursePageByType(page, type);
    }

    @Override
    public List<Course> getAllCourseByCollege(String college) {
        return courseMapper.getAllCourseByCollege(college);
    }

    @Override
    public IPage<Course> getAllCoursePageByCollege(int currentPage, int pageSize, String college) {
        Page<Course> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return courseMapper.getAllCoursePageByCollege(page, college);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateById(course);
    }

    @Override
    public void deleteCourse(String cid) {
        courseMapper.deleteById(cid);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.insert(course);
    }

}
