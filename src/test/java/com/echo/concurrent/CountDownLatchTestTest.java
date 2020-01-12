package com.echo.concurrent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountDownLatchTestTest {

    @Autowired
    private CountDownLatchTest countDownLatchTest;

    @Test
    void run() {
        countDownLatchTest.Run();
    }
}