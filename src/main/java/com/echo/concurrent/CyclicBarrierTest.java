package com.echo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierTest extends Thread{
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            try {
                // log.info("线程{}第{}次达到,休眠前",Thread.currentThread().getName(), i);
                // Thread.sleep(3000);
                // log.info("线程{}第{}次达到,休眠后",Thread.currentThread().getName(), i);
                int arrivalIndex = cyclicBarrier.await();
                log.info("线程{}到达顺序:{},到达次数:{}", name, arrivalIndex, i+1);
            } catch (InterruptedException | BrokenBarrierException e) {
                log.error("CyclicBarrierTest run error!", e);
            }
        }
    }
}
