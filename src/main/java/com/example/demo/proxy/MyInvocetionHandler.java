package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocetionHandler implements InvocationHandler {
    PersonBean personBean;

    public MyInvocetionHandler(PersonBean personBean) {

        this.personBean=personBean;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(personBean,method,args);
            }else if (method.getName().startsWith("setHot")) {
                return method.invoke(personBean,args);
            }else if (method.getName().startsWith("set")){
                return new IllegalAccessException();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建代理
     * @param personBean
     * @return
     */
    PersonBean getPersonBean(PersonBean personBean) {

        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),personBean.getClass().getInterfaces(),new MyInvocetionHandler(personBean));
    }
}
