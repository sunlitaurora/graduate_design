package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.SC;

public interface SCService extends IService<SC> {
    public SC existCourse(String cid, String sid, String tid);

    public int selectCourse(String cid, String sid, String tid);

    public int deleteSC(String cid, String sid, String tid);
}
