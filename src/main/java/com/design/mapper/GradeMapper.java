package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.Grade;
import com.design.domain.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.awt.image.ImageProducer;
import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
    /**
     * 查询学生自己的总学分
     */
    @Select("SELECT SUM(credits) " +
            "FROM grade " +
            "WHERE sid = #{sid}")
    public Integer queryCreditsSum(String sid);

    /**
     * 学生查看本人已修改课程
     */
    @Select("SELECT g.cid,c.Cname,g.grade,g.credits " +
            "FROM grade g " +
            "INNER JOIN course c ON c.cid = g.Cid " +
            "WHERE g.sid = #{sid}")
    public IPage<Grade> getEedCourseBySid(Page<Grade> page, @Param("sid") String sid);

}
