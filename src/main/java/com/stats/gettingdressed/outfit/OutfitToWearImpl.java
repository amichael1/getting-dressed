package com.stats.gettingdressed.outfit;

import com.stats.gettingdressed.clothing.Wearable;
import com.stats.gettingdressed.exception.InvalidDressOrderException;
import com.stats.gettingdressed.util.Constants;

import java.util.ArrayList;
import java.util.List;

/*
 * Outfit implementation, does check for when an item can be put on
 **/
class OutfitToWearImpl implements Outfit{

    //List to contain all items currently wearing with outfit
    private final List<Wearable> currentWearables = new ArrayList<>();

    /* Returning new reference to the list so that list can not be changed
     * However items in list are shallow copies so if those are directly changed outside of class
     * It will affect the data held by list but wearables are stateless so it is ok
     **/
    @Override
    public List<Wearable> getCurrentWearables(){
        return new ArrayList<>(currentWearables);
    }

    /*
     * Creates the current outfit as a string
     **/
    @Override
    public String toString() {

        // Using string builder to be efficient, could use StringBuffer for multithreaded purposes
        StringBuilder stringBuilder = new StringBuilder();

        // Create list as shown in example output, adding last comma and space for appending leave/fail
        for (Wearable wareable : currentWearables) {
            stringBuilder.append(wareable.toString());
            stringBuilder.append(Constants.COMMA_SPACE_SEPARATOR);
        }

        return stringBuilder.toString();
    }

    @Override
    /*
     * Adds ware to outfit
     **/
    public void addWearable(Wearable wearable) throws InvalidDressOrderException {
        if (shouldPutOnWearable(wearable)) {
            currentWearables.add(wearable);
        } else {
            //Throw exception if order being dressed is incorrect
            throw new InvalidDressOrderException();
        }
    }

    /*
     * Checks to see if wares can be put on
     **/
    private boolean shouldPutOnWearable(Wearable wearable) {
        //Article should check since it will dictate what
        return wearable.canBeWorn(getCurrentWearables());
    }
}

