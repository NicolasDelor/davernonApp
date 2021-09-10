package com.nicolasdelor.davernonapp;

public class Card {
    public String id;

    public String mName;
    public int mStamina;
    public int mVitesse;
    public String mDescription;
    public String mDescriptionBax;
    public Stance[] mStances;
    public MindSet[] mMindSets;

    public int mImage;

    public Card(String id, String mName, int mStamina, int mVitesse, String mDescription, String mDescriptionBax, Stance[] mStances, MindSet[] mMindSets, int mImage) {
        this.id = id;
        this.mName = mName;
        this.mStamina = mStamina;
        this.mVitesse = mVitesse;
        this.mDescription = mDescription;
        this.mDescriptionBax = mDescriptionBax;
        this.mStances = mStances;
        this.mMindSets = mMindSets;
        this.mImage = mImage;
    }

    public Card(String id, String mName, int mImage) {
        this.id = id;
        this.mName = mName;
        this.mImage = mImage;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmStamina() {
        return mStamina;
    }

    public void setmStamina(int mStamina) {
        this.mStamina = mStamina;
    }

    public int getmVitesse() {
        return mVitesse;
    }

    public void setmVitesse(int mVitesse) {
        this.mVitesse = mVitesse;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDescriptionBax() {
        return mDescriptionBax;
    }

    public void setmDescriptionBax(String mDescriptionBax) {
        this.mDescriptionBax = mDescriptionBax;
    }

    public Stance[] getmStances() {
        return mStances;
    }

    public void setmStances(Stance[] mStances) {
        this.mStances = mStances;
    }

    public MindSet[] getmMindSets() {
        return mMindSets;
    }

    public void setmMindSets(MindSet[] mMindSets) {
        this.mMindSets = mMindSets;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}


