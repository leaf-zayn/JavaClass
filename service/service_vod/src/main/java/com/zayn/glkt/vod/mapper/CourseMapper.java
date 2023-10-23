package com.zayn.glkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
public interface CourseMapper extends BaseMapper<Course> {

    CoursePublishVo selectCoursePublishVoById(Long id);
}
