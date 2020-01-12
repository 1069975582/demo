package com.echo.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CyclicBarrier;

/**
 * https://www.cnblogs.com/JMLiu/p/10697476.html
 * @author echo
 * @date 2020/1/9 13:10
 */
@SpringBootTest
@Slf4j
public class CyclicBarrierTestTest {

    @Test
    public void run() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println(Thread.currentThread().getName() + "到达!");
        });

        Thread t1 = new CyclicBarrierTest(cyclicBarrier);
        Thread t2 = new CyclicBarrierTest(cyclicBarrier);
        t1.start();
        t2.start();
    }
}