package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Grade;

public interface GradeService extends IService<Grade> {
    public void insertGrade(Grade grade);

    public IPage<Grade> getEedCourseBySid(int currentPage, int pageSize, String sid);

    public Integer queryCreditsSum(String sid);
}
