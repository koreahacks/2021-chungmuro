package com.example.budd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    ImageButton female, male, next, idcheck;
    ImageView confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

/*        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/


        female = (ImageButton) findViewById(R.id.FemaleBtn);
        male = (ImageButton) findViewById(R.id.MaleBtn);
        idcheck = (ImageButton) findViewById(R.id.idcheckBtn);
        next = (ImageButton) findViewById(R.id.nextBtn);

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                female.setSelected(true);
                male.setSelected(false);
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                female.setSelected(false);
                male.setSelected(true);
            }
        });

        idcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if()
                    confirm.setVisibility(View.VISIBLE);
                else
                    confirm.setVisibility(View.INVISIBLE);*/
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                startActivity(intent);
            }
        });
    }
}
