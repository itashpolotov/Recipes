package com.example.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {
    List<Meal> favoriteList = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Intent intent = getIntent();
        favoriteList = (List<Meal>) intent.getSerializableExtra("favorite");
        Log.i("MYTAG",favoriteList.get(0).getMealName());
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