package com.example.budd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
/*

private DrawerLayout drawerLayout;
private View drawerView;
*/

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> imageList;
    private ArrayList<String> oppositeList;
    private static final int DP = 24;
    ImageView settingbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.initializeData();
        settingbtn = (ImageView)findViewById(R.id.settingBtn);
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new diarylistAdapter(this, imageList, oppositeList));

        /*drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawerView);
        drawerLayout.setDrawerListener(listener);*/
    }

    public void initializeData()
    {
        imageList = new ArrayList();

        imageList.add(R.drawable.diarycover1);
        imageList.add(R.drawable.diarycover2);
        imageList.add(R.drawable.diarycover3);
        imageList.add(R.drawable.main_newpage);

        oppositeList = new ArrayList();

        oppositeList.add("jay_g 과의 교환 일기장");
        oppositeList.add("tube 와의 교환 일기장");
        oppositeList.add("kakao 와의 교환 일기장");
        oppositeList.add("새 교환 일기 작성");

    }

    /*DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {

        drawerLayout.openDrawer(drawerView);
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };*/
}