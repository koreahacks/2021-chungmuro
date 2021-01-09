package com.example.budd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ReadActivity extends AppCompatActivity {

    Button readdiary;
    ImageButton writenew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_diary);


        readdiary = findViewById(R.id.readdiary);
        writenew = findViewById(R.id.writenew);

        readdiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Page_view.class);
                startActivity(intent);
            }
        });

        writenew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NewPage_write.class);
                startActivity(intent);
            }
        });
    }
}
