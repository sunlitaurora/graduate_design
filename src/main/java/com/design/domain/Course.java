package com.design.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("course")
public class Course implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    @TableId(value = "Cid", type = IdType.AUTO)
    private String cid;
    //课程名称
    @TableField("Cname")
    private String cname;
    //课程介绍
    @TableField("Cintroduction")
    private String cintroduction;
    //类型
    @TableField("Type")
    private String type;
    //所属学院
    @TableField("belongCollege")
    private Integer collegeId;

    @TableField(exist = false)
    private String college;
    //所属专业
    @TableField("belongMajor")
    private Integer majorId;

    @TableField(exist = false)
    private String major;

    @TableField(exist = false)
    private String tid;

    @TableField(exist = false)
    private String tname;

    /**
     * 默认构造方法
     */
    public Course() {

    }
}

