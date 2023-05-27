package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("classes")
public class Classes {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("classes")
    private String classes;

    @TableField("major_id")
    private Integer majorId;
}
