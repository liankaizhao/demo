package com.example.demo.proxy;

public class MyYa implements Quackable {

    @Override
    public void quack() {
        System.out.println("握手一只大白鸭");
    }
}
