package com.example.fromfragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Fragment1.IsendDataFragment2,Fragment2.IsendDataFragment2{

    private FrameLayout mFrameLayout1, mFrameLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        mFrameLayout1 = findViewById(R.id.framelayout1);
        mFrameLayout2 = findViewById(R.id.framelayout2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        fragmentTransaction.add(R.id.framelayout1,fragment1 );
        fragmentTransaction.add(R.id.framelayout2, fragment2);
        fragmentTransaction.commit();

    }

    @Override
    public void Send(String strEmail) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.framelayout2);
        fragment2.receiveFragment1(strEmail);
    }


    @Override
    public void Update(String email) {
        Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.framelayout1);
        fragment1.receiveFragment2(email);
    }
}