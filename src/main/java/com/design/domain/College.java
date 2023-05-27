package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("college")
public class College {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("college")
    private String college;
}