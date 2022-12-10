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

public class Fragment2 extends Fragment {



    private View mView;

    private EditText edtEmail;
    private Button btnFragment2;
    private static IsendDataFragment2 isendDataFragment2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView =  inflater.inflate(R.layout.fragment_2, container, false);

        init();
        return mView;
    }

    public interface IsendDataFragment2{
        void Update(String email);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        isendDataFragment2 = (IsendDataFragment2) getActivity();
    }

    private void init() {

        edtEmail = mView.findViewById(R.id.edt_email);
        btnFragment2 = mView.findViewById(R.id.btn_fragmentP2);
//        activity1 = (Activity1) getActivity();

//        edtEmail.setText(activity1.getmStrEmail());

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateFragment();
            }
        });
    }

    private void UpdateFragment() {
        String strEmail = edtEmail.getText().toString().trim();
        isendDataFragment2.Update(strEmail);
    }

    public void receiveFragment1(String strEmail){
        edtEmail.setText(strEmail);
    }

}