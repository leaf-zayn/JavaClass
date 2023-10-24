package com.zayn.glkt.vod.service;

import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
public interface VideoService extends IService<Video> {

    void removeVideoByCourseId(Long id);
}
