package com.example.foodvibe.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodvibe.R;


public class Activity_WhatVibeUser extends AppCompatActivity {

    Button btn_delivery, btn_Food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_vibe_user);
    }
    @Override
    protected void onStart() {
        super.onStart();
        initUi();
    }

    private void initUi() {
        initViews();
        btnHandle();
    }

    private  void initViews(){
       btn_delivery = findViewById(R.id.btn_delivery);
        btn_Food = findViewById(R.id.btn_Food);
    }

    private void btnHandle() {
        btn_delivery.setOnClickListener(view ->{

            startActivity(new Intent(Activity_WhatVibeUser.this, Activity_Delivery_Main.class));
        });

        btn_Food.setOnClickListener(view ->{

            startActivity(new Intent(Activity_WhatVibeUser.this, Activity_Customer_Main.class));
        });
    }

}
