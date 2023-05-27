package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("courseplan")
public class CoursePlan implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //开课班级
    @TableField("courseclass")
    private String courseclass;
    //上课周
    @TableField("courseweek")
    private String courseweek;
    //上课时间
    @TableField("coursetime")
    private String coursetime;
    //课程编号
    @TableField("cid")
    private String cid;
    @TableField(exist = false)
    private String cname;
    //教师编号
    @TableField("tid")
    private String tid;
    //上课教室
    @TableField("classroom")
    private String classroom;
    //学分
    @TableField("credits")
    private Integer credits;
    //学时
    @TableField("period")
    private Integer period;
    //总人数
    @TableField("totalNum")
    private Integer totalNum;

    @TableField(exist = false)
    private String tname;

    /**
     * 默认构造方法
     */
    public CoursePlan() {

    }
}

