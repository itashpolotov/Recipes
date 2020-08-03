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

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder> {

    List<Meal> favoriteList;
    Context context; //я мог пользоваться привилегиями Activity
    RecyclerOnClickListener listener;

    public FavoriteAdapter(Context context, List<Meal> favoriteList) {
        this.favoriteList = favoriteList;
        this.context = context;
    }

    public void setOnItemClickListener(RecyclerOnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_favorite_meal, parent, false); //use activity_meal

        return new FavoriteHolder(view, listener);
    }

    //процесс соединения данных с макетом
    @Override
    public void onBindViewHolder(@NonNull FavoriteHolder holder, int position) {
        holder.imageView.setImageResource(favoriteList.get(position).getImage());
        holder.mealName.setText(favoriteList.get(position).getMealName());
        holder.mealDescription.setText(favoriteList.get(position).getMealDescription());
        holder.mealtime.setText(favoriteList.get(position).getArbeitzeit());

    }

    //узнает сколько блоков в итоге у нас будет
    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    //данный класс позволяет нам сопоставить данные с View элементами activity_favorite.xml
    public static class FavoriteHolder extends RecyclerView.ViewHolder {
        ImageView imageView, delete;
        TextView mealName;
        TextView mealDescription;
        TextView mealtime;


        public FavoriteHolder(@NonNull View itemView, final RecyclerOnClickListener listener) {
            super(itemView); //example;
            imageView = itemView.findViewById(R.id.image);
            mealName = itemView.findViewById(R.id.mealName);
            mealDescription = itemView.findViewById(R.id.mealDescription);
            mealtime = itemView.findViewById(R.id.mealtime);
            delete = itemView.findViewById(R.id.delete_image);
            delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onDeleteClick(position);
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



        void onDeleteClick(int position);
    }


}


