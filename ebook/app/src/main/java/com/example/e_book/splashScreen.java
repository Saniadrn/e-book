package com.example.e_book;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashScreen extends AppCompatActivity {

    Handler handler = new Handler();//کمک به استفاده بهینه از CPU
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        handler.postDelayed(new Runnable() {//کاری را با میزان تاخیر مد نظر ما انجام می دهد
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();//جابه جایی و بستن
            }
        },3000);


    }
}