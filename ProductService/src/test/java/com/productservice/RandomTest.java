package com.productservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTest {

    @Test
    void testAddition(){
        int i = 1 + 1;
        assert i == 2;
        assertEquals(2, i);
    }
}
