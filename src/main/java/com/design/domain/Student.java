package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    //序列化
    private static final long serialVersionUID = 1L;
    @TableId(value = "Sid", type = IdType.INPUT)
    private String sid;

    @TableField("Sname")
    private String sname;

    @TableField("Sidcard")
    private String sidcard;

    @TableField("Ssex")
    private String ssex;

    @TableField("Spassword")
    private String spassword;

    @TableField("Sage")
    private Integer sage;

    @TableField("classes")
    private Integer classesId;

    @TableField(exist = false)
    private String classes;

    @TableField("major")
    private Integer majorId;

    @TableField(exist = false)
    private String major;

    @TableField("college")
    private Integer collegeId;

    @TableField(exist = false)
    private String college;

    @TableField(exist = false)
    private Integer credits;

    /**
     * 默认构造方法
     */
    public Student() {

    }
}