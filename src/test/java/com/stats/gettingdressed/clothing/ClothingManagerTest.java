package com.stats.gettingdressed.clothing;

import com.stats.gettingdressed.exception.UnknownClothingArticleException;
import com.stats.gettingdressed.outfit.OutfitManager;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ClothingManagerTest {

    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = OutfitManager.class.getDeclaredField("outfitManager");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void getInstance() {
        assertEquals(ClothingManager.getInstance().getClass(),ClothingManager.class);
    }

    @Test(expected = UnknownClothingArticleException.class)
    public void getClothingByInputException() throws UnknownClothingArticleException {
        ClothingManager.getInstance().getClothingByInput(0);
    }

    @Test
    public void getClothingByInput() throws UnknownClothingArticleException{
        assertEquals(Hat.class, ClothingManager.getInstance().getClothingByInput(1).getClass());
        assertEquals(Pants.class, ClothingManager.getInstance().getClothingByInput(2).getClass());
        assertEquals(Shirt.class, ClothingManager.getInstance().getClothingByInput(3).getClass());
        assertEquals(Shoes.class, ClothingManager.getInstance().getClothingByInput(4).getClass());
        assertEquals(Socks.class, ClothingManager.getInstance().getClothingByInput(5).getClass());
    }
}