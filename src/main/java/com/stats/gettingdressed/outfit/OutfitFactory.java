package com.stats.gettingdressed.outfit;

/*
 * Factory to create outfit
 **/
class OutfitFactory {

    static Outfit getInstance(){
        return new OutfitToWearImpl();
    }
}
