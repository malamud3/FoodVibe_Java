package com.example.foodvibe.Adpters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodvibe.R;
import com.example.foodvibe.models.Food_Order;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;


public class Adapter_Food extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private ArrayList<Food_Order> allFood = new ArrayList<>();
    private FoodItemClickListener foodItemClickListener;

    public Adapter_Food(Activity activity, ArrayList<Food_Order> allFood) {
        this.activity = activity;
        this.allFood = allFood;
    }

    public Adapter_Food setFoodItemClickListener(FoodItemClickListener foodItemClickListener) {
        this.foodItemClickListener = foodItemClickListener;
        return this;
    }

    @Override
    public RecyclerView.ViewHolder
    onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_food_d, viewGroup, false);
        return new FoodViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        FoodViewHolder foodViewHolder = (FoodViewHolder) holder;
        Food_Order food_order = getItem(position);
        Log.d("pttt", "position= " + position);

        foodViewHolder.movie_LBL_title.setText( food_order.getName());
        foodViewHolder.movie_LBL_actors.setText(food_order.getIngredients());
        int h = food_order.getEstimated_shipping_time() / 60;
        int m = food_order.getEstimated_shipping_time() % 60;
        String hh = h < 10 ? "0" + h : "" + h;
        String mm = m < 10 ? "0" + m : "" + m;
        foodViewHolder.movie_LBL_duration.setText(hh + "h " + mm + "m");
        int price=food_order.getPrice();
        foodViewHolder.price_img_main.setText("Price:"+price);


        Glide
                .with(activity)
                .load(food_order.getImage())
                .into(foodViewHolder.movie_IMG_image);

        if (food_order.isFavorite()) {
            foodViewHolder.movie_IMG_favorite.setImageResource(R.drawable.ic_heart_filled);
        } else  {
            foodViewHolder.movie_IMG_favorite.setImageResource(R.drawable.ic_heart_empty);
        }

        float rating = food_order.getRating();
        rating /= 20;
        foodViewHolder.movie_RTNG_stars.setRating(rating);
    }

    @Override
    public int getItemCount() {
        return allFood.size();
    }

    private Food_Order getItem(int position) {
        return allFood.get(position);
    }

    public interface FoodItemClickListener  {
        void foodItemClicked(Food_Order food_order, int position);
        void favoriteClicked(Food_Order food_order, int position);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        public AppCompatImageView movie_IMG_image;
        public AppCompatImageView movie_IMG_favorite;
        public MaterialTextView movie_LBL_title;
        public MaterialTextView movie_LBL_actors;
        public MaterialTextView movie_LBL_duration;
        public AppCompatRatingBar movie_RTNG_stars;
        public MaterialTextView price_img_main;

        public FoodViewHolder(final View itemView) {
            super(itemView);
            this.movie_IMG_image = itemView.findViewById(R.id.movie_IMG_image);
            this.movie_IMG_favorite = itemView.findViewById(R.id.movie_IMG_favorite);
            this.movie_LBL_title = itemView.findViewById(R.id.movie_LBL_title);
            this.movie_LBL_actors = itemView.findViewById(R.id.movie_LBL_actors);
            this.movie_LBL_duration = itemView.findViewById(R.id.movie_LBL_duration);
            this.movie_RTNG_stars = itemView.findViewById(R.id.movie_RTNG_stars);
            this.price_img_main = itemView.findViewById(R.id.price_img_main);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foodItemClickListener.foodItemClicked(getItem(getAdapterPosition()), getAdapterPosition());
                }
            });

            movie_IMG_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foodItemClickListener.favoriteClicked(getItem(getAdapterPosition()), getAdapterPosition());
                }
            });
        }
    }
}