package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.domain.Student;
import com.design.mapper.StudentMapper;
import com.design.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService, Serializable {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> getStudentPage(int currentPage, int pageSize) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        return studentMapper.getStudentPage(page);
    }

    @Override
    public IPage<Student> getStudentPageBySid(int currentPage, int pageSize, String sid) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        return studentMapper.getStudentPageBySid(page, sid);
    }

    @Override
    public List<Student> getStudentByClasses(String classes) {
        return studentMapper.getStudentByClasses(classes);
    }

    @Override
    public IPage<Student> getStudentPageByClasses(int currentPage, int pageSize, String classes) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return studentMapper.getStudentPageByClasses(page, classes);
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentMapper.getStudentByMajor(major);
    }

    @Override
    public IPage<Student> getStudentPageByMajor(int currentPage, int pageSize, String major) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return studentMapper.getStudentPageByMajor(page, major);
    }

    @Override
    public List<Student> getStudentByCollege(String college) {
        return studentMapper.getStudentByCollege(college);
    }

    @Override
    public IPage<Student> getStudentPageByCollege(int currentPage, int pageSize, String college) {
        Page<Student> page = new Page<>(currentPage, pageSize);
        page.setSearchCount(false);
        return studentMapper.getStudentPageByCollege(page, college);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateById(student);
    }

    @Override
    public void deleteStudent(String sid) {
        studentMapper.deleteById(sid);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student getStudentBySid(String sid) {
        return studentMapper.getStudentBySid(sid);
    }

    @Override
    public Student queryByNamePwd(String sid, String pwd) {
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Student::getSid, sid).eq(Student::getSpassword, pwd);
        return studentMapper.selectOne(lqw);
    }
}
