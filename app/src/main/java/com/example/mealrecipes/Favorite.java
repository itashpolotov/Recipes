package com.example.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mealrecipes.Util.DatabaseHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {
    DatabaseHandler handler=new DatabaseHandler(this);
    List<Meal> favoriteList = new ArrayList();
    List<Meal> mealList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
       /* Intent intent = getIntent();
        favoriteList = (List<Meal>) intent.getSerializableExtra("favorite");*/
       mealList=handler.getAllMeals();

       for(Meal meal:mealList){ //select all items signed with a star as favorite

           if(meal.isStarred()){
               favoriteList.add(meal);
               Log.i("MYTAG",meal.getMealName());
               Log.i("MYTAG",String.valueOf(meal.isStarred()))
               ;

           }
       }


 //Toast.makeText(Favorite.this, String.valueOf(favoriteList.size()), Toast.LENGTH_SHORT).show();

   RecyclerView recyclerView;
        final FavoriteAdapter favoriteAdapter = new FavoriteAdapter(Favorite.this,favoriteList);
        favoriteAdapter.setOnItemClickListener(new FavoriteAdapter.RecyclerOnClickListener() {

            @Override
            public void onItemClick(int position) {

                Intent intentFavorite = new Intent(Favorite.this, Mealdetails.class);

                if (!favoriteList.isEmpty()) {
                    intentFavorite.putExtra("meal", (Serializable) favoriteList);
                    intentFavorite.putExtra("position", (int) position);
                }

                startActivity(intentFavorite);
            }

            @Override
            public void onDeleteClick(int position) {
                for(Meal meal:mealList){ //select all items signed with a star as favorite

                    if(meal.getId()==favoriteList.get(position).getId()){
                  //      Log.i("MYTAG",String.valueOf(meal.isStarred()));
                       meal.setStarred(false);
                 //      Log.i("MYTAG",meal.getMealName());
                 //       Log.i("MYTAG",String.valueOf(meal.isStarred()));
                        handler.updateMeal(meal);
                    }
                }
                favoriteList.remove(position);
              
                favoriteAdapter.notifyItemRemoved(position);
            }

        });
        recyclerView = findViewById(R.id.recyclerViewFavorite);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(favoriteAdapter);


    }
}