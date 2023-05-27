package com.design.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.design.domain.*;
import com.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/adminController")
public class AdminController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CoursePlanService coursePlanService;
    @Autowired
    CourseService courseService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    MajorService majorService;
    @Autowired
    ClassesService classesService;

    @PostMapping("/queryStudent")
    public PageBean<Student> queryStudent(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("choice") String choice, @RequestParam("condition") String condition, HttpServletRequest request) {
        PageBean<Student> pageBean = new PageBean<>();
        condition = "%" + condition + "%";
        switch (choice) {
            case "1": {
                IPage<Student> studentPage = studentService.getStudentPage(currentPage, pageSize);
                request.setAttribute("studentPage", studentPage);
                pageBean.setRows(studentPage.getRecords());
                pageBean.setTotalCount(studentPage.getTotal());
                break;
            }
            case "2": {
                IPage<Student> studentPage = studentService.getStudentPageBySid(currentPage, pageSize, condition);
                request.setAttribute("studentPage", studentPage);
                pageBean.setRows(studentPage.getRecords());
                pageBean.setTotalCount(studentPage.getTotal());
                break;
            }
            case "3": {
                List<Student> studentPageTotal = studentService.getStudentByCollege(condition);
                IPage<Student> studentPage = studentService.getStudentPageByCollege(currentPage, pageSize, condition);
                request.setAttribute("studentPage", studentPage);
                pageBean.setRows(studentPage.getRecords());
                pageBean.setTotalCount((long) studentPageTotal.size());
                break;
            }
            case "4": {
                List<Student> studentPageTotal = studentService.getStudentByMajor(condition);
                IPage<Student> studentPage = studentService.getStudentPageByMajor(currentPage, pageSize, condition);
                request.setAttribute("studentPage", studentPage);
                pageBean.setRows(studentPage.getRecords());
                pageBean.setTotalCount((long) studentPageTotal.size());
                break;
            }
            case "5": {
                List<Student> studentPageTotal = studentService.getStudentByClasses(condition);
                IPage<Student> studentPage = studentService.getStudentPageByClasses(currentPage, pageSize, condition);
                request.setAttribute("studentPage", studentPage);
                pageBean.setRows(studentPage.getRecords());
                pageBean.setTotalCount((long) studentPageTotal.size());
                break;
            }
        }
        return pageBean;
    }

    @GetMapping("/queryStudentCollege")
    public List<College> queryStudentCollege() {
        return collegeService.queryStudentCollege();
    }

    @GetMapping("/queryStudentMajor/{collegeId}")
    public List<Major> queryStudentMajor(@PathVariable Integer collegeId) {
        return majorService.queryStudentMajor(collegeId);
    }

    @GetMapping("/queryStudentClasses/{majorId}")
    public List<Classes> queryStudentClasses(@PathVariable Integer majorId) {
        return classesService.queryStudentClasses(majorId);
    }

    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{sid}")
    public void deleteStudent(@PathVariable String sid) {
        studentService.deleteStudent(sid);
    }

    @PostMapping("/addStudent")
    public R<Student> addStudent(@RequestBody Student student) {
        boolean flag = studentService.getById(student.getSid()) == null;
        if (flag) {
            if (studentService.addStudent(student) != 0) {
                return R.success(null);
            } else {
                return R.error("添加学生错误！");
            }
        } else {
            return R.error("该学号已存在，请重新输入！");
        }
    }

    @PostMapping("/queryTeacher")
    public PageBean<Teacher> queryTeacher(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("choice") String choice, @RequestParam("condition") String condition, HttpServletRequest request) {
        PageBean<Teacher> pageBean = new PageBean<>();
        condition = "%" + condition + "%";
        switch (choice) {
            case "1": {
                IPage<Teacher> teacherPage = teacherService.getTeacherPage(currentPage, pageSize);
                request.setAttribute("teacherPage", teacherPage);
                pageBean.setRows(teacherPage.getRecords());
                pageBean.setTotalCount(teacherPage.getTotal());
                break;
            }
            case "2": {
                IPage<Teacher> teacherPage = teacherService.getTeacherPageBySid(currentPage, pageSize, condition);
                request.setAttribute("studentPage", teacherPage);
                pageBean.setRows(teacherPage.getRecords());
                pageBean.setTotalCount(teacherPage.getTotal());
                break;
            }
        }
        return pageBean;
    }

    @PostMapping("/updateTeacher")
    public void updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/deleteTeacher/{tid}")
    public void deleteTeacher(@PathVariable String tid) {
        teacherService.deleteTeacher(tid);
    }

    @PostMapping("/addTeacher")
    public R<Teacher> addTeacher(@RequestBody Teacher teacher) {
        boolean flag = teacherService.getById(teacher.getTid()) == null;
        if (flag) {
            if (teacherService.addTeacher(teacher) != 0) {
                return R.success(null);
            } else {
                return R.error("添加老师错误！");
            }
        } else {
            return R.error("该教师编号已存在，请重新输入！");
        }
    }

    @PostMapping("/queryCourse")
    public PageBean<Course> queryCourse(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("choice") String choice, @RequestParam("condition") String condition, HttpServletRequest request) {
        PageBean<Course> pageBean = new PageBean<>();
        condition = "%" + condition + "%";
        switch (choice) {
            case "1": {
                IPage<Course> coursePage = courseService.getCoursePage(currentPage, pageSize);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "2": {
                IPage<Course> coursePage = courseService.getCoursePageByCid(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "3": {
                IPage<Course> coursePage = courseService.getCoursePageByCname(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "4": {
                IPage<Course> coursePage = courseService.getCoursePageByType(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "5": {
                List<Course> coursePageTotal = courseService.getCourseByCollege(condition);
                IPage<Course> coursePage = courseService.getCoursePageByCollege(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount((long) coursePageTotal.size());
                break;
            }
        }
        return pageBean;
    }

    @PostMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse/{cid}")
    public void deleteCourse(@PathVariable String cid) {
        courseService.deleteCourse(cid);
    }

    @PostMapping("/addCourse")
    public R<Course> addTeacher(@RequestBody Course course) {
        boolean flag = courseService.getById(course.getCid()) == null;
        if (flag) {
            if (courseService.addCourse(course) != 0) {
                return R.success(null);
            } else {
                return R.error("添加课程错误！");
            }
        } else {
            return R.error("该课程编号已存在，请重新输入！");
        }
    }

    @GetMapping("/queryCourseCollege")
    public List<College> queryCourseCollege() {
        return collegeService.queryCourseCollege();
    }

    @GetMapping("/queryCourseMajor/{collegeId}")
    public List<Major> queryCourseMajor(@PathVariable Integer collegeId) {
        return majorService.queryCourseMajor(collegeId);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout() {
        return "logout success !";
    }
}
