package com.example.demo.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterfaace extends Remote {

    /**
     * 返回结果
     * @return
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;
}
