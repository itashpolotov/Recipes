package com.example.mealrecipes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Meal> mealList=new ArrayList<>();

        mealList.add(new Meal(R.drawable.mukeka, "Мукека", "бразильский рыбный суп с креветками","30 минут"));
        mealList.add(new Meal(R.drawable.krambl,"Крамбл", "Крамбл с дыней и мюсли","35 минут"));
        mealList.add(new Meal(R.drawable.bulka,"Булка","Чесночно-сырная булка с травами","2 часа и 20 минут"));
        mealList.add(new Meal(R.drawable.cheesecake,"Чизкейк","Мини-чизкейк с дыней","30 минут"));
        mealList.add(new Meal(R.drawable.malinakeks,"Кекс","Кекс с малиной","1 час"));
        mealList.add(new Meal(R.drawable.adana,"Адана","Кебаб по турецки","30 минут"));
        mealList.add(new Meal(R.drawable.mukeka, "Мукека", "бразильский рыбный суп с креветками","30 минут"));
        mealList.add(new Meal(R.drawable.krambl,"Крамбл", "Крамбл с дыней и мюсли","35 минут"));
        mealList.add(new Meal(R.drawable.bulka,"Булка","Чесночно-сырная булка с травами","2 часа и 20 минут"));
        mealList.add(new Meal(R.drawable.cheesecake,"Чизкейк","Мини-чизкейк с дыней","30 минут"));
        mealList.add(new Meal(R.drawable.malinakeks,"Кекс","Кекс с малиной","1 час"));
        mealList.add(new Meal(R.drawable.adana,"Адана","Кебаб по турецки","30 минут"));

        //Recyclerview Adapter
        MealAdapter adapter=new MealAdapter(MainActivity.this,mealList);//указываем текущий активити чтобы связать с адаптером

        //Recyclerview config
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}