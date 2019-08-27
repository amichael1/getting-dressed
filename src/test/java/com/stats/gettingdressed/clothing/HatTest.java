package com.stats.gettingdressed.clothing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HatTest {


    @Test
    public void canBeWorn() {
        Hat hat = new Hat();
        List<Wearable> canBeWorn = new ArrayList<>();
        canBeWorn.add(new Shirt());

        assertTrue(hat.canBeWorn(canBeWorn));
    }

    @Test
    public void cantBeWorn() {
        Hat hat = new Hat();
        List<Wearable> cantBeWorn = new ArrayList<>();
        cantBeWorn.add(new Socks());
        assertFalse(hat.canBeWorn(cantBeWorn));
    }

    @Test
    public void toString1() {
        Hat hat = new Hat();
        assertEquals("Hat", hat.toString());
    }
}