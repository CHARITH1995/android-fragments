package com.example.charyth.androidassigment1;

/**
 * Created by charyth on 8/19/2019.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {

    private TextView fragmentOne , fragmentTwo , fragmentThree ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dashboard);

            fragmentOne =  findViewById(R.id.fragment1);
            fragmentTwo = findViewById(R.id.fragment2);
            addFragment(new fragmentOne(),true,"one");
        }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frame_container, fragment, tag);
        ft.commitAllowingStateLoss();
    }
    }

