package com.design.domain;

import lombok.Data;

@Data
public class StuSelectResult implements java.io.Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    //学生班级
    private String classes;
    //上课时间
    private String coursetime;
    //上课周
    private String courseweek;
    //课程名称
    private String cname;
    //课程教室
    private String classroom;
    //学分
    private String credits;
    //学时
    private String period;
    //任课教师姓名
    private String tname;
}

