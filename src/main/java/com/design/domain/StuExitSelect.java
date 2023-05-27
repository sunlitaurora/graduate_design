package com.design.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class StuExitSelect implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String cid;
    //课程名称
    private String cname;
    //教师编号
    private String tid;
    //学生学号
    private String sid;
    //总人数
    private Integer totalNum;
    //学生总数
    private Integer stuSum;
}

