package com.yorix.hillel.java_elementary.task33;

@FunctionalInterface
public interface DoOnlyAction<T> {
    T todo(String s);
}
