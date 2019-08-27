package com.stats.gettingdressed.clothing;

import com.stats.gettingdressed.exception.UnknownClothingArticleException;

/*
* Factory to create clothing
* Also defines enum that matches input parameters
* Springboot would allow me to skip making the factory as I can just define my bean
* And auto wire it using the IoC container and dependency injection
* */
class ClothingFactory {

    /*
     * Name of enum matches input
     **/
    enum ClothingType {
        DEFAULT, //No input for 0
        HAT, //Hat input is 1
        PANTS, //Pants input is 2
        SHIRT, //Shirt input is 3
        SHOES, //Shoes input is 4
        SOCKS //Socks input is 5
    }

    /*
     *Returns clothing article specified by the enumeration, otherwise throws an exception
     **/
    static Wearable getInstance(int input) throws UnknownClothingArticleException{
        ClothingType clothingType = ClothingType.values()[input];

        Wearable newClothingArticle;

        switch (clothingType){
            case HAT:
                newClothingArticle = new Hat();
                break;
            case PANTS:
                newClothingArticle = new Pants();
                break;
            case SHIRT:
                newClothingArticle = new Shirt();
                break;
            case SHOES:
                newClothingArticle = new Shoes();
                break;
            case SOCKS:
                newClothingArticle = new Socks();
                break;
            default:
                throw new UnknownClothingArticleException();
        }

        return newClothingArticle;
    }

}
