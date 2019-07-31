package com.example.demo.observer;

import java.util.Observable;

public class Subject extends Observable {


    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }


}
