package com.example.jizhangdemo.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.BottomBarActivity;
import com.example.jizhangdemo.R;

public class RegisterActivity extends AppCompatActivity {

    private PopupWindow mPopPasswordQuestion;
    String[] date = new String[]{"你的父亲的名字","你的母亲的名字","你的生日"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button mBtnBack2 = findViewById(R.id.btn_back2);
        Spinner spinnerPasswordQuestion = findViewById(R.id.spinner_password_question);
        Button mBtnRegister = findViewById(R.id.btn_register);
        mBtnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginMainActivity.class);
                startActivity(intent);
            }
        });
        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,date);
        spinnerPasswordQuestion.setAdapter(adapter);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, BottomBarActivity.class);
                startActivity(intent);
            }
        });
    }
}