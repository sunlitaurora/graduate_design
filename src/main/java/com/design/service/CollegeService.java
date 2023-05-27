package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.College;

import java.util.List;

public interface CollegeService extends IService<College> {
    /**
     * 查找学生相关的学科部
     */
    public List<College> queryStudentCollege();

    public List<College> queryCourseCollege();
}
