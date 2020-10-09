package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.BottomBarActivity;
import com.example.jizhangdemo.R;

public class PasswordLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_login);
        Button mBtnBack = findViewById(R.id.btn_back);
        Button mBtnLogin = findViewById(R.id.btn_login);
        Button mBtnOtherLogin = findViewById(R.id.btn_other_login);
        Button mBtnForgetPassword = findViewById(R.id.btn_forget_password);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordLoginActivity.this,LoginMainActivity.class);
                startActivity(intent);
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordLoginActivity.this, BottomBarActivity.class);
                startActivity(intent);
            }
        });
        mBtnOtherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordLoginActivity.this,LoginMainActivity.class);
                startActivity(intent);
            }
        });
        mBtnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordLoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}