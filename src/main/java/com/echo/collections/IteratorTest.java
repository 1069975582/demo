package com.echo.collections;

import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class IteratorTest {

    /**
     * 使用迭代器读取数据
     * @param iterator 迭代器
     */
    public void readByIterator(Iterator iterator) {
        // 两种读取方式, 第二种为lambda表达式
        /*
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        iterator.forEachRemaining(x -> System.out.println(x));
    }
}
