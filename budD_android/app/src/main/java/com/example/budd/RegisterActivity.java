package com.example.budd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    ImageButton female, male, next, idcheck;
    ImageView confirm;
    EditText userid, userpw, repw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

/*        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/


        userid = (EditText) findViewById(R.id.userid);
        userpw = (EditText) findViewById(R.id.userpw);
        repw = (EditText) findViewById(R.id.repw);
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

                if(!userid.equals("test111"))
                    confirm.setVisibility(View.VISIBLE);
                else {
                    confirm.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(confirm.getVisibility() == View.INVISIBLE) {
                    Toast.makeText(getApplicationContext(), "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(!userpw.equals(repw)) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 확인해주십시오.", Toast.LENGTH_SHORT).show();
                }

                if(confirm.getVisibility() == View.VISIBLE && userpw.equals(repw)){
                    Intent intent = new Intent(getApplicationContext(), Register2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
