package com.stats.gettingdressed.clothing;

import java.util.List;

/*
 * Shoes class
 **/
class Shoes extends ClothingArticle {

    /*
     * Ensures pants and socks are on before being put on
     * I dont like this, but I realized why too late...
     * This creates a dependency between this class and the class it is checking, this should happen higher up in an abstract way
     **/
    @Override
    public boolean canBeWorn(List<Wearable> clothingBeingWorn) {
        return clothingBeingWorn.stream().anyMatch(c -> c.toString().equals("Pants")) && clothingBeingWorn.stream().anyMatch(c -> c.toString().equals("Socks"));
    }

}
