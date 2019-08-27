package com.stats.gettingdressed.outfit;

import com.stats.gettingdressed.clothing.Wearable;
import com.stats.gettingdressed.exception.IncompleteDressCodeException;
import com.stats.gettingdressed.exception.InvalidDressOrderException;
import com.stats.gettingdressed.exception.InvalidRequiredClothingPropertyException;
import com.stats.gettingdressed.util.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * Outfit manager manages access to the outfit (Facade using singleton), it also can validate the outfit
 **/
public class OutfitManager {

    /*
     * List containing the types of all the required clothing
     * Using Class<Wearable> ensures property names are valid
     * Otherwise ClassNotFoundException will be thrown
     * SpringBoot does this validation automatically using ConfigurationProperties
     **/
    private static final List<Class<Wearable>> REQUIRED_CLOTHING = new ArrayList<>();
    private volatile static OutfitManager outfitManager;
    private Outfit outfit;

    private OutfitManager() throws InvalidRequiredClothingPropertyException, IOException {
        outfit = OutfitFactory.getInstance();
        loadRequiredClothing();
    }

    /*
     * If instance fails to startup, write exception and fail message
     **/
    public synchronized static OutfitManager getInstance(){

        if(outfitManager == null){
            try {
                outfitManager = new OutfitManager();
            } catch (Exception ex){
                outfitManager = null;
                System.out.println(ex.getMessage());
                System.out.println(Constants.FAIL);
            }

        }
        return outfitManager;
    }

    /*
     * Loads the required clothing from a properties list
     **/
    @SuppressWarnings("unchecked")
    private void loadRequiredClothing() throws InvalidRequiredClothingPropertyException, IOException {
        // Try with resource so that once we leave the block the input stream will be closed
        try(InputStream inputStream = getClass().getResourceAsStream(Constants.PROPERTY_FILE)){

            /*
             * Grab the clothing types as a single string
             * SpringBoot would make working with properties much easier with ConfigurationProperties
             **/
            Properties properties = new Properties();
            properties.load(inputStream);
            String clothingTypeStrings = properties.getProperty(Constants.REQUIRED_PROPERTY_NAME);

            // Using Java Reflection to get the class at runtime - this can have a performance hit
            for(String wearable : clothingTypeStrings.split(Constants.COMMA_SEPARATOR)){
                REQUIRED_CLOTHING.add((Class<Wearable>) Class.forName(Constants.PACKAGE_PREFIX + wearable));
            }

            // ClassNotFoundException will be thrown if property does not correspond to a class
        }catch (ClassNotFoundException ioe){
            throw new InvalidRequiredClothingPropertyException(Constants.INVALID_REQUIRED_CLOTHING_PROPERTY, ioe);
        }
    }

    public void addToOutfit(Wearable wearable) throws InvalidDressOrderException {
        outfit.addWearable(wearable);
    }

    /*
     * Checks to see if all required clothing are in the list
     **/
    public void checkRequiredClothing() throws IncompleteDressCodeException {
        //Return true only if all required clothing types are contained in the clothing list
        boolean hasRequiredClothing = REQUIRED_CLOTHING.stream()
                .allMatch(rc -> outfit.getCurrentWearables().stream()
                        .anyMatch(c -> rc == c.getClass()));

        if(!hasRequiredClothing){
            throw new IncompleteDressCodeException();
        }
    }
    
    public String getOutfitAsString(){
       return outfit.toString();
    }
}
