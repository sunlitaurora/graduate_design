package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Major;

import java.util.List;

public interface MajorService extends IService<Major> {
    public List<Major> queryStudentMajor(Integer collegeId);

    public List<Major> queryCourseMajor(Integer collegeId);
}
