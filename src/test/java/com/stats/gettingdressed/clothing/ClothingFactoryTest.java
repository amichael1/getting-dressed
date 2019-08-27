package com.stats.gettingdressed.clothing;

import com.stats.gettingdressed.exception.UnknownClothingArticleException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClothingFactoryTest {

    @Test(expected = UnknownClothingArticleException.class)
    public void getInstanceThrowsException() throws UnknownClothingArticleException {
        ClothingFactory.getInstance(0);
    }

    @Test
    public void getInstance() throws UnknownClothingArticleException {
        assertEquals(Hat.class, ClothingFactory.getInstance(1).getClass());
        assertEquals(Pants.class, ClothingFactory.getInstance(2).getClass());
        assertEquals(Shirt.class, ClothingFactory.getInstance(3).getClass());
        assertEquals(Shoes.class, ClothingFactory.getInstance(4).getClass());
        assertEquals(Socks.class, ClothingFactory.getInstance(5).getClass());
    }
}