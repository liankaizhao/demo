package com.example.demo.test;

import org.springframework.boot.json.JsonParser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Testys {

    public static void main(String[] args) {
//        int counts = 10;
//        int speed = 10;
//        int sleepTime = (1000 / speed) / counts;
//        System.out.println(sleepTime);
        List<Integer> integers=new LinkedList<>();
        integers.add(123);
        integers.add(23);
        integers.add(6);integers.add(1245);
        Collections.sort(integers);
        System.out.println(integers);
        Collections.reverse(integers);
        System.out.println(integers);
    }
}
