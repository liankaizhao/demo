package com.example.demo.proxy;

public class Duck implements Quackable {

    MyE myE;

    public Duck(MyE myE) {
        this.myE = myE;
    }

    @Override
    public void quack() {
        myE.quack();
    }
}
