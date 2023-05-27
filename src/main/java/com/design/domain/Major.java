package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("major")
public class Major {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("major")
    private String major;

    @TableField("college_id")
    private Integer collegeId;
}
