package com.design.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.design.domain.*;
import com.design.service.CoursePlanService;
import com.design.service.GradeService;
import com.design.service.SelectCourseService;
import com.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacherController")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CoursePlanService coursePlanService;
    @Autowired
    SelectCourseService selectCourseService;
    @Autowired
    GradeService gradeService;

    @PostMapping("/addCoursePlan")
    public R<CoursePlan> selectCourse(@RequestParam("courseweek") String courseweek, @RequestParam("coursetime") String coursetime, @RequestParam("cid") String cid,
                                      @RequestParam("tid") String tid, @RequestParam("classroom") String classroom, @RequestParam("credits") Integer credits,
                                      @RequestParam("period") Integer period, @RequestParam("totalNum") Integer totalNum) {
        // 然后判断该教室在该时间段是否已经被占用
        CoursePlan existClassroom = coursePlanService.findByCoursetimeAndClassroom(coursetime, classroom);
        if (existClassroom != null) {
            return R.error("该时间段该教室已被占用");
        }

        // 判断该老师是否在该时间段已经有课程
        CoursePlan existTeacher = coursePlanService.findByCoursetimeAndTid(coursetime, tid);
        if (existTeacher != null) {
            return R.error("该老师在该时间段已有课程");
        }

        if (coursePlanService.addCoursePlan(courseweek, coursetime, cid, tid, classroom, credits, period, totalNum) != 0) {
            return R.success(null);
        } else {
            return R.error("添加课程错误！");
        }
    }

    @PostMapping("/queryCoursePlan")
    public PageBean<CoursePlan> queryCoursePlan(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                                @RequestParam("tid") String tid) {
        PageBean<CoursePlan> pageBean = new PageBean<>();
        IPage<CoursePlan> coursePlanPage = coursePlanService.getCoursePlanPageByTid(currentPage, pageSize, tid);
        pageBean.setRows(coursePlanPage.getRecords());
        pageBean.setTotalCount(coursePlanPage.getTotal());
        return pageBean;
    }

    @PostMapping("/updateCoursePlan")
    public void updateCoursePlan(@RequestBody CoursePlan coursePlan) {
        coursePlanService.updateCoursePlan(coursePlan);
    }

    @DeleteMapping("/deleteCoursePlan/{courseclass}")
    public void deleteCoursePlan(@PathVariable String courseclass) {
        coursePlanService.deleteCoursePlan(courseclass);
    }

    @PostMapping("/searchSC")
    public PageBean<StuExitSelect> searchSC(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                            @RequestParam String tid) {
        PageBean<StuExitSelect> pageBean = new PageBean<>();
        IPage<StuExitSelect> stuExitSelectPage = selectCourseService.getLookByTid(currentPage, pageSize, tid);
        pageBean.setRows(stuExitSelectPage.getRecords());
        pageBean.setTotalCount(stuExitSelectPage.getTotal());
        return pageBean;
    }

    @PostMapping("/lookChoose")
    public PageBean<Student> lookChoose(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                        @RequestParam("cid") String cid, @RequestParam("tid") String tid) {
        PageBean<Student> pageBean = new PageBean<>();
        IPage<Student> studentPage = selectCourseService.getByStuCid(currentPage, pageSize, cid, tid);
        pageBean.setRows(studentPage.getRecords());
        pageBean.setTotalCount(studentPage.getTotal());
        return pageBean;
    }

    @PostMapping("/lookEndChoose")
    public PageBean<Student> lookEndChoose(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                           @RequestParam("cid") String cid, @RequestParam("tid") String tid) {
        PageBean<Student> pageBean = new PageBean<>();
        IPage<Student> studentPage = selectCourseService.getEndByStuCid(currentPage, pageSize, cid, tid);
        pageBean.setRows(studentPage.getRecords());
        pageBean.setTotalCount(studentPage.getTotal());
        return pageBean;
    }

    @PostMapping("/addGrade")
    public void addGrade(@RequestParam("cid") String cid, @RequestParam("tid") String tid,
                         @RequestParam("sid") String sid, @RequestParam("grade") Integer grade) {
        Grade g = new Grade();
        g.setCid(cid);
        g.setSid(sid);
        g.setGrade(grade);

        if (grade >= 60) {
            Integer credits = coursePlanService.getCreditsByCidAndTid(cid, tid);
            g.setCredits(credits);
        }
        gradeService.insertGrade(g);
    }

    @PostMapping("/endCourseGrade")
    public PageBean<CourseGrade> endCourseGrade(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize,
                                                @RequestParam("cid") String cid) {
        PageBean<CourseGrade> pageBean = new PageBean<>();
        IPage<CourseGrade> courseGradePage = coursePlanService.getCourseGrade(currentPage, pageSize, cid);
        pageBean.setRows(courseGradePage.getRecords());
        pageBean.setTotalCount(courseGradePage.getTotal());
        return pageBean;
    }

    @GetMapping("/queryTeacher/{tid}")
    public Teacher queryTeacher(@PathVariable String tid) {
        Teacher teacher = new Teacher();
        teacher = teacherService.getById(tid);
        return teacher;
    }
}
