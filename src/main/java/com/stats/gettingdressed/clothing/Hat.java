package com.stats.gettingdressed.clothing;

import java.util.List;

/*
 * Hat class
 **/
class Hat extends ClothingArticle {

    /*
     * Ensures shirt was on before it can be put on
     * I dont like this, but I realized why too late...
     * This creates a dependency between this class and the class it is checking, this should happen higher up in an abstract way
     **/
    @Override
    public boolean canBeWorn(List<Wearable> clothingBeingWorn) {
        return clothingBeingWorn.stream().anyMatch(c -> c.toString().equals("Shirt"));
    }
}
