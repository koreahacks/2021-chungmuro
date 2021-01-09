package com.example.budd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class diarylistAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Integer> imageList;
    private ArrayList<String> oppositeList;

    public diarylistAdapter(Context context, ArrayList<Integer> imageList, ArrayList<String> oppositeList)
    {
        this.mContext = context;
        this.imageList = imageList;
        this.oppositeList = oppositeList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.diarycover1, null);

        ImageView imageView = view.findViewById(R.id.coverView);
        imageView.setImageResource(imageList.get(position));

        TextView textView = view.findViewById(R.id.oppositeid);
        textView.setText(oppositeList.get(position));

        container.addView(view);

        if(position==0) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
        else if(position==3) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, NewPage_selectInter.class);
                    mContext.startActivity(intent);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, NewPage_selectInter.class);
                    mContext.startActivity(intent);
                }
            });
        }

        return view;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (View)o);
    }
}
