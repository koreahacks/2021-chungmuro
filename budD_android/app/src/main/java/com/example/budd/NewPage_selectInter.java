package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewPage_selectInter extends AppCompatActivity {
    Button btnInter_travel, btnInter_sport, btnInter_movie, btnInter_books, btnInter_mbti, btnInter_tech, btnInter_marketing, btnInter_design, btnInter_career,
            btnSex_f, btnSex_m, btnNext;

    String yourInterest, yourSex = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage_select_inter);

        btnInter_travel = findViewById(R.id.btnInter_travel);
        btnInter_sport = findViewById(R.id.btnInter_sport);
        btnInter_movie = findViewById(R.id.btnInter_movie);
        btnInter_books = findViewById(R.id.btnInter_books);
        btnInter_mbti = findViewById(R.id.btnInter_mbti);
        btnInter_tech = findViewById(R.id.btnInter_tech);
        btnInter_marketing = findViewById(R.id.btnInter_marketing);
        btnInter_design = findViewById(R.id.btnInter_design);
        btnInter_career = findViewById(R.id.btnInter_career);
        btnSex_f = findViewById(R.id.btnSex_f);
        btnSex_m = findViewById(R.id.btnSex_m);
        btnNext = findViewById(R.id.btnNext);



        btnInter_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_travel.setSelected(true);
                    yourInterest = "travel";
                }
                else {
                    yourInterest = null;
                    btnInter_travel.setSelected(false);
                }
            }
        });
        btnInter_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_sport.setSelected(true);
                    yourInterest = "sport";
                }
                else {
                    yourInterest = null;
                    btnInter_sport.setSelected(false);
                }
            }
        });
        btnInter_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_movie.setSelected(true);
                    yourInterest = "movie";
                }
                else {
                    yourInterest = null;
                    btnInter_movie.setSelected(false);
                }
            }
        });
        btnInter_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_books.setSelected(true);
                    yourInterest = "books";
                }
                else {
                    yourInterest = null;
                    btnInter_books.setSelected(false);
                }
            }
        });
        btnInter_mbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_mbti.setSelected(true);
                    yourInterest = "mbti";
                }
                else {
                    yourInterest = null;
                    btnInter_mbti.setSelected(false);
                }
            }
        });
        btnInter_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_tech.setSelected(true);
                    yourInterest = "tech";
                }
                else {
                    yourInterest = null;
                    btnInter_tech.setSelected(false);
                }
            }
        });
        btnInter_marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_marketing.setSelected(true);
                    yourInterest = "marketing";
                }
                else {
                    yourInterest = null;
                    btnInter_marketing.setSelected(false);
                }
            }
        });
        btnInter_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_design.setSelected(true);
                    yourInterest = "design";
                }
                else {
                    yourInterest = null;
                    btnInter_design.setSelected(false);
                }
            }
        });
        btnInter_career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourInterest == null) {
                    btnInter_career.setSelected(true);
                    yourInterest = "career";
                }
                else {
                    yourInterest = null;
                    btnInter_career.setSelected(false);
                }
            }
        });

        btnSex_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourSex == null) {
                    btnSex_f.setSelected(true);
                    btnSex_m.setSelected(false);
                    yourSex = "female";
                }
                else {
                    yourSex = null;
                    btnSex_f.setSelected(false);
                }
            }
        });
        btnSex_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected() && yourSex == null) {
                    btnSex_f.setSelected(false);
                    btnSex_m.setSelected(true);
                    yourSex = "male";
                }
                else {
                    yourSex = null;
                    btnSex_m.setSelected(false);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yourSex != null && yourInterest!=null) {
                    Intent intent = new Intent(getApplicationContext(), NewPage_selectCover.class);
                    startActivity(intent); //액티비티 띄우기
                } else
                    Toast.makeText(getApplicationContext(), "모든 항목을 선택하지 않으셨습니다.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}