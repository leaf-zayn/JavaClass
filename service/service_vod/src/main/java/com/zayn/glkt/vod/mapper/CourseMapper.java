package com.zayn.glkt.vod.mapper;

import com.zayn.ggkt.model.vod.Course;
import com.zayn.ggkt.vo.vod.CoursePublishVo;
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

    CoursePublishVo selectCoursePublishVoById(String id);
}
