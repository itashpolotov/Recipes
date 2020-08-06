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
    RecyclerOnClickListener listener;

    public MealAdapter(Context context, List<Meal> mealList) {
        this.mealList = mealList;
        this.context = context;
    }

    public void setOnItemClickListener(RecyclerOnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_meal, parent, false); //use activity_meal

        return new MealHolder(view, listener);
    }

    //процесс соединения данных с макетом
    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        holder.imageView.setImageResource(mealList.get(position).getImage());
        holder.mealName.setText(mealList.get(position).getMealName());
        holder.mealDescription.setText(mealList.get(position).getMealDescription());
        holder.mealtime.setText(mealList.get(position).getArbeitzeit());
   if(mealList.get(position).isStarred()){
       holder.star.setVisibility(View.INVISIBLE);
       holder.star_filled.setVisibility((View.VISIBLE));
   }else {
       holder.star.setVisibility(View.VISIBLE);
       holder.star_filled.setVisibility((View.INVISIBLE));
   }
    }

    //узнает сколько блоков в итоге у нас будет
    @Override
    public int getItemCount() {
        return mealList.size();
    }

    //данный класс позволяет нам сопоставить данные с View элементами activity_meal.xml
    public static class MealHolder extends RecyclerView.ViewHolder {
        ImageView imageView, star,star_filled;
        TextView mealName;
        TextView mealDescription;
        TextView mealtime;



        public MealHolder(@NonNull View itemView, final RecyclerOnClickListener listener) {
            super(itemView); //example;
            imageView = itemView.findViewById(R.id.image);
            mealName = itemView.findViewById(R.id.mealName);
            mealDescription = itemView.findViewById(R.id.mealDescription);
            mealtime = itemView.findViewById(R.id.mealtime);

            star = itemView.findViewById(R.id.star_empty);
            star_filled=itemView.findViewById(R.id.star_filled);
            star.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onStarClick(position);
                   star.setVisibility(View.INVISIBLE);
                   star_filled.setVisibility((View.VISIBLE));
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });

        }
    }


    public interface RecyclerOnClickListener {
        void onItemClick(int position);

        void onStarClick(int position);


    }


}


