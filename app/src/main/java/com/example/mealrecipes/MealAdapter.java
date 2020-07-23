package com.example.mealrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealHolder> {

    List<Meal> mealList;
    Context context; //я мог пользоваться привилегиями Activity

    public MealAdapter(Context context, List<Meal> mealList) {
        this.mealList = mealList;
        this.context = context;
    }



    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_meal, parent, false);

        return new MealHolder(view);
    }

    //процесс соединения данных с макетом
    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        holder.imageView.setImageResource(mealList.get(position).getImage());
        holder.mealName.setText(mealList.get(position).getMealName());
        holder.mealDescription.setText(mealList.get(position).getMealDescription());
        holder.mealtime.setText(mealList.get(position).getMealTime());

    }

    //узнает сколько блоков в итоге у нас будет
    @Override
    public int getItemCount() {
        return mealList.size();
    }

    //данный класс позволяет нам сопоставить данные с View элементами example_item.xml
    public static class MealHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mealName;
        TextView mealDescription;
        TextView mealtime;

        public MealHolder(@NonNull View itemView) {
            super(itemView); //example;
            imageView = itemView.findViewById(R.id.image);
            mealName = itemView.findViewById(R.id.mealName);
            mealDescription = itemView.findViewById(R.id.mealDescription);
            mealtime=itemView.findViewById(R.id.mealtime);

        }
    }
}

