package com.example.mealrecipes;

import java.io.Serializable;

public class Meal implements Serializable {
    private int image;
    private String mealName;
    private String mealDescription;
    private String arbeitzeit;
    private String ruhezeit;
    private String gesamtzeit;
    private int portion;
    private String zutaten;
    private String zubereitung;
    private boolean isStarred;

    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        isStarred = starred;
    }

    public String getArbeitzeit() {
        return arbeitzeit;
    }

    public String getRuhezeit() {
        return ruhezeit;
    }

    public String getGesamtzeit() {
        return gesamtzeit;
    }

    public int getPortion() {
        return portion;
    }

    public String getZutaten() {
        return zutaten;
    }

    public String getZubereitung() {
        return zubereitung;
    }

    public Meal(int image, String mealName, String mealDescription, String arbeitzeit, String ruhezeit, String gesamtzeit, int portion, String zutaten, String zubereitung) {
        this.image = image;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.arbeitzeit = arbeitzeit;
        this.ruhezeit = ruhezeit;
        this.gesamtzeit = gesamtzeit;
        this.portion = portion;
        this.zutaten = zutaten;
        this.zubereitung = zubereitung;
    }




    public int getImage() {
        return image;
    }

    public String getMealName() {
        return mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }


}

