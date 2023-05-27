package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.design.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     * 修改教师密码
     *
     * @param tpassword 修改后的密码
     * @param tid       查询条件教师编号
     * @return 修改结果 !=0则修改成功
     */
    public int modifyTeacherPwd(@Param("tpassword") String tpassword, @Param("tid") String tid);

    /**
     * 根据教师编号查询出教师实体
     *
     * @param tid
     * @return
     */
    public Teacher getByTeaTid(String tid);

    /**
     * 教师登录设置
     *
     * @param tid       教师编号（唯一）
     * @param tpassword 密码
     * @return
     */
    public String queryByNamePwd(@Param("tid") String tid, @Param("tpassword") String tpassword);

    /**
     * ajax验证教师是否存在
     *
     * @param tid 教师编号
     * @return 结果
     */
    public String ajaxQueryByTid(String tid);


}