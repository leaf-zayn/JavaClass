package com.zayn.glkt.vod.service;

import com.zayn.ggkt.model.vod.VideoVisitor;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 服务类
 * </p>
 *
 * @author zayn
 * @since 2023-10-24
 */
public interface VideoVisitorService extends IService<VideoVisitor> {

    Map<String, Object> findCount(@Param("courseId") Long courseId,
                                  @Param("startDate") String startDate,
                                  @Param("endDate") String endDate);
}
