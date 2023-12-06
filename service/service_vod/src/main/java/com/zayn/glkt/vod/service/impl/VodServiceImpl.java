package com.zayn.glkt.vod.service.impl;

import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import com.zayn.ggkt.exception.GgktException;
import com.zayn.glkt.vod.ConstantPropertiesUtil;
import com.zayn.glkt.vod.service.VodService;
import org.springframework.stereotype.Service;

@Service
public class VodServiceImpl implements VodService {
    @Override
    public String updateVideo() {
        //指定当前腾讯云账号id和key
        VodUploadClient client = new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        //上传请求对象
        VodUploadRequest request = new VodUploadRequest();
        //设置视频文件在本地的位置
        request.setMediaFilePath("/Users/zayn/Downloads/test.mp4");
        //任务流
        request.setProcedure("LongVideoPreset");
        try {
            //调用方法上传视频，指定地域
            VodUploadResponse response = client.upload("ap-shanghai", request);
            //获取上传之后视频id
            String fileId = response.getFileId();
            return fileId;
        } catch (Exception e) {
            throw new GgktException(20001, "上传视频失败");
        }
    }

    @Override
    public void removeVideo(String fileId) {
        try {
            Credential cred = new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            //实例化一个http选项
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vod.tencentcloudapi.com");
            //实例化一个client选项
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            //实例化要请求产品的client对象
            VodClient client = new VodClient(cred, "", clientProfile);
            //实例化一个请求对象，每个接口都会对应一个request对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId(fileId);
            //返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);
            //输出json格式的字符串回包
            System.out.println(DeleteMediaResponse.toJsonString(resp));
        } catch (Exception e) {
            throw new GgktException(20001, "删除视频失败");
        }
    }
}
