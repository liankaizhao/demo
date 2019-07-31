package com.example.demo.proxy;

public class Test {

    public static void main(String[] args) {
        MyYa myYa=new MyYa();
        myYa.quack();
        Duck duck=new Duck(new MyE());
        duck.quack();

        Factory myFactory = new MyFactory();
        Quackable quackable=myFactory.quackableCreate();
        quackable.quack();
    }
}
