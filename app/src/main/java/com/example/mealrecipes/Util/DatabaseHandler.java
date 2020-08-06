package com.example.mealrecipes.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mealrecipes.Meal;

import java.util.ArrayList;
import java.util.List;


    public class DatabaseHandler extends SQLiteOpenHelper {
        public DatabaseHandler(@Nullable Context context) {
            super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
        }
        //AUTO INCREMENT
        @Override
        public void onCreate(SQLiteDatabase db) { //used to create the DB
            //SQL Structured Query Language
            String CREATE_MEALS_TABLE="CREATE TABLE "+ Util.TABLE_NAME+"("
                    +Util.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +Util.KEY_IMAGE+ " INTEGER,"
                    + Util.KEY_NAME+ " TEXT,"
                    +Util.KEY_DESCRIPTION+ " TEXT,"
                    +Util.KEY_ARBEITZEIT+ " TEXT,"
                    +Util.KEY_RUHEZEIT+ " TEXT,"
                    +Util.KEY_GESAMTZEIT+ " TEXT,"
                    +Util.KEY_PORTION+ " INTEGER,"
                    +Util.KEY_ZUTATEN+ " TEXT,"
                    +Util.KEY_ZUBEREITUNG+ " TEXT,"
                    +Util.KEY_ISTARRED+ " INTEGER"+")";
            db.execSQL(CREATE_MEALS_TABLE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Util.TABLE_NAME);
            onCreate(db);
        }

        public void addMeal(Meal meal) {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues(); //needed to write data
            contentValues.put(Util.KEY_IMAGE,meal.getImage());
            contentValues.put(Util.KEY_NAME,meal.getMealName());
            contentValues.put(Util.KEY_DESCRIPTION,meal.getMealDescription());
            contentValues.put(Util.KEY_ARBEITZEIT,meal.getArbeitzeit());
            contentValues.put(Util.KEY_RUHEZEIT,meal.getRuhezeit());
            contentValues.put(Util.KEY_GESAMTZEIT,meal.getGesamtzeit());
            contentValues.put(Util.KEY_ZUBEREITUNG,meal.getZubereitung());
            contentValues.put(Util.KEY_ZUTATEN,meal.getZutaten());
            contentValues.put(Util.KEY_PORTION,meal.getPortion());

            if (meal.isStarred()) {
                contentValues.put(Util.KEY_ISTARRED, 1);
            }else{
                contentValues.put(Util.KEY_ISTARRED, 0);
            }

            db.insert(Util.TABLE_NAME,null,contentValues);
            db.close();
        }
        public void updateMeal(Meal meal) {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues(); //needed to write data
            if (meal.isStarred()) {
                contentValues.put(Util.KEY_ISTARRED, 1);
            }else{
                contentValues.put(Util.KEY_ISTARRED, 0);
            }
            String where = Util.KEY_ID + "=" + meal.getId();

           db.update(Util.TABLE_NAME, contentValues, where, null);


            db.close();
        }
        //Read-{id}-> Meal, List<Meal>
        public Meal getMeal(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_IMAGE,Util.KEY_NAME, Util.KEY_DESCRIPTION,Util.KEY_ARBEITZEIT,Util.KEY_RUHEZEIT,Util.KEY_GESAMTZEIT,Util.KEY_PORTION,Util.KEY_ZUTATEN,Util.KEY_ZUBEREITUNG, Util.KEY_ISTARRED}, Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            Meal meal=new Meal(Integer.parseInt(cursor.getString(0)),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),Integer.parseInt(cursor.getString(7)),cursor.getString(8),cursor.getString(9));
             if (Integer.parseInt(cursor.getString(10))==1){
                 meal.setStarred(true);
             }else{
                 meal.setStarred(false);
             }
            return meal;
        }

        public List<Meal> getAllMeals(){
            SQLiteDatabase db=this.getReadableDatabase();

            List<Meal> mealList=new ArrayList<>();

            String selectAllMeals="SELECT * FROM "+Util.TABLE_NAME;
            Cursor cursor=db.rawQuery(selectAllMeals,null);

            if(cursor.moveToFirst()){
                do{

                    Meal meal=new Meal(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),Integer.parseInt(cursor.getString(7)),cursor.getString(8),cursor.getString(9));
                    if (Integer.parseInt(cursor.getString(10))==1){
                        meal.setStarred(true);
                    }else{
                        meal.setStarred(false);
                    }
                    mealList.add(meal);
                }while (cursor.moveToNext()); //while cursor can to move to the next element
            }
            return mealList;
        }
    }

