package com.stats.gettingdressed.clothing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShirtTest {
    Shirt shirt = new Shirt();

    @Test
    public void canBeWorn() {
        List<Wearable> canBeWorn = new ArrayList<>();
        canBeWorn.add(new Shirt());

        assertTrue(shirt.canBeWorn(canBeWorn));
    }


    @Test
    public void toString1() {
        assertEquals("Shirt", shirt.toString());
    }
}