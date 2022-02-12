package com.example.foodvibe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodvibe.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class Activity_Login extends AppCompatActivity {

    private TextInputEditText etLoginEmail;
    private TextInputEditText etLoginPassword;
    private TextView tvRegisterHere;
    private Button btnLogin;
    private FirebaseAuth mAuth;


    /* Life_circle   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        initUi();

    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    /* Life_circle   */

    private void initUi() {
      initViews();
      btnHandle();
     }

    private  void initViews(){
    etLoginEmail = findViewById(R.id.etLoginEmail);
    etLoginPassword = findViewById(R.id.etLoginPass);
    tvRegisterHere = findViewById(R.id.tvRegisterHere);
    btnLogin = findViewById(R.id.btnLogin);
}

    private void btnHandle() {
        btnLogin.setOnClickListener(view -> loginUser());
        tvRegisterHere.setOnClickListener(view -> {
            startActivity(new Intent(Activity_Login.this, Activity_Register.class));
            finish();
        });
    }

    private void loginUser(){
        String email = Objects.requireNonNull(etLoginEmail.getText()).toString();
        String password = Objects.requireNonNull(etLoginPassword.getText()).toString();

        if (TextUtils.isEmpty(email)){
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etLoginPassword.setError("Password cannot be empty");
            etLoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Activity_Login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_Login.this, Activity_WhatVibeUser.class));
                    finish();
                }else{
                    Toast.makeText(Activity_Login.this, "Log in Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
