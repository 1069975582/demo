package com.echo.collections;

import org.springframework.stereotype.Component;

import java.util.ListIterator;

@Component
public class ListIteratorTest {

    /**
     * 向后遍历
     * @param listIterator 待遍历ListIterator
     */
    public void readByListIteratorNext(ListIterator listIterator) {
        while (listIterator.hasNext()) {
            System.out.println("下一节点序号:" + listIterator.nextIndex());
            System.out.println("下一节点值:" + listIterator.next());
        }
        // lambda表达式遍历
        // listIterator.forEachRemaining(x -> System.out.println(x));
    }

    public void readByListItratorPrevious(ListIterator listIterator) {
        while (listIterator.hasPrevious()) {
            System.out.println("上一节点序号:" + listIterator.previousIndex());
            System.out.println("上一节点值:" + listIterator.previous());
        }
    }
}
