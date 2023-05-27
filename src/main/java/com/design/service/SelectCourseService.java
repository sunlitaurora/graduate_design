package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.design.domain.SC;
import com.design.domain.StuExitSelect;
import com.design.domain.Student;

public interface SelectCourseService {
    public IPage<StuExitSelect> getLookByTid(int currentPage, int pageSize, String tid);

    public IPage<Student> getByStuCid(int currentPage, int pageSize, String cid, String tid);

    public IPage<Student> getEndByStuCid(int currentPage, int pageSize, String cid, String tid);

    public IPage<StuExitSelect> getExitBySid(int currentPage, int pageSize, String sid);
}
