package com.example.mealrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Mealdetails extends AppCompatActivity {
    List<Meal> mealList=new ArrayList<>();
    int position;

    ImageView image;
    TextView mealName,mealDescription, arbeitzeit,ruhezeit,gesamtzeit,portion,zutaten,zubereitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealdetails);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //initialization;
        Intent intent=getIntent();
        image=findViewById(R.id.imageView);
        mealName=findViewById(R.id.mealName);
        mealDescription=findViewById(R.id.mealDescription);
        arbeitzeit=findViewById(R.id.arbeitZeit);
        ruhezeit=findViewById(R.id.ruheZeit);
        gesamtzeit=findViewById(R.id.gesamtZeit);
        portion=findViewById(R.id.portion);
        zutaten=findViewById(R.id.zutaten);
        zubereitung=findViewById(R.id.zubereitung);

        mealList=(List<Meal>) intent.getSerializableExtra("meal");
        position=intent.getIntExtra("position",0);
        Log.i("MYTAG",mealList.get(position).getMealName());

        mealName.setText(mealList.get(position).getMealName());
        image.setImageResource(mealList.get(position).getImage());
        arbeitzeit.setText(mealList.get(position).getArbeitzeit());
        ruhezeit.setText(mealList.get(position).getRuhezeit());
        gesamtzeit.setText(mealList.get(position).getGesamtzeit());
        portion.setText(String.valueOf(mealList.get(position).getPortion()));
        zutaten.setText(mealList.get(position).getZutaten());
        zubereitung.setText(mealList.get(position).getZubereitung());



    }
}