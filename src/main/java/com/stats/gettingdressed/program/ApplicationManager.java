package com.stats.gettingdressed.program;

import com.stats.gettingdressed.clothing.ClothingManager;
import com.stats.gettingdressed.outfit.OutfitManager;
import com.stats.gettingdressed.exception.IncompleteDressCodeException;
import com.stats.gettingdressed.exception.InvalidDressOrderException;
import com.stats.gettingdressed.exception.UnknownClothingArticleException;

import com.stats.gettingdressed.util.Constants;

import java.util.Scanner;

/*
 * Facade for the application, instead of pointing facades of each package to each other creating dependencies
 * this class will orchestrate all communication making them less reliant on each other
 * Manages flow of application and communication between the Clothing and Outfit facade
 **/
class ApplicationManager {
    private static ApplicationManager applicationManager;

    private ApplicationManager(){
    }

    /*
     * Package protected as it sits in same package as main
     **/
    synchronized static ApplicationManager getInstance(){
        if(applicationManager == null){
            applicationManager = new ApplicationManager();
        }
        return applicationManager;
    }

    /*
     * One method to run workflow
     **/
    void runApplication(){
        //Get manager
        OutfitManager outfitManager = OutfitManager.getInstance();
        ClothingManager clothingManager = ClothingManager.getInstance();

        if(outfitManager == null){
            return;
        }

        try {
            //Read input
            Scanner sc = new Scanner(System.in);
            System.out.println(Constants.INPUT_REQUEST);
            String inputs = sc.nextLine();

            //Close reader
            sc.close();

            //Open new scanner with string input so that only one line is read
            sc = new Scanner(inputs);

            //Loop through all integer inputs from scanned line
            while(sc.hasNext()){
                int input = sc.nextInt();

                //Set the final message to leave if we come across 6 and break out of loop
                if(input == Constants.INPUT_FOR_COMPLETE){
                    break;
                }
                //Add clothing specified by input to outfit
                outfitManager.addToOutfit(clothingManager.getClothingByInput(input));
            }

            outfitManager.checkRequiredClothing();
            System.out.println(outfitManager.getOutfitAsString()+ Constants.LEAVE);
            sc.close();
        }catch (InvalidDressOrderException | IncompleteDressCodeException | UnknownClothingArticleException ex){
            System.out.println(OutfitManager.getInstance().getOutfitAsString() + Constants.FAIL);
        }
    }
}
