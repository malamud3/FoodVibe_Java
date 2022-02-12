package com.example.foodvibe.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodvibe.Adpters.Adapter_Food;
import com.example.foodvibe.R;
import com.example.foodvibe.View.data.Data;
import com.example.foodvibe.View.data.FireBaseDB;
import com.example.foodvibe.models.Food_Order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_Customer_Main extends AppCompatActivity {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private RecyclerView food_list;
    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);
        user.getDisplayName();
        food_list = findViewById(R.id.food_list);

        ArrayList<Food_Order> allFood = Data.generateFood();

        Adapter_Food adapter_food = new Adapter_Food(this, allFood);


        // Grid
        food_list.setLayoutManager(new GridLayoutManager(this, 2));
        food_list.setHasFixedSize(true);
        food_list.setItemAnimator(new DefaultItemAnimator());
        food_list.setAdapter(adapter_food);

        adapter_food.setFoodItemClickListener(new Adapter_Food.FoodItemClickListener() {

            @Override
            public void foodItemClicked(Food_Order food_order, int position) {
                Toast.makeText(Activity_Customer_Main.this, food_order.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void favoriteClicked(Food_Order food_order, int position) {
                food_order.setFavorite(!food_order.isFavorite());
                Toast.makeText(Activity_Customer_Main.this, food_order.isFavorite() + "\n" + food_order.getName(), Toast.LENGTH_SHORT).show();
                Objects.requireNonNull(food_list.getAdapter()).notifyItemChanged(position);
            }
        });

    }

    FireBaseDB.CallBack_String callBack_string = new FireBaseDB.CallBack_String() {
        @Override
        public void dataReady(String userName) {
            Log.d("putt", "customer: " + userName + " Thread: " + Thread.currentThread().getName());
        }
    };

    FireBaseDB.CallBack_Food callBack_food = new FireBaseDB.CallBack_Food() {
        @Override
        public void dataReady(ArrayList<Food_Order> foodData) {
        }
    };
       // FireBaseDB.getAllFood(callBack_food);
}