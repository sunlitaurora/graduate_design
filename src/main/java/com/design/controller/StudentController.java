package com.design.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.design.domain.*;
import com.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectCourseService selectCourseService;
    @Autowired
    private SCService scService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CoursePlanService coursePlanService;

    @GetMapping("/queryStudent/{sid}")
    public Student queryTeacher(@PathVariable String sid) {
        Student student = new Student();
        Integer grade = gradeService.queryCreditsSum(sid);
        student = studentService.getStudentBySid(sid);
        student.setCredits(grade);
        return student;
    }

    @GetMapping("/getTeacher/{tid}")
    public Teacher getTeacher(@PathVariable String tid) {
        Teacher teacher = new Teacher();
        teacher = teacherService.getById(tid);
        return teacher;
    }

    @PostMapping("/queryAllCourse")
    public PageBean<Course> queryAllCourse(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestParam("choice") String choice, @RequestParam("condition") String condition, HttpServletRequest request) {
        PageBean<Course> pageBean = new PageBean<>();
        condition = "%" + condition + "%";
        switch (choice) {
            case "1": {
                IPage<Course> coursePage = courseService.getAllCoursePage(currentPage, pageSize);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "2": {
                IPage<Course> coursePage = courseService.getAllCoursePageByCid(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "3": {
                IPage<Course> coursePage = courseService.getAllCoursePageByCname(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "4": {
                IPage<Course> coursePage = courseService.getAllCoursePageByType(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount(coursePage.getTotal());
                break;
            }
            case "5": {
                List<Course> coursePageTotal = courseService.getAllCourseByCollege(condition);
                IPage<Course> coursePage = courseService.getAllCoursePageByCollege(currentPage, pageSize, condition);
                request.setAttribute("coursePage", coursePage);
                pageBean.setRows(coursePage.getRecords());
                pageBean.setTotalCount((long) coursePageTotal.size());
                break;
            }
        }
        return pageBean;
    }

    @PostMapping("/queryCourse")
    public R<Object> confirmSelect(@RequestParam("cid") String cid, @RequestParam("sid") String sid,
                                   @RequestParam("tid") String tid) {
        if (Objects.equals(tid, "undefined")){
            tid = "";
        }
        if (scService.existCourse(cid, sid, tid) != null) {
            return R.error("已经加入过该课程，不能重复加入!");
        }
        if (scService.selectCourse(cid, sid, tid) != 0) {
            return R.success(null);
        } else {
            return R.error("操作失败！");
        }
    }

    @PostMapping("/selectCourseResult")
    public PageBean<CoursePlan> selectCourseResult(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                                   @RequestParam("sid") String sid) {
        PageBean<CoursePlan> pageBean = new PageBean<>();
        IPage<CoursePlan> coursePlanPage = coursePlanService.getCourseResult(currentPage, pageSize, sid);
        pageBean.setRows(coursePlanPage.getRecords());
        pageBean.setTotalCount(coursePlanPage.getTotal());
        return pageBean;
    }

    @PostMapping("/exitChoose")
    public PageBean<StuExitSelect> exitChoose(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                              @RequestParam("sid") String sid) {
        PageBean<StuExitSelect> pageBean = new PageBean<>();
        IPage<StuExitSelect> stuExitSelectPage = selectCourseService.getExitBySid(currentPage, pageSize, sid);
        pageBean.setRows(stuExitSelectPage.getRecords());
        pageBean.setTotalCount(stuExitSelectPage.getTotal());
        return pageBean;
    }

    @PostMapping("/exitSelect")
    public R<Object> exitSelect(@RequestParam("cid") String cid, @RequestParam("sid") String sid,
                                @RequestParam("tid") String tid) {
        if (scService.deleteSC(cid, sid, tid) != 0) {
            return R.success(null);
        } else {
            return R.error("操作失败！");
        }
    }

    @PostMapping("/endCourse")
    public PageBean<Grade> endCourse(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                     @RequestParam("sid") String sid) {
        PageBean<Grade> pageBean = new PageBean<>();
        IPage<Grade> gradePage = gradeService.getEedCourseBySid(currentPage, pageSize, sid);
        pageBean.setRows(gradePage.getRecords());
        pageBean.setTotalCount(gradePage.getTotal());
        return pageBean;
    }
}
