package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.design.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where s.sid like #{sid}")
    public Student getStudentBySid(String sid);

    /**
     * 分页查询全部学生
     *
     * @param page
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id")
    public IPage<Student> getStudentPage(Page<Student> page);

    /**
     * 根据学号分页
     *
     * @param page
     * @param sid
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where s.sid like #{sid}")
    public IPage<Student> getStudentPageBySid(Page<Student> page, @Param("sid") String sid);

    /**
     * 根据班级获得总数
     *
     * @param classes
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where c.classes like #{classes}")
    public List<Student> getStudentByClasses(@Param("classes") String classes);

    /**
     * 根据班级分页
     *
     * @param page
     * @param classes
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where c.classes like #{classes}")
    public IPage<Student> getStudentPageByClasses(Page<Student> page, @Param("classes") String classes);

    /**
     * 根据专业获得总数
     *
     * @param major
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where m.major like #{major}")
    public List<Student> getStudentByMajor(@Param("major") String major);

    /**
     * 根据班级分页
     *
     * @param page
     * @param major
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where m.major like #{major}")
    public IPage<Student> getStudentPageByMajor(Page<Student> page, @Param("major") String major);

    /**
     * 根据学科部获得总数
     *
     * @param college
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where cl.college like #{college}")
    public List<Student> getStudentByCollege(@Param("college") String college);

    /**
     * 根据学科部分页
     *
     * @param page
     * @param college
     * @return
     */
    @Select("SELECT s.Sid, s.Sname, s.Sidcard, s.Ssex, s.Spassword, s.Sage, s.classes classesId , c.classes, s.major majorId, m.major, s.college collegeId, cl.college " +
            "FROM student s " +
            "LEFT JOIN classes c ON s.classes = c.id " +
            "LEFT JOIN major m ON s.major = m.id " +
            "LEFT JOIN college cl ON s.college = cl.id " +
            "where cl.college like #{college}")
    public IPage<Student> getStudentPageByCollege(Page<Student> page, @Param("college") String college);
}
