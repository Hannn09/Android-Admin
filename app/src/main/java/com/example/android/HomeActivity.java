package com.example.android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private ArrayList<card_model> modelArrayList;
    private adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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


}
