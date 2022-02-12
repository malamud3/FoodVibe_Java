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

public class Activity_Register extends AppCompatActivity {



    private TextInputEditText etRegEmail;
    private TextInputEditText etRegPassword;
    private TextView tvLoginHere;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    /* Life_circle   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    protected void onStart() {
        super.onStart();
        initUi();
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
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPass);
        tvLoginHere = findViewById(R.id.tvLoginHere);
        btnRegister = findViewById(R.id.btnRegister);
    }
    private void btnHandle(){
        btnRegister.setOnClickListener(view -> createUser());
        tvLoginHere.setOnClickListener(view -> closeActivity());
    }
    private void closeActivity(){
        startActivity(new Intent(Activity_Register.this, Activity_Login.class));
        finish();
    }
    private void createUser(){
        String email = Objects.requireNonNull(etRegEmail.getText()).toString();
        String password = Objects.requireNonNull(etRegPassword.getText()).toString();

        if (TextUtils.isEmpty(email)){
            etRegEmail.setError("Email cannot be empty");
            etRegEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etRegPassword.setError("Password cannot be empty");
            etRegPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Activity_Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_Register.this,Activity_Login.class));
                }else{
                    Toast.makeText(Activity_Register.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}