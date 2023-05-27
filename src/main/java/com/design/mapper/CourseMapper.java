package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 查询全部课程
     *
     * @param page
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getCoursePage(Page<Course> page);

    /**
     * 根据课程编号查询课程信息
     *
     * @param page
     * @param cid
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where c.cid like #{cid} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getCoursePageByCid(Page<Course> page, String cid);

    /**
     * 根据课程名称查询课程信息
     *
     * @param page
     * @param cname
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where c.cname like #{cname} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getCoursePageByCname(Page<Course> page, String cname);

    /**
     * 根据课程类型查询课程信息
     *
     * @param page
     * @param type
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where c.type like #{type} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getCoursePageByType(Page<Course> page, String type);

    /**
     * 根据学院获得总数
     *
     * @param college
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where cl.college like #{college} and not exists(select 1 from grade g where g.cid=c.cid )")
    public List<Course> getCourseByCollege(String college);

    /**
     * 根据学院查询课程信息
     *
     * @param page
     * @param college
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "where cl.college like #{college} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getCoursePageByCollege(Page<Course> page, String college);

    /**
     * 查询全部课程
     *
     * @param page
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getAllCoursePage(Page<Course> page);

    /**S
     * 根据课程编号查询课程信息
     *
     * @param page
     * @param cid
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where c.cid like #{cid} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getAllCoursePageByCid(Page<Course> page, String cid);

    /**
     * 根据课程名称查询课程信息
     *
     * @param page
     * @param cname
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where c.cname like #{cname} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getAllCoursePageByCname(Page<Course> page, String cname);

    /**
     * 根据课程类型查询课程信息
     *
     * @param page
     * @param type
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where c.type like #{type} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getAllCoursePageByType(Page<Course> page, String type);

    /**
     * 根据学院获得总数
     *
     * @param college
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where cl.college like #{college} and not exists(select 1 from grade g where g.cid=c.cid )")
    public List<Course> getAllCourseByCollege(String college);

    /**
     * 根据学院查询课程信息
     *
     * @param page
     * @param college
     * @return
     */
    @Select("SELECT c.Cid, c.Cname, c.Cintroduction, c.Type,c.belongCollege collegeId, cl.college, c.belongMajor majorId, m.major, co.tid, t.tname " +
            "FROM course c " +
            "LEFT JOIN major m ON c.belongMajor = m.id " +
            "LEFT JOIN college cl ON c.belongCollege = cl.id " +
            "LEFT JOIN courseplan co ON c.cid = co.cid " +
            "LEFT JOIN teacher t on co.tid = t.tid " +
            "where cl.college like #{college} and not exists(select 1 from grade g where g.cid=c.cid )")
    public IPage<Course> getAllCoursePageByCollege(Page<Course> page, String college);
}
