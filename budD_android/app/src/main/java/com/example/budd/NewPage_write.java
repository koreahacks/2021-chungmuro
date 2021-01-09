package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import rebuild.com.sharedpreferences.PreferenceManager;

public class NewPage_write extends AppCompatActivity {
    EditText editTitle, editDiary;
    TextView txtTime, txtTyping;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage_write);

        editTitle = findViewById(R.id.editTitle);
        editDiary = findViewById(R.id.editDiary);
        txtTime = findViewById(R.id.txtTime);
        txtTyping = findViewById(R.id.txtTyping);
        btnSubmit = findViewById(R.id.btnSubmit);


        //현재 날짜 가져와서 바꿔주기
        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = simpleDate.format(mDate);

        txtTime.setText(getTime);




        //저장, 인텐트
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTitle.getText().toString().isEmpty() && !editDiary.getText().toString().isEmpty()) { //모두 한 자라도 작성 되었다면
                    //SharedPreference 저장 ㅎ
                    PreferenceManager.setString(NewPage_write.this, "page_title", editTitle.getText().toString());
                    PreferenceManager.setString(NewPage_write.this, "page_diary", editDiary.getText().toString());

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class); //다 커밋 되면 조회 페이지로 바꾸기
                    startActivity(intent); //액티비티 띄우기
                } else
                    Toast.makeText(getApplicationContext(), "모든 항목을 작성하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}