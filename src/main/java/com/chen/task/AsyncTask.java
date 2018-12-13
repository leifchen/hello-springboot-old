package com.chen.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务
 * <p>
 * @Author LeifChen
 * @Date 2018-12-13
 */
@Component
public class AsyncTask {

    @Async
    public Future<Boolean> task1() throws InterruptedException {
        Thread.sleep(1000);
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> task2() throws InterruptedException {
        Thread.sleep(500);
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> task3() throws InterruptedException {
        Thread.sleep(500);
        return new AsyncResult<>(true);
    }
}
