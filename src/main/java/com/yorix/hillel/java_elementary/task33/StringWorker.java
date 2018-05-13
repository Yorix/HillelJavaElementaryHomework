package com.yorix.hillel.java_elementary.task33;

public class StringWorker {
    public static<T> T act(DoOnlyAction action, String s) {
        return (T) action.todo(s);
    }
}
