package com.design.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.design.domain.Teacher;

public interface TeacherService extends IService<Teacher> {
    public IPage<Teacher> getTeacherPage(int currentPage, int pageSize);

    public IPage<Teacher> getTeacherPageBySid(int currentPage, int pageSize, String tid);

    public void updateTeacher(Teacher teacher);

    public void deleteTeacher(String tid);

    public int addTeacher(Teacher teacher);

    /**
     * 教师登录设置
     *
     * @param tid 教师编号（唯一）
     * @param pwd 密码
     * @return
     */
    public Teacher queryByNamePwd(String tid, String pwd);
}
