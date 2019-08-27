package com.stats.gettingdressed.clothing;

import java.util.List;

/*
* Abstract class implementing methods for clothing articles
* Could use an interface with default methods but everything is defaulted so stuck with an abstract class
* Implementing an interface though for further extendability
* */
public abstract class ClothingArticle implements Wearable {

    /*
    * Some clothing can be worn, while some cannot depending on whats been worn already
    *  I dont like this, but I realized why too late...
     * This creates a dependency between this class and the class it is checking, this should happen higher up in an abstract way
    **/
    public boolean canBeWorn(List<Wearable> clothingBeingWorn){
        return true;
    }

    /*
     * For now will use class simple name but could have implemented this in each class itself
     **/
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
