package com.design.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.StuExitSelect;
import com.design.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SelectCourseMapper extends BaseMapper<StuExitSelect> {
    /**
     * 查看课程已选人数
     *
     * @param page
     * @param tid
     * @return
     */
    @Select("SELECT cname, courseplan.cid, tid, totalNum,( SELECT count(*) FROM sc WHERE cid = courseplan.cid AND tid = #{tid}) stuSum " +
            "FROM course,courseplan " +
            "WHERE courseplan.cid = course.cid AND courseplan.tid = #{tid}")
    public IPage<StuExitSelect> getLookByTid(Page<StuExitSelect> page, @Param("tid") String tid);

    /**
     * 查看课程的学生详细信息
     *
     * @param page
     * @param cid
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, c.classes, m.major, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "INNER JOIN sc ON s.Sid = sc.sid " +
            "WHERE sc.cid = #{cid} AND sc.tid = #{tid}")
    public IPage<Student> getByStuCid(Page<Student> page, @Param("cid") String cid, @Param("tid") String tid);

    /**
     * 获取没有添加成绩的学生信息
     *
     * @param page
     * @param cid
     * @param tid
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, c.classes, m.major, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "INNER JOIN sc ON s.Sid = sc.sid " +
            "WHERE sc.cid = #{cid} AND sc.tid = #{tid} AND not exists(select 1 from grade g where g.sid = s.sid)")
    public IPage<Student> getEndByStuCid(Page<Student> page, @Param("cid") String cid, @Param("tid") String tid);

    /**
     * 根据学号退选
     *
     * @param page
     * @param sid
     * @return
     */
    @Select("SELECT cname,sc.cid,sid,sc.tid " +
            "FROM course,sc " +
            "WHERE sc.cid=course.cid AND sid = #{sid} AND not exists(select 1 from grade g where g.cid=course.cid )")
    public IPage<StuExitSelect> getExitBySid(Page<Student> page, @Param("sid") String sid);
}
