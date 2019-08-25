package com.ookie.dietapp.model;

public class Diet {

    private String mDiet;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    //Set to -1, so it is impossible to reference another image
    private static final int NO_IMAGE_PROVIDED = -1;

    //Description is an integer - will be an XML reference
    private int mDescription;


    //CONSTRUCTORS - Name must be available!

    //If only the title/name is available
    public Diet(String diet) {
        mDiet = diet;
    }

    //If only name and description are available
    public Diet(String diet, int description) {
        mDiet = diet;
        mDescription = description;
    }

    //If name, picture and description available
    public Diet(String diet, int imageResourceID, int description) {
        mDiet = diet;
        mImageResourceID = imageResourceID;
        mDescription = description;
    }

    public String getDietName() {
        return mDiet;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public int getDescription() {
        return mDescription;
    }

    //If pic has ID, image will return, if not will default to -1
    boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

}
