package com.client;

import com.bean.Users;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UserClient {
    private Socket socket;
    private Users user;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Scanner input = new Scanner(System.in);

    public void sendUser() {
        try {
            while (true) {
                socket = new Socket("172.16.0.31", 8899);
                out = socket.getOutputStream();
                user = new Users();
                System.out.println("请输入账号：");
                user.setUsername(input.next());
                System.out.println("请输入密码：");
                user.setUserpass(input.next());

                //将对象发送到服务器
                oos = new ObjectOutputStream(out);
                oos.writeObject(user);
                oos.flush();

                //结束服务器的响应
                in = socket.getInputStream();
                int code = in.read();
                if (code == 1) {
                    System.out.println("登录成功！");
                    return;
                } else {
                    System.out.println("登录失败！");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
