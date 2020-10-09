package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        Button mBtnBack3 = findViewById(R.id.btn_back3);
        Button mBtnFindPasswordNext = findViewById(R.id.btn_find_password_next);
        mBtnBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this,PasswordLoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnFindPasswordNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this,ForgetPasswordActivity2.class);
                startActivity(intent);
            }
        });
    }

}