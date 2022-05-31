package com.example.travel_with_me.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.travel_with_me.R;

public class RetailerStartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_startup_screen);
    }

    public void callloginscreen(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);

        //Pair[] pairs = new Pair[1];

        //pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transistion_login");

        //noinspection JoinDeclarationAndAssignmentJava
        //ActivityOptions options = new ActivityOptions.makeSceneTransitionAnimation(RetailerStartupScreen.this, pairs);


        startActivity(intent);
    }

    public void callsignupscreen(View view) {
        Intent intent = new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }
}