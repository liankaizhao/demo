package com.example.demo.proxy;

public class MyFactory extends Factory {

    @Override
    Quackable quackableCreate() {
        return new Duck(new MyE());
    }
}
