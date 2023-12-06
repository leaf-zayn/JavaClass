package com.zayn.glkt.activity.controller;


import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zayn.ggkt.result.Result;
import com.zayn.glkt.activity.service.CouponInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author zayn
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/admin/activity/couponInfo")
public class CouponInfoController {
    @Autowired
    private CouponInfoService couponInfoService;

    @ApiOperation("获取优惠券")
    @GetMapping("get/{id}")
    public Result get(@PathVariable String id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        return Result.ok(couponInfo);
    }

    @ApiOperation("新增优惠券")
    @PostMapping("save")
    public Result save(@RequestBody CouponInfo couponInfo) {
        couponInfoService.save(couponInfo);
        return Result.ok(null);
    }

    @ApiOperation("修改优惠券")
    @PutMapping("update")
    public Result updateById(@RequestBody CouponInfo couponInfo) {
        couponInfoService.updateById(couponInfo);
        return Result.ok(null);
    }

    @ApiOperation("删除优惠券")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        couponInfoService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation("根据id列表删除优惠券")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        couponInfoService.removeByIds(idList);
        return Result.ok(null);
    }

    //优惠券分页列表方法
    @ApiOperation("获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit) {
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        IPage<CouponInfo> pageModel = couponInfoService.page(pageParam);
        return Result.ok(pageModel);
    }

    //获取已经使用的优惠券列表
    @ApiOperation(value = "获取分页列表")
    @GetMapping("couponUse/{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "couponUseVo", value = "查询对象", required = false)
            CouponUseQueryVo couponUseQueryVo) {
        Page<CouponUse> pageParam = new Page<>(page, limit);
        IPage<CouponUse> pageModel = couponInfoService.selectCouponUsePage(pageParam, couponUseQueryVo);
        return Result.ok(pageModel);
    }
}

