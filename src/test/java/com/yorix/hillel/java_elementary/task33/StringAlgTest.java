package com.yorix.hillel.java_elementary.task33;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringAlgTest {
    private StringAlg alg = new StringAlg();

    @Test
    public void test1GetNumberParts() {
        assertEquals(4, alg.getNumberParts("qwery, test, 1234, yorix"));
    }

    @Test
    public void test2GetNumberParts() {
        assertEquals(4, alg.getNumberParts("qwery, test, 1234, "));

    }

    @Test
    public void test3GetNumberParts() {
        assertEquals(3, alg.getNumberParts("qwery, test, 1234,"));

    }

    @Test
    public void test4GetNumberParts() {
        assertEquals(3, alg.getNumberParts("qwery, test, 1234"));
    }

    @Test
    public void test5GetNumberParts() {
        assertEquals(1, alg.getNumberParts(",qwery test 1234,"));
    }
}