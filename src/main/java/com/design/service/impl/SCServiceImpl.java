package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.SC;
import com.design.mapper.SCMapper;
import com.design.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SCServiceImpl extends ServiceImpl<SCMapper, SC> implements SCService, Serializable {
    @Autowired
    SCMapper scMapper;

    @Override
    public SC existCourse(String cid, String sid, String tid) {
        LambdaQueryWrapper<SC> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SC::getSid, sid).eq(SC::getCid, cid).eq(SC::getTid, tid);
        return scMapper.selectOne(lqw);
    }

    @Override
    public int selectCourse(String cid, String sid, String tid) {
        SC sc = new SC();
        sc.setCid(cid);
        sc.setSid(sid);
        sc.setTid(tid);
        return scMapper.insert(sc);
    }

    @Override
    public int deleteSC(String cid, String sid, String tid) {
        LambdaQueryWrapper<SC> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SC::getCid, cid).eq(SC::getSid, sid).eq(SC::getTid, tid);
        return scMapper.delete(lqw);
    }
}
