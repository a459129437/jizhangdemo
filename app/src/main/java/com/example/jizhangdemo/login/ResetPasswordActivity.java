package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.R;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Button mBtnBack5 = findViewById(R.id.btn_back5);
        Button mBtnResetPasswordFinish = findViewById(R.id.btn_reset_password_finish);
        mBtnBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity.this,ForgetPasswordActivity2.class);
                startActivity(intent);
            }
        });
        mBtnResetPasswordFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity.this,LoginMainActivity.class);
                startActivity(intent);
            }
        });
    }
}