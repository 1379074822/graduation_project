package com.application.audit.common.timer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @description:
 * @author:
 * @time: 2020/3/18 22:06
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@Component
@EnableScheduling   // 2.开启定时任务
public class TimerTask {

    @Autowired
    private UserService userService;
    @Scheduled(cron = "0 0 0  * * ?")
    private void configureTasks() {
       userService.freezeAudit();
    }


    @Scheduled(cron = "0 30 9 * * ? ")
    private static void text() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        String httpArg = f.format(new Date());
        String jsonResult = HolidayUtil.request(httpArg);
        if (!"0".equals(jsonResult)) {
            return;
        }
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String webHookAddress = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=55eebf57-4579-4de8-91ab-b126ff0d20f8";
        //发送文本消息
        Message message = new Message();
        message.setMsgtype(MessageTypeEnum.text);
        StringBuilder builder = new StringBuilder();
        builder.append("今天是");
        Calendar calendar=Calendar.getInstance();
        ZhiBanEnum enumByWeek = ZhiBanEnum.getEnumByWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);
        builder.append(weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
        builder.append("\n");
        builder.append("值班人员为:");
        builder.append(enumByWeek.getName());
        builder.append("  请注意业务群消息~及时反馈~");
        Weather weather = getWeather();
        if(Objects.nonNull(weather)){
            builder.append(" \n");
            builder.append("今日天气");
            builder.append(weather.getType());
            builder.append(" \n");
            builder.append("温度:");
            builder.append(weather.getLow());
            builder.append(" ~");
            builder.append(weather.getHigh());
            builder.append(" \n");
            builder.append(weather.getFx());
            builder.append(weather.getFl());
            builder.append(" \n");
            builder.append(weather.getNotice());
        }
        TextMessage textMessage = new TextMessage();
        textMessage.setContent(builder.toString());
        textMessage.setMentioned_list(Arrays.asList(enumByWeek.getPinyin()));
        JSONObject text = JSONObject.parseObject(JSONObject.toJSONString(textMessage));
        message.setText(text);
        MessageManager.sendMessage(message, webHookAddress);
    }


    private static Weather getWeather(){
        Weather weather = new Weather();
        try{
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");

            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");
            BufferedReader br = new BufferedReader(isReader);
            StringBuffer stringBuffer = new StringBuffer();
            String str;
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
            }
            JSONObject jsonObject = JSONObject.parseObject(stringBuffer.toString());
            String data = jsonObject.getString("data");
            JSONObject jsonObject2 = JSONObject.parseObject(data);
            String forecast = jsonObject2.getString("forecast");
            JSONArray objects = JSONObject.parseArray(forecast);
            weather = JSONObject.parseObject(objects.get(0).toString(), Weather.class);
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
        return weather;
    }

    public static void main(String[] args) {
       text();
    }

}
