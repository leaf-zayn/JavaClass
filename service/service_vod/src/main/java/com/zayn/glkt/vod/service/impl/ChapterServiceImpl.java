package com.zayn.glkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vo.vod.VideoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayn.glkt.vod.mapper.ChapterMapper;
import com.zayn.glkt.vod.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayn.glkt.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        //定义最终数据list集合
        List<ChapterVo> finalChapterList = new ArrayList<>();
        //根据courseId获取课程里面的所有章节
        QueryWrapper<Chapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(wrapperChapter);
        //根据courseId获取课程里面的所有小节
        LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
        wrapperVideo.eq(Video::getCourseId, courseId);
        List<Video> videoList = videoService.list();
        //封装章节
        //遍历所有章节
        for (int i = 0; i < chapterList.size(); i++) {
            //得到课程每个章节
            Chapter chapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            //得到的每个章节对象放到finalChapterList集合
            finalChapterList.add(chapterVo);
            //封装章节里面的小节
            //创建list集合用户封装章节所有小节
            List<VideoVo> videoVoList = new ArrayList<>();
            //遍历小节list
            for (Video video : videoList) {
                //判断小节是哪个章节下的小节
                if (chapter.getId().equals(video.getChapterId())) {
                    //videoVoList
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }
            //把章节所有小节的集合放到章节中
            chapterVo.setChildren(videoVoList);
        }
        return finalChapterList;
    }

    //根据课程id删除章节
    @Override
    public void removeChapterByCourseId(Long id) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
