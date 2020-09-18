package com.example.android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<card_model> modelArrayList;
    private adapter adapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewPager);
        loadCards();
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        //add items
        modelArrayList.add(new card_model("Berita","Item","10"));
//        modelArrayList.add(new card_model("Pengumuman","Item","20"));
//        modelArrayList.add(new card_model("Agenda","Item","30"));

        adapter = new adapter(this, modelArrayList);

        //set data adapter
        viewPager.setAdapter(adapter);

        //set default padding
        viewPager.setPadding(5,0,5,0);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}
