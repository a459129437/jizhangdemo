package com.example.jizhangdemo.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jizhangdemo.R;

public class AddInFragment extends Fragment {

    private EditText add_in_et_money,add_in_et_remark;
    private Button add_in_btn_picker_classification,add_in_btn_picker_account,add_in_btn_picker_time,add_in_btn_picker_member;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_in,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        add_in_et_money = view.findViewById(R.id.add_in_et_money);
        add_in_btn_picker_classification = view.findViewById(R.id.add_in_btn_picker_classification);
        add_in_btn_picker_account = view.findViewById(R.id.add_in_btn_picker_account);
        add_in_btn_picker_time = view.findViewById(R.id.add_in_btn_picker_time);
        add_in_et_remark = view.findViewById(R.id.add_in_et_remark);
        add_in_btn_picker_member = view.findViewById(R.id.add_in_btn_picker_member);
    }

}
