package com.example.demo.socket;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.InputStream;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j

public class Server {


    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("启动服务器....");
            Socket s = ss.accept();
            log.info("客户端:"+ InetAddress.getLocalHost()+"已连接到服务器");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //读取客户端发送来的消息
            String str;
            while ((str=br.readLine())!=null) {

                log.info("收到客户端信息={}",str);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                bw.write("我已收到你的信息");
                bw.flush();
            }
            //System.out.println("客户端："+mess+"12312");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
