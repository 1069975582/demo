package com.echo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(String.valueOf(i), String.valueOf(i) + "abcd");
        }
        map.put(null, null);
        map.get(String.valueOf(12));
        System.out.println(map.get(null));

        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", "b");
        concurrentHashMap.get("a");
    }
}
