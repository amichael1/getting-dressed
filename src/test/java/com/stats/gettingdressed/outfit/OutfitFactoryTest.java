package com.stats.gettingdressed.outfit;

import org.junit.Test;

import static org.junit.Assert.*;

public class OutfitFactoryTest {

    @Test
    public void getInstance() {
        assertEquals(OutfitToWearImpl.class, OutfitFactory.getInstance().getClass());
    }
}