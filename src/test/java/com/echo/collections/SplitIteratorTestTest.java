package com.echo.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SplitIteratorTestTest {

    private List<String> testList;

    @Autowired
    private SplitIteratorTest splitIteratorTest;

    @BeforeEach
    public void  init() {
        testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add("String" + i);
        }
    }

    @Test
    void readBySplitIterator() {
        splitIteratorTest.init(testList);
        splitIteratorTest.readBySplitIterator(3);
    }
}