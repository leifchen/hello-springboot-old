package com.chen.controller;

import com.chen.task.AsyncTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * TaskController
 * <p>
 * @Author LeifChen
 * @Date 2018-12-13
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    private final AsyncTask asyncTask;

    public TaskController(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    @GetMapping("/test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();

        Future<Boolean> task1 = asyncTask.task1();
        Future<Boolean> task2 = asyncTask.task2();
        Future<Boolean> task3 = asyncTask.task3();

        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务总耗时：" + (end - start) + "ms";
        System.out.println(times);

        return times;
    }
}
