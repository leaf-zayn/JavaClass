package com.zayn.glkt.vod.controller;

import com.zayn.ggkt.exception.GgktException;
import com.zayn.ggkt.result.Result;
import com.zayn.glkt.vod.ConstantPropertiesUtil;
import com.zayn.glkt.vod.service.VodService;
import com.zayn.glkt.vod.utils.Signature;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Api("腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
//@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    //上传视频接口
    @PostMapping("upload")
    public Result upload() {
        String fileId = vodService.updateVideo();

        return Result.ok(fileId);
    }

    //删除腾讯云视频
    @DeleteMapping("remove/{fileId}")
    public Result remove(@PathVariable String fileId) {
        vodService.removeVideo(fileId);
        return Result.ok(null);
    }

    //返回客户端上传签名
    @GetMapping("sign")
    public Result sign() {
        Signature sign = new Signature();
        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        sign.setSecretKey(ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        sign.setSignValidDuration(3600 * 24 * 2); // 签名有效期：2天

        try {
            String signature = sign.getUploadSignature();
            System.out.println("signature : " + signature);
            return Result.ok(signature);
        } catch (Exception e) {
            System.out.print("获取签名失败");
            throw new GgktException(20001, "获取签名失败");
        }
    }
}

