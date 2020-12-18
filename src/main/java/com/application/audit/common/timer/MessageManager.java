package com.application.audit.common.timer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/12/18 10:08
 */
@Slf4j
public class MessageManager {

    public static boolean sendMessage(Message message, String webHookAddress) {
        OkHttpClient client = new OkHttpClient.Builder()
                // 设置连接超时时间
                .connectTimeout(10, TimeUnit.SECONDS)
                // 设置读取超时时间
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType contentType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create( contentType,JSONObject.toJSONString(message));
        Request request = new Request.Builder().url(webHookAddress).post(body).addHeader("cache-control", "no-cache").build();
        try {
            Response response = client.newCall(request).execute();
            byte[] datas = response.body().bytes();
            String respMsg = new String(datas);
            JSONObject resultJSON = JSONObject.parseObject(respMsg);
            if (resultJSON.getIntValue("errcode") == 0) {
                log.info("消息发送成功!");
                return true;
            }
            log.error("消息发送失败, 错误信息如下: {}", resultJSON.getString("errmsg"));
            return false;
        } catch (IOException e) {
            log.error("消息发送失败, 异常信息如下: {}", e.getMessage());
            return false;
        }
    }
}
