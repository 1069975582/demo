package com.echo.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListIteratorTestTest {
    private List<String> testList;

    @Autowired
    private ListIteratorTest listIteratorTest;
    @BeforeEach
    public void  init() {
        testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add("String" + i);
        }
    }

    @Test
    void readByListIteratorNext() {
        listIteratorTest.readByListIteratorNext(testList.listIterator());
    }

    @Test
    void readByListItratorPrevious() {
        listIteratorTest.readByListItratorPrevious(testList.listIterator(5));
    }
}