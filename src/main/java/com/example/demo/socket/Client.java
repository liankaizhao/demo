package com.example.demo.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

@Slf4j

public class Client {


    public static void main(String[] args) {
        try {

            Socket s = new Socket("127.0.0.1",8888);
            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(os));

            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            //向服务器端发送一条消息
            while (bufferedReader.readLine()!=null) {

                String string=bufferedReader.readLine();
                bw.write(string);
                bw.write("\n");
                bw.flush();
            }

            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服务器："+mess);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
