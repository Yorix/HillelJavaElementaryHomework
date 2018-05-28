package com.yorix.hillel.java_elementary.task39;

import java.util.Scanner;

public class InputTask implements Runnable {
    private String userName;

    @Override
    public void run() {
        userName = new Scanner(System.in).nextLine();
    }

    public String getUserName() {
        return userName;
    }
}
