package com.zayn.glkt.vod.service;

import com.zayn.ggkt.model.vod.Course;
import com.zayn.ggkt.vo.vod.CourseFormVo;
import com.zayn.ggkt.vo.vod.CoursePublishVo;
import com.zayn.ggkt.vo.vod.CourseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
public interface CourseService extends IService<Course> {

    Map<String, Object> findPageCourse(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseInfoById(Long id);

    void updateCourseId(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(String id);

    void publishCourse(String id);

    void removeCourseId(Long id);
}
