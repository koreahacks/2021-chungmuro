package com.example.budd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText editUserid, editUserpw;
    Button login;
    TextView register;

    static public String userID = "test111";
    static public String userPWD = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView register = (TextView) findViewById(R.id.register);

        login = findViewById(R.id.loginBtn);
        editUserid = findViewById(R.id.editUserid);
        editUserpw = findViewById(R.id.editUserpw);
        register = (TextView) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUserid.getText().toString().equals(userID) && editUserpw.getText().toString().equals(userPWD)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); //액티비티 띄우기
                } else
                    Toast.makeText(getApplicationContext(), "아이디나 패스워드가 틀립니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}