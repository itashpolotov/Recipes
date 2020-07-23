package com.example.mealrecipes;
public class Meal {
    private int image;
    private String mealName;
    private String mealDescription;
    private String mealTime;

    public Meal(int image, String mealName, String mealDescription, String mealTime) {
        this.image = image;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTime = mealTime;
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

    public String getMealTime() {
        return mealTime;
    }
}

