package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sc")
public class SC implements java.io.Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    //id主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //学号
    @TableField("sid")
    private String sid;
    //课程编号
    @TableField("cid")
    private String cid;
    //教师编号
    @TableField("tid")
    private String tid;

    /**
     * 默认构造方法
     */
    public SC() {

    }
}


