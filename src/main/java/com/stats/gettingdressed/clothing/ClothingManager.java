package com.stats.gettingdressed.clothing;

import com.stats.gettingdressed.exception.UnknownClothingArticleException;


/*
* Manages the articles of clothing and shields them from the outside world
* Facade pattern using singleton
* */
public class ClothingManager {

    private volatile static ClothingManager clothingManagerInstance;

    /*
     * Private default constructor to ensure only the class can instantiate an object
     **/
    private ClothingManager() {}

    /*
     * Gets instance of the ClothingManager singleton, synchronized for thread safety when singleton is not initialized
     **/
    public synchronized static ClothingManager getInstance()  {

        //Check to see if initialized and if not create an instance of ClothingManager
        if(clothingManagerInstance == null){
            clothingManagerInstance = new ClothingManager();
        }

        //Return the self reference of the instance
        return clothingManagerInstance;
    }

    /*
     * Returns the clothing that the input number matches to
     **/
    public Wearable getClothingByInput(int input) throws UnknownClothingArticleException{
        return ClothingFactory.getInstance(input);
    }
}
