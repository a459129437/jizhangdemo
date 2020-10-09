package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.R;

public class LoginMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        Button mBtnGraphLogin = findViewById(R.id.btn_graph_login);
        Button mBtnPasswordLogin = findViewById(R.id.btn_password_login);
        Button mBtnRegister = findViewById(R.id.btn_choose_register);
        mBtnGraphLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMainActivity.this,GraphLoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMainActivity.this,PasswordLoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}