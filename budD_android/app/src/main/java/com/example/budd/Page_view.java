package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import rebuild.com.sharedpreferences.PreferenceManager;

public class Page_view extends AppCompatActivity {
    TextView txtTitle, txtDiary, txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);

        txtTime = findViewById(R.id.txtTime);
        txtTitle = findViewById(R.id.txtTitle);
        txtDiary = findViewById(R.id.txtDiary);

        //현재 날짜 가져와서 바꿔주기
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = simpleDate.format(mDate);

        txtTime.setText(getTime);

        txtTitle.setText(PreferenceManager.getString(Page_view.this, "page_title"));
        txtDiary.setText(PreferenceManager.getString(Page_view.this, "page_diary"));
    }
}