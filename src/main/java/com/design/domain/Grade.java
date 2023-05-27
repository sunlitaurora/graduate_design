package com.design.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("grade")
public class Grade {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("cid")
    private String cid;

    @TableField(exist = false)
    private String cname;

    @TableField("sid")
    private String sid;

    @TableField("grade")
    private Integer grade;

    @TableField("credits")
    private Integer credits;


    @Override
    public String toString() {
        return "Grade [cid=" + cid + ", sid=" + sid + ", grade=" + grade + ", credits=" + credits + "]";
    }


}
