package com.juaracoding.syafiq.utils;

public class Utils {
    public static void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
