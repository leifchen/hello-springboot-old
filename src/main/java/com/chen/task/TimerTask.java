package com.chen.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 定时任务
 * <p>
 * @Author LeifChen
 * @Date 2018-12-13
 */
@Component
public class TimerTask {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 1000)
    public void task1() throws InterruptedException {
        System.out.println("Task1 : " + sdf.format(System.currentTimeMillis()));
    }

    @Scheduled(fixedRate = 1000)
    public void task2() throws InterruptedException {
        System.out.println("Task2 : " + sdf.format(System.currentTimeMillis()));
        Thread.sleep(3000);
    }

    @Scheduled(cron = "0,10,20,30,40,50 * * * * ? ")
    public void task3() {
        System.out.println("Task3 : " + sdf.format(System.currentTimeMillis()));
    }
}
