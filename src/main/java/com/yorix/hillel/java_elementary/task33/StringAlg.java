package com.yorix.hillel.java_elementary.task33;

public class StringAlg {

    public int getNumberParts(String s) {
//        int res = 1;
//        for (char c : s.toCharArray()) {
//            if (c == ',') res++;
//        }
//        return res;

        return s.split(",").length;
    }
}
