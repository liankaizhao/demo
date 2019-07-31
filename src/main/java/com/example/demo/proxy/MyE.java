package com.example.demo.proxy;

public class MyE implements Quackable {

    @Override
    public void quack() {
        System.out.println("我是一只大白鹅");
    }
}
