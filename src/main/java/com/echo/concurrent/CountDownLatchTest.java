package com.echo.concurrent;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CountDownLatchTest {
    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.Run();
    }

    public void Run() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Runner(String.valueOf(i));
            thread.start();
        }
    }
}