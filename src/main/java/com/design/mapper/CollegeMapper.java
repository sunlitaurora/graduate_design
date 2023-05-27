package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.design.domain.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollegeMapper extends BaseMapper<College> {
}
