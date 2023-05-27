package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.CourseGrade;
import com.design.domain.CoursePlan;
import com.design.domain.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CoursePlanMapper extends BaseMapper<CoursePlan> {
    @Select("SELECT co.courseclass,co.courseweek,co.coursetime,co.cid,c.Cname,co.tid,co.classroom,co.credits,co.period,co.totalNum  " +
            "FROM courseplan co " +
            "LEFT JOIN course c on co.cid = c.Cid " +
            "where co.tid = #{tid}")
    public IPage<CoursePlan> getCoursePlanPageByTid(Page<CoursePlan> page, @Param("tid") String tid);

    /**
     * 根据课程编号查询该课程学分
     *
     * @param cid
     * @return
     */
    @Select("SELECT credits " +
            "FROM courseplan " +
            "WHERE cid = #{cid} AND tid = #{tid}")
    public Integer getCreditsByCidAndTid(@Param("cid") String cid, @Param("tid") String tid);

    /**
     * 根据课程id查询该课程的上课教师，以方便查询教师具体信息
     *
     * @param page
     * @param cid
     * @return
     */
    @Select("SELECT g.sid,s.Sname,g.grade " +
            "FROM grade g " +
            "INNER JOIN student s ON s.sid=g.sid " +
            "WHERE cid = #{cid}")
    public IPage<CourseGrade> getCourseGrade(Page<Grade> page, @Param("cid") String cid);

    @Select("SELECT course.cname,courseplan.courseclass,courseplan.courseclass,courseplan.coursetime,courseplan.courseweek," +
            "courseplan.classroom,courseplan.credits,courseplan.period,teacher.tname " +
            "FROM sc " +
            "INNER JOIN courseplan ON sc.cid = courseplan.cid " +
            "    AND sc.tid = courseplan.tid " +
            "INNER JOIN teacher ON sc.tid = teacher.Tid " +
            "INNER JOIN course ON sc.cid = course.Cid " +
            "WHERE sc.sid= #{sid}")
    public IPage<CoursePlan> getCourseResult(Page<CoursePlan> page, String sid);

    @Insert("INSERT INTO courseplan (courseclass, courseweek, coursetime, cid, tid, classroom, credits, period, totalNum) " +
            "SELECT CONCAT(cname, (SELECT COUNT(*) + 1 FROM courseplan WHERE courseclass LIKE CONCAT(cname, '%')),'班'), #{courseweek}, #{coursetime}, #{cid}, #{tid}, #{classroom}, #{credits}, #{period}, #{totalNum} " +
            "FROM course " +
            "WHERE cid = #{cid}")
    public int insertCoursePlan(@Param("courseweek") String courseweek, @Param("coursetime") String coursetime, @Param("cid") String cid,
                                @Param("tid") String tid, @Param("classroom") String classroom, @Param("credits") Integer credits,
                                @Param("period") Integer period, @Param("totalNum") Integer totalNum);
}
