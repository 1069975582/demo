package com.echo.collections;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Spliterator;

@Slf4j
@Component
@Data
public class SplitIteratorTest{
    private List<String> testList;

    private Spliterator spliterator;

    public void init(List<String> list) {
        this.testList = list;
        spliterator = testList.spliterator();
    }

    public void readBySplitIterator(int threadNum) {
        for (int i = 0; i <= threadNum; i++) {
            Thread splitThread = new SplitThread();
            ((SplitThread) splitThread).setSplit(threadNum != i);
            splitThread.start();
        }
    }

    @Data
    class SplitThread extends Thread {
        private boolean split = false;
        @Override
        public void run() {
            if (split) {
                // trySplit返回一个新的Spliterator
                spliterator.trySplit().forEachRemaining(o -> log.info("线程{}遍历值为{}", Thread.currentThread().getName(), o));
            } else {
                spliterator.forEachRemaining(o -> log.info("线程{}遍历值为{}", Thread.currentThread().getName(), o));
            }
        }
    }
}
