package com.echo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Runner extends Thread{

    public Runner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int number = CountDownLatchTest.atomicInteger.getAndIncrement();
            synchronized (this) {
                CountDownLatchTest.countDownLatch.countDown();
            }
            CountDownLatchTest.countDownLatch.await();
            log.info("我是运动员{},开始跑了{}",number, System.currentTimeMillis());
        } catch (InterruptedException e) {
            log.error("运动员失联", e);
        }
    }
}
