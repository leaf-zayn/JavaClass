package com.zayn.glkt.user.controller;


import com.atguigu.ggkt.model.user.UserInfo;
import com.zayn.glkt.user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zayn
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取")
    @GetMapping("inner/getById/{id}")
    public UserInfo getById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return userInfo;
    }

}

