package com.example.demo.observer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {

    public static void main(String[] args) {
           new MyClient().getResult();
    }

    public void getResult() {
        MyInterfaace service= null;
        try {
            service = (MyInterfaace) Naming.lookup("rmi://127.0.0.1/HelloService");
            String result=service.sayHello();
            System.out.println(result);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
