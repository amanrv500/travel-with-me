package com.example.travel_with_me.Common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travel_with_me.R;

public class splashscreen extends AppCompatActivity {

    private static int SPLAST_TIMER = 5000;

    ImageView background_image;
    TextView createdbyline;


    Animation sideanim, bottomanim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);

        //hooks
        background_image = findViewById(R.id.background_image);
        createdbyline = findViewById(R.id.createdbyline);
        sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set animation on elements
        background_image.setAnimation(sideanim);
        createdbyline.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this, onBoarding.class);
                startActivity(intent);
                finish();

            }
        },SPLAST_TIMER);

    }
}