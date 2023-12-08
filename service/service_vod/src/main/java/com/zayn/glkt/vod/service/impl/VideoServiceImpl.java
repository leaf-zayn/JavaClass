package com.zayn.glkt.vod.service.impl;

import com.zayn.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayn.glkt.vod.mapper.VideoMapper;
import com.zayn.glkt.vod.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayn.glkt.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
    //注入
    @Autowired
    private VodService vodService;

    @Override
    public void removeVideoByCourseId(Long id) {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        List<Video> videoList = baseMapper.selectList(wrapper);
        for (Video video : videoList) {
            String videoSourceId = video.getVideoSourceId();
            if (StringUtils.isEmpty(videoSourceId)) {
                //删除
                vodService.removeVideo(videoSourceId);
            }
        }
        baseMapper.delete(wrapper);
    }

    @Override
    public void removeVideoById(Long id) {
        //id查询小节信息
        Video video = baseMapper.selectById(id);
        String videoSourceId = video.getVideoSourceId();
        if (!StringUtils.isEmpty(videoSourceId)) {
            vodService.removeVideo(videoSourceId);
        }
        //根据id删除小节
        baseMapper.deleteById(id);
    }


}
