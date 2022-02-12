package com.example.foodvibe.View.data;

import androidx.annotation.NonNull;

import com.example.foodvibe.models.Food_Order;

import java.util.ArrayList;
import java.util.List;

import com.example.foodvibe.models.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireBaseDB {
    FireBaseDB(){}

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef   = database.getReference("users");
    List<Cart> users= new ArrayList<>();
    public FirebaseDatabase getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseDatabase database) {
        this.database = database;
    }

    public DatabaseReference getMyRef() {
        return  myRef;
    }

    public void setMyRef(DatabaseReference myRef) {
        this.myRef = myRef;
    }
    public interface CallBack_String {
        void dataReady(String value);
    }

    public interface CallBack_Food {
        void dataReady(ArrayList<Food_Order> allFood);
    }

    public static void getAllFoodList(CallBack_Food callBack_food) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("foodList");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Food_Order> allFood = new ArrayList<>();
                for (DataSnapshot child : snapshot.getChildren()) {
                    try {
                        Food_Order food_order = child.getValue(Food_Order.class);
                        allFood.add(food_order);
                    } catch (Exception ex) {}

                }
                if (callBack_food != null) {
                    callBack_food.dataReady(allFood);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
//    public void readUserCart(){
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot key : snapshot.getChildren()){
//                    Cart cart=new Cart();
//                    cart.setUserName(key.getKey());
//                    cart.setFood_order(key.getValue().toString());
//                    users.add(cart);
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
//    }


}