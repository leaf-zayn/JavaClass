package com.zayn.glkt.vod.controller;


import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.api.R;
import com.zayn.ggkt.result.Result;
import com.zayn.glkt.vod.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author zayn
 * @since 2023-10-17
 */
@RestController
@RequestMapping("/admin/vod/video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @ApiOperation("新增")
    @PostMapping("save")
    public Result save(@RequestBody Video video) {
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation("修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.ok(null);
    }

    @ApiOperation("删除")
    @DeleteMapping("delete/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeById(id);
        return Result.ok(null);
    }


}

