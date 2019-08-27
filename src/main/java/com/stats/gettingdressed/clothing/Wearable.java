package com.stats.gettingdressed.clothing;

import java.util.List;

/*
 * Interface for anything that can be worn
 **/
public interface Wearable {
    boolean canBeWorn(List<Wearable> clothingBeingWorn);
}
