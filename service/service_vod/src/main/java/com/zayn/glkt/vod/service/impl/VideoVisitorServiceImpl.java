package com.zayn.glkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.zayn.glkt.vod.mapper.VideoVisitorMapper;
import com.zayn.glkt.vod.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 *
 * @author zayn
 * @since 2023-10-24
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        //调用mapper的方法
        List<VideoVisitorCountVo> videoVisitorCountVoList = baseMapper.findCount(courseId, startDate, endDate);
        //创建一个map集合
        Map<String, Object> map = new HashMap<>();
        //创建两个list集合，一个代表所有日期，一个代表日期数量
        //封装数据
        List<String> dateList = videoVisitorCountVoList.stream().map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());
        List<Integer> countList = videoVisitorCountVoList.stream().map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());
        //放到map集合中去
        map.put("xData", dateList);
        map.put("yData", countList);
        return map;

    }
}
