package com.example.demo.observer;

import java.util.Observable;

public class Observer implements java.util.Observer {



    public void registerSub(Observable observable) {

        observable.addObserver(this);

    }
    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof Subject) {
            Subject subject= (Subject) o;
            System.out.println(subject.getMsg());
        }
        if (o instanceof Subject1) {
            Subject1 subject1= (Subject1) o;
            System.out.println(subject1.getMsg());
        }

    }


    public static void main(String[] args) {
        Subject subject=new Subject();
        Subject1 subject1=new Subject1();

        Observer observer=new Observer();
        observer.registerSub(subject);
        observer.registerSub(subject1);

        subject.setMsg("zlc");
        subject1.setMsg("123");
    }
}
