package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "Aname", type = IdType.AUTO)
    private String aname;

    @TableField("Apassword")
    private String apassword;

    public Admin() {
    }
}
