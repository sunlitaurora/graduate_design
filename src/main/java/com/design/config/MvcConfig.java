package com.design.config;

import com.design.controller.interceptor.LoginInterceptor;
import com.design.controller.interceptor.StudentLoginInterceptor;
import com.design.controller.interceptor.TeacherLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private StudentLoginInterceptor studentLoginInterceptor;
    @Autowired
    private TeacherLoginInterceptor teacherLoginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages");
        registry.addResourceHandler("/imgs/**").addResourceLocations("/imgs/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
        registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/AdminHandler/**", "/CourseHandler/**", "/admin/**");
        registry.addInterceptor(studentLoginInterceptor).addPathPatterns("/StudentHandler/**", "/student/**", "/CoursePlanHandler/**");
        registry.addInterceptor(teacherLoginInterceptor).addPathPatterns("/CoursePlanHandler/**", "/TeacherHandler/**", "/teacher/**");
    }

}
