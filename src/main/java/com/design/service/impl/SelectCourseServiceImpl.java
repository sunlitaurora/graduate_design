package com.design.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.StuExitSelect;
import com.design.domain.Student;
import com.design.mapper.SCMapper;
import com.design.mapper.SelectCourseMapper;
import com.design.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SelectCourseServiceImpl implements SelectCourseService, Serializable {
    @Autowired
    SelectCourseMapper selectCourseMapper;
    @Autowired
    SCMapper scMapper;

    @Override
    public IPage<StuExitSelect> getLookByTid(int currentPage, int pageSize, String tid) {
        Page<StuExitSelect> page = new Page<>(currentPage, pageSize);
        return selectCourseMapper.getLookByTid(page, tid);
    }

    @Override
    public IPage<Student> getByStuCid(int currentPage, int pageSize, String cid, String tid) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return selectCourseMapper.getByStuCid(page, cid, tid);
    }

    @Override
    public IPage<Student> getEndByStuCid(int currentPage, int pageSize, String cid, String tid) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return selectCourseMapper.getEndByStuCid(page, cid, tid);
    }

    @Override
    public IPage<StuExitSelect> getExitBySid(int currentPage, int pageSize, String sid) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        return selectCourseMapper.getExitBySid(page, sid);
    }
}
