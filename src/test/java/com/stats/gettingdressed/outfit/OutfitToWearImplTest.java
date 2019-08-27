package com.stats.gettingdressed.outfit;

import com.stats.gettingdressed.clothing.ClothingManager;
import com.stats.gettingdressed.clothing.Wearable;
import com.stats.gettingdressed.exception.InvalidDressOrderException;
import com.stats.gettingdressed.exception.UnknownClothingArticleException;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutfitToWearImplTest {

    @Test
    public void getCurrentWearables() throws UnknownClothingArticleException, InvalidDressOrderException {
        OutfitToWearImpl outfitToWear = new OutfitToWearImpl();
        assertTrue(outfitToWear.getCurrentWearables().isEmpty());

        Wearable wearable = ClothingManager.getInstance().getClothingByInput(2);
        outfitToWear.addWearable(wearable);
        assertEquals(wearable ,outfitToWear.getCurrentWearables().get(0));
    }

    @Test(expected = UnknownClothingArticleException.class)
    public void addWearablesThrowsUnknownClothingArticleException() throws UnknownClothingArticleException, InvalidDressOrderException {
        OutfitToWearImpl outfitToWear = new OutfitToWearImpl();

        Wearable wearable = ClothingManager.getInstance().getClothingByInput(0);
        outfitToWear.addWearable(wearable);
    }

    @Test(expected = InvalidDressOrderException.class)
    public void addWearablesThrowsInvalidOrderException() throws UnknownClothingArticleException, InvalidDressOrderException {
        OutfitToWearImpl outfitToWear = new OutfitToWearImpl();

        Wearable wearable = ClothingManager.getInstance().getClothingByInput(1);
        outfitToWear.addWearable(wearable);
    }

    @Test
    public void toString1() throws UnknownClothingArticleException, InvalidDressOrderException{
        OutfitToWearImpl outfitToWear = new OutfitToWearImpl();

        Wearable wearable = ClothingManager.getInstance().getClothingByInput(2);
        outfitToWear.addWearable(wearable);
        assertEquals(wearable,outfitToWear.getCurrentWearables().get(0));
    }

    @Test
    public void addWearable() throws  UnknownClothingArticleException, InvalidDressOrderException {
        OutfitToWearImpl outfitToWear = new OutfitToWearImpl();

        Wearable wearable = ClothingManager.getInstance().getClothingByInput(3);
        outfitToWear.addWearable(wearable);
        assertEquals(wearable, outfitToWear.getCurrentWearables().get(0));
    }
}