package com.stats.gettingdressed.outfit;

import com.stats.gettingdressed.clothing.Wearable;
import com.stats.gettingdressed.exception.InvalidDressOrderException;

import java.util.List;

/*
 * Interface for an outfit which is a set of wearables that can be worn together
 **/
public interface Outfit {
    List<Wearable> getCurrentWearables();
    void addWearable(Wearable wearable) throws InvalidDressOrderException;
}
