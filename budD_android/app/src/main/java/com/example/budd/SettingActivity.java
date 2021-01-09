package com.example.budd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    ImageButton favor_travel, favor_sports, favor_movie, favor_book,
            favor_mbti, favor_tech, favor_marketing, favor_design, favor_career, modifybtn;
    int SIZE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SIZE = 0;
        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        favor_travel = (ImageButton) findViewById(R.id.travelBtn);
        favor_sports = (ImageButton) findViewById(R.id.sportsBtn);
        favor_movie = (ImageButton) findViewById(R.id.movieBtn);
        favor_book = (ImageButton) findViewById(R.id.bookBtn);
        favor_mbti = (ImageButton) findViewById(R.id.mbtiBtn);
        favor_tech = (ImageButton) findViewById(R.id.techBtn);
        favor_marketing = (ImageButton) findViewById(R.id.marketingBtn);
        favor_design = (ImageButton) findViewById(R.id.designBtn);
        favor_career = (ImageButton) findViewById(R.id.careerBtn);

        modifybtn = (ImageButton) findViewById(R.id.modifyBtn);

        favor_sports.setSelected(true);
        favor_book.setSelected(true);

        favor_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favor_travel.isSelected()){
                    favor_travel.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_travel.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });

        favor_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_sports.isSelected()){
                    favor_sports.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_sports.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_movie.isSelected()){
                    favor_movie.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_movie.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_book.isSelected()){
                    favor_book.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_book.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_mbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_mbti.isSelected()){
                    favor_mbti.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_mbti.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_tech.isSelected()){
                    favor_tech.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_tech.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_marketing.isSelected()){
                    favor_marketing.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_marketing.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_design.isSelected()){
                    favor_design.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_design.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });
        favor_career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favor_career.isSelected()){
                    favor_career.setSelected(false);
                    SIZE--;
                }else if(SIZE<5){
                    favor_career.setSelected(true);
                    SIZE++;
                }else{
                    Toast.makeText(getApplicationContext(),"관심사는 최대 5개 선택 가능합니다",Toast.LENGTH_SHORT).show();

                }
            }
        });

        modifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}