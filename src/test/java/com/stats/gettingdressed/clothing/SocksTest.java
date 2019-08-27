package com.stats.gettingdressed.clothing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SocksTest {
    Socks socks = new Socks();

    @Test
    public void canBeWorn() {
        List<Wearable> canBeWorn = new ArrayList<>();
        canBeWorn.add(new Shirt());

        assertTrue(socks.canBeWorn(canBeWorn));
    }


    @Test
    public void toString1() {
        assertEquals("Socks", socks.toString());
    }
}