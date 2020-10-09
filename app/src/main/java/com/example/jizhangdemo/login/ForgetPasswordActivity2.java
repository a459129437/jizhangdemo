package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.R;

public class ForgetPasswordActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password2);
        Button mBtnBack4 = findViewById(R.id.btn_back4);
        Button mBtnFindPasswordConfirm = findViewById(R.id.btn_find_password_confirm);
        mBtnBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity2.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        mBtnFindPasswordConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity2.this,ResetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}