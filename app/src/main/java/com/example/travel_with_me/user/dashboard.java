package com.example.travel_with_me.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travel_with_me.Common.LoginSignup.RetailerStartupScreen;
import com.example.travel_with_me.Databases.DBHelper;
import com.example.travel_with_me.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.travel_with_me.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.travel_with_me.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.travel_with_me.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.travel_with_me.R;
import com.example.travel_with_me.airport;
import com.example.travel_with_me.hotel;
import com.example.travel_with_me.restaurant;
import com.example.travel_with_me.shops;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    RecyclerView featuredRecycler,mostViewedRecycler;
    RecyclerView.Adapter adapter;


    static final float END_SCALE = 0.7f;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdashboard);

        featuredRecycler = findViewById(R.id.featuredRecycler);
        mostViewedRecycler = findViewById(R.id.mostViewedRecycler);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        navigationDrawer();



        featuredRecycler();
        mostViewedRecycler();
    }

    private void navigationDrawer(){

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //animateNavigationDrawer();
    }

    /*
    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }
    */


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    private void featuredRecycler(){


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.malpe,"Malpe Beach", "One of Best Beach in Manipal, Best for families, You can Find Many Fun Activities Here Like Para Sailing"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kapu,"Kapu", "Kapu is a beach village in coastal Karnataka. Kapu’s long sandy beaches offer a panoramic view of the Arabian Sea. With its tropical climate and a bevy of attractions"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.chikmagalur,"Chikmagalur", "Translated as the ‘Young Daughter’s Town’ as it was presented as dowry to the younger daughter of the Chief of Sakrepatna, Rukmangada, this serene city is also known as the ‘Coffee Land of Karnataka’ tranquilizing you from within with its aroma."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);



    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.malpe, "Malpe Beach"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.kapu, "Kapu Beach"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.chikmagalur, "CHikmagalur Hill Station"));


        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }


    public void Retaileriew(View view) {
        startActivity(new Intent(getApplicationContext(), RetailerStartupScreen.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    public void gotomap(View view) {
        Intent intent = new Intent(getApplicationContext(), hotel.class);
        startActivity(intent);

    }

    public void gotorestaurant(View view) {
        Intent intent = new Intent(getApplicationContext(), restaurant.class);
        startActivity(intent);
    }

    public void gotoairport(View view) {

        Intent intent = new Intent(getApplicationContext(), airport.class);
        startActivity(intent);
    }

    public void gotoshop(View view) {
        Intent intent = new Intent(getApplicationContext(), shops.class);
        startActivity(intent);
    }
}