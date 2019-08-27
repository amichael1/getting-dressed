package com.stats.gettingdressed.outfit;

import com.stats.gettingdressed.clothing.ClothingManager;
import com.stats.gettingdressed.exception.IncompleteDressCodeException;
import com.stats.gettingdressed.exception.InvalidDressOrderException;
import com.stats.gettingdressed.exception.UnknownClothingArticleException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;
public class OutfitManagerTest {

    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = OutfitManager.class.getDeclaredField("outfitManager");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void getInstance() {
        assertEquals(OutfitManager.class, OutfitManager.getInstance().getClass());
    }

    @Test(expected = InvalidDressOrderException.class)
    public void addToOutfitThrowsException() throws UnknownClothingArticleException, InvalidDressOrderException {
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(1));
    }

    @Test
    public void addToOutfit() throws UnknownClothingArticleException, InvalidDressOrderException {
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(2));
        assertEquals("Pants, ", OutfitManager.getInstance().getOutfitAsString());
    }

    @Test(expected = IncompleteDressCodeException.class)
    public void checkRequiredClothingThrowsException() throws IncompleteDressCodeException {
        OutfitManager.getInstance().checkRequiredClothing();
    }

    @Test
    public void getOutfitAsString() throws UnknownClothingArticleException, InvalidDressOrderException{
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(3));
        assertEquals("Shirt, ", OutfitManager.getInstance().getOutfitAsString());
    }


    @Test
    public void checkRequiredClothing() throws UnknownClothingArticleException, InvalidDressOrderException, IncompleteDressCodeException {
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(2));
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(3));
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(5));
        OutfitManager.getInstance().addToOutfit(ClothingManager.getInstance().getClothingByInput(4));
        OutfitManager.getInstance().checkRequiredClothing();
    }
}