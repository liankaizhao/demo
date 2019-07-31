package com.example.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool {

    public static void main(String[] args) {
        //设置核心池大小
        int corePoolSize = 5;

        int maximumPoolSize = 10;

        //设置线程池最大能接受多少线程

        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 200;

        //设置时间单位，秒
        TimeUnit timeUnit = TimeUnit.SECONDS;

        //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);

        //创建ThreadPoolExecutor线程池对象，并初始化该对象的各种参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, timeUnit,workQueue);

        //往线程池中循环提交线程
        for (int i = 0; i < 15; i++) {
            //创建线程类对象
            MyTask myTask = new MyTask(i);
            //开启线程
            executor.execute(myTask);
            //获取线程池中线程的相应参数
            System.out.println("线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
        }
        //待线程池以及缓存队列中所有的线程任务完成后关闭线程池。
        executor.shutdown();

    }


   static class MyTask implements Runnable {
        private int num;

        public MyTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + num);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + num + "执行完毕");
        }

        public long getDelta() throws ParseException {
            //获取当前时间戳
            long t1 = System.currentTimeMillis();
            //获取未来某个时间戳（自定义，可写入配置文件）
            String str = "2016-11-11 15:15:15";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long t2 = simpleDateFormat.parse(str).getTime();
            return t2 - t1;
        }

    }


}
