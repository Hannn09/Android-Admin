package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class adapter extends PagerAdapter {

    private Context context;
    private ArrayList<card_model> modelArrayList;

    //constructor
    public adapter(Context context, ArrayList<card_model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout card_item.xml
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        //init views from card_item.xml
        final TextView news = view.findViewById(R.id.news);
        final TextView item = view.findViewById(R.id.item);
        final TextView total = view.findViewById(R.id.total);


        //get data
        card_model model = modelArrayList.get(position);
        String modelNews= model.getNews();
        String modelItem = model.getItem();
        String modelTotal = model.getTotal();


        //set data
        news.setText(modelNews);
        item.setText(modelItem);
        total.setText(modelTotal);


        //handle card
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, news + "\n" + item +"\n" + total +"\n", Toast.LENGTH_SHORT).show();

            }
        });

        //add view
        container.addView(view, position);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
