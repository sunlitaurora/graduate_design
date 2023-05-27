package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Classes;

import java.util.List;

public interface ClassesService extends IService<Classes> {
    public List<Classes> queryStudentClasses(Integer majorId);
}
