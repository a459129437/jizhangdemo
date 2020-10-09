package com.example.jizhangdemo.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jizhangdemo.BottomBarActivity;
import com.example.jizhangdemo.R;
import com.xuexiang.xui.widget.dialog.materialdialog.DialogAction;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;

public class GraphLoginActivity extends AppCompatActivity implements NineSquare.OnPatternChangeListener{

    private NineSquare lqv;
    int patt = 123456789;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_login);
        lqv = findViewById(R.id.lock_pattern_view);
        lqv.setOnPatternChangeListener(this);
    }

    @Override

    public void onPatternChange(String patternPassword) {
        if(patternPassword==null){
            new MaterialDialog.Builder(GraphLoginActivity.this)
                    .iconRes(R.drawable.icon_tip)
                    .title("提示")
                    .content("登录失败，请画至少5个点")
                    .positiveText("确定")
                    .show();
        }else{
            new MaterialDialog.Builder(GraphLoginActivity.this)
                    .iconRes(R.drawable.icon_tip)
                    .title("提示")
                    .content("登录成功")
                    .positiveText("确定")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            Intent intent = new Intent(GraphLoginActivity.this,BottomBarActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();
        }
    }

    @Override
    public void onPatternStarted(boolean isStarted) {
        if(isStarted){
        }
    }
}