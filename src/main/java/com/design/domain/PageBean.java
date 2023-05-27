package com.design.domain;

import lombok.Data;

import java.util.List;

//分页查询的JavaBean
@Data
public class PageBean<T> {
    //总记录数
    private Long totalCount;

    //当前页
    private int currentPage;

    //当前页数据
    private List<T> rows;
}
