package com.design.controller;

import com.design.domain.Admin;
import com.design.domain.Student;
import com.design.domain.Teacher;
import com.design.service.AdminService;
import com.design.service.StudentService;
import com.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/loginController")
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/adminLogin")
    public R loginAdmin(HttpServletRequest request, @RequestParam("aname") String aname, @RequestParam("apassword") String apassword) {
        Admin admin = adminService.queryByNamePwd(aname, apassword);
        if (admin == null) {
            return R.error("登录失败，用户不存在");
        }
        if (!admin.getApassword().equals(apassword)) {
            return R.error("登陆失败，密码错误");
        }

        request.getSession().setAttribute("aname", aname);
        return R.success(admin);
    }

    @RequestMapping("/teacherLogin")
    public R loginTeacher(HttpServletRequest request, @RequestParam("tid") String tid, @RequestParam("tpassword") String tpassword) {
        Teacher teacher = teacherService.getById(tid);
        if (teacher == null) {
            return R.error("登录失败，用户不存在");
        }
        if (!teacher.getTpassword().equals(tpassword)) {
            return R.error("登陆失败，密码错误");
        }

        request.getSession().setAttribute("tid", tid);
        request.getSession().setAttribute("tname", teacher.getTname());
        return R.success(teacher);
    }

    @PostMapping("/studentLogin")
    @ResponseBody
    public R loginStudent(HttpServletRequest request, @RequestParam("sid") String sid, @RequestParam("spassword") String spassword) {
        Student student = studentService.queryByNamePwd(sid, spassword);
        if (student == null) {
            return R.error("登录失败，用户不存在");
        }
        if (!student.getSpassword().equals(spassword)) {
            return R.error("登陆失败，密码错误");
        }

        request.getSession().setAttribute("sid", sid);
        request.getSession().setAttribute("sname", student.getSname());
        return R.success(student);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("aname");
        request.getSession().removeAttribute("tid");
        request.getSession().removeAttribute("tname");
        request.getSession().removeAttribute("sid");
        request.getSession().removeAttribute("sname");

        return R.success("退出成功");
    }
}
