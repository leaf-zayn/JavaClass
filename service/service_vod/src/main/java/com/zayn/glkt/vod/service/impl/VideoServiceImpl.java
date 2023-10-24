package com.zayn.glkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayn.glkt.vod.mapper.VideoMapper;
import com.zayn.glkt.vod.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Override
    public void removeVideoByCourseId(Long id) {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
