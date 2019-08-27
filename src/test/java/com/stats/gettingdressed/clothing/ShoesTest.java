package com.stats.gettingdressed.clothing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShoesTest {

    @Test
    public void canBeWorn() {
        Shoes shoes = new Shoes();
        List<Wearable> canBeWorn = new ArrayList<>();
        canBeWorn.add(new Socks());
        canBeWorn.add(new Pants());

        assertTrue(shoes.canBeWorn(canBeWorn));
    }

    @Test
    public void cantBeWorn() {
        Shoes shoes = new Shoes();
        List<Wearable> cantBeWorn = new ArrayList<>();
        cantBeWorn.add(new Shirt());
        assertFalse(shoes.canBeWorn(cantBeWorn));
    }

    @Test
    public void toString1() {
        Shoes shoes = new Shoes();
        assertEquals("Shoes", shoes.toString());
    }
}