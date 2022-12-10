package com.example.fromfragmenttofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class Fragment1 extends Fragment {


    private View mView;

    private EditText edtEmail;
    private Button btnFragment1;
    private static IsendDataFragment2 isendDataFragment2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView =  inflater.inflate(R.layout.fragment_1, container, false);
        init();
        return mView;
    }
    public  interface IsendDataFragment2 {
        void Send(String strEmail);
    }

    @Override
    public void onAttach(@NonNull Context context) { // khai báo interface
        super.onAttach(context);
        isendDataFragment2 = (IsendDataFragment2) getActivity();
    }

    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        btnFragment1 = mView.findViewById(R.id.btn_fragmentP1);
//        activity1 = (Activity1) getActivity();

//        edtEmail.setText(activity1.getmStrEmail());

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendFragment();
            }
        });
    }

    private void SendFragment() {
        String strEmail  = edtEmail.getText().toString().trim();
        isendDataFragment2.Send(strEmail);
    }

    public void receiveFragment2(String email){
        edtEmail.setText(email);
    }
}