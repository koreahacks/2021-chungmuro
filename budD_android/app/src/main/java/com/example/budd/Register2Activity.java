package com.example.budd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Register2Activity extends AppCompatActivity {

    ImageButton favor_travel, favor_sports, favor_movie, favor_book, favor_mbti, favor_tech, favor_marketing, favor_design, favor_career, registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);

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

        registerbtn = (ImageButton) findViewById(R.id.registerBtn);

        favor_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(true);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });

        favor_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(true);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(true);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(true);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_mbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(true);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(true);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(true);
                favor_design.setSelected(false);
                favor_career.setSelected(false);
            }
        });
        favor_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(true);
                favor_career.setSelected(false);
            }
        });
        favor_career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favor_travel.setSelected(false);
                favor_sports.setSelected(false);
                favor_movie.setSelected(false);
                favor_book.setSelected(false);
                favor_mbti.setSelected(false);
                favor_tech.setSelected(false);
                favor_marketing.setSelected(false);
                favor_design.setSelected(false);
                favor_career.setSelected(true);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);*/
            }
        });
    }
}
