package com.main;

import com.client.UserClient;

public class Main {

    public static void main(String[] args) {
        new UserClient().sendUser();
        System.out.println("Hello world");
    }
}
