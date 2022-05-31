package com.example.travel_with_me.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.travel_with_me.R;
import com.example.travel_with_me.user.dashboard;

public class onBoarding extends AppCompatActivity {

    Button get_started;

    View view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        get_started = findViewById(R.id.get_started);



    }

   

    public void next(View view) {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
        finish();
    }
}