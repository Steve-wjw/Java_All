package com.steve.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: STEVE
 * @Description: 定时任务
 * @since: 2024/1/8
 */
@Service
@RequestMapping("/schedule")
public class ScheduledService {

    //秒   分   时     日   月   周几
    //0 * * * * MON-FRI
    //注意cron表达式的用法；
//    @Scheduled(cron = "0 * * * * 0-7")
//    public void hello(){
//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println("hello....." + dateFormat.format(date));
//    }

}
