package com.example.demo.observer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRomoyeImpl extends UnicastRemoteObject implements MyInterfaace {
    @Override
    public String sayHello() throws RemoteException {
        return "hello";
    }

    public MyRomoyeImpl() throws RemoteException {}


    public static void main(String[] args) {
        MyInterfaace service = null;
        try {
            service = new MyRomoyeImpl();
            Naming.rebind("HelloService",service);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
