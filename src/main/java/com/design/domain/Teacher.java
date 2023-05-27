package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("teacher")
public class Teacher implements java.io.Serializable {
    //序列化
    private static final long serialVersionUID = 1L;
    //教师编号
    @TableId(value = "Tid", type = IdType.INPUT)
    private String tid;
    //教师姓名
    @TableField("Tname")
    private String tname;
    //教师性别
    @TableField("Tsex")
    private String tsex;
    //教师密码
    @TableField("Tpassword")
    private String tpassword;
    //教师手机号
    @TableField("Tphone")
    private String tphone;
    //教师邮箱
    @TableField("Temail")
    private String temail;

    /**
     * 默认构造方法
     */
    public Teacher() {

    }
}
