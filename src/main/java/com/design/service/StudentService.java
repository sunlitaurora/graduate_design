package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService extends IService<Student> {
    public IPage<Student> getStudentPage(int currentPage, int pageSize);

    public IPage<Student> getStudentPageBySid(int currentPage, int pageSize, String sid);

    public List<Student> getStudentByClasses(String classes);

    public IPage<Student> getStudentPageByClasses(int currentPage, int pageSize, String classes);

    public List<Student> getStudentByMajor(String major);

    public IPage<Student> getStudentPageByMajor(int currentPage, int pageSize, String major);

    public List<Student> getStudentByCollege(String college);

    public IPage<Student> getStudentPageByCollege(int currentPage, int pageSize, String college);

    public void updateStudent(Student student);

    public void deleteStudent(String sid);

    public int addStudent(Student student);

    public Student getStudentBySid(String sid);

    /**
     * 学生登录设置
     *
     * @param sid 学号（唯一）
     * @param pwd 密码
     * @return
     */
    @Transactional
    public Student queryByNamePwd(String sid, String pwd);
}
