package com.example.foodvibe.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodvibe.R;

public class Activity_Splash extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        videoView = findViewById(R.id.viewVideo);
        String path = "android.resource://" +    getPackageName() +  "/raw/splash";



        videoView.setVideoPath(path);

        videoView.setOnCompletionListener(mp -> new Handler().postDelayed(() -> {
            startActivity(new Intent(Activity_Splash.this,Activity_Login.class));
            finish();
        },200));
        videoView.start();

    }
}