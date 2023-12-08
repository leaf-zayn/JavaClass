package com.zayn.glkt.user.service.impl;

import com.zayn.ggkt.model.user.UserInfo;
import com.zayn.glkt.user.mapper.UserInfoMapper;
import com.zayn.glkt.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zayn
 * @since 2023-12-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
