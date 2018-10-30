package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
    @Resource
    private KafkaSender<JSONObject> kafkaSender;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //然后每隔1分钟执行一次
    //最新部分
    @Scheduled(cron="0/1 * *  * * ? ")
    public void testKafka() throws Exception {
        JSONObject user = new JSONObject();
        user.put("id",System.currentTimeMillis());
        user.put("msg",UUID.randomUUID().toString());
        user.put("time",new Date());

        kafkaSender.send(user);

    }
}
