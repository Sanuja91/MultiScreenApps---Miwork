package com.example.android.miwok;

import android.util.Log;

/**
 * Created by Sanuja on 7/12/2016.
 */
public class Word{

    // String Value for Miwok Word
    private String mMiwokTranslation;

    // String Value for English Word
    private String mDefaultTranslation;

    // Image Resource ID
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Music Resource ID
    private int mMusicResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Constructs a new Word with initial values for Miwok and English words
     */
    public Word (String defaultTranslation, String miwokTranslation, int musicResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mMusicResourceId = musicResourceId;

    }

    /**
     * Constructs a new Word with initial values for Miwok, English words and Image Resource ID
     */

    public Word (String defaultTranslation, String miwokTranslation, int imageResourceId, int musicResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mMusicResourceId = musicResourceId;

    }


    // Returns English Word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    // Returns Miwok Word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    // Get Image Resource ID
    public int getImageResource(){
        return mImageResourceId;
    }

    // Get Music Resource ID
    public int getMusicResource(){
        return mMusicResourceId;
    }

    // States whether the word has an Image
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;

    }
}
