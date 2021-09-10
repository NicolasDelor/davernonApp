package com.nicolasdelor.davernonapp;

public class MindSet {
    public int mId;
    public String mName;
    public int mImg;

    public MindSet(int mId, String mName, int mImg) {
        this.mId = mId;
        this.mName = mName;
        this.mImg = mImg;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }
}
