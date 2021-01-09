package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


    }
}