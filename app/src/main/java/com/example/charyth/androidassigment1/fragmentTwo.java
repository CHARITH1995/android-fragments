package com.example.charyth.androidassigment1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class fragmentTwo extends Fragment {

    private TextView fragmentTwo;
    View v;
    private TextView hotelList;
    public fragmentTwo() {
        // Required empty public constructor
    }
//    public void visiteNextUI(View view)
//    {
//        Intent gotoNextScreen = new Intent(getActivity(),hotels.class);
//        startActivity(gotoNextScreen);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        fragmentTwo = (TextView) v.findViewById(R.id.fragment2);
        Button button = (Button) v.findViewById(R.id.btn2);

        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View newView){
                onButtonClicked(v);
            }
        });
        fragmentTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){

                    Intent gotoNextScreen = new Intent(getActivity(),hotels.class);
                    //gotoNextScreen.putExtra("json_data",myReponse);
                    startActivity(gotoNextScreen);
            }
        });

        return v;
    }

    public void onButtonClicked(View view)
    {
        //do your stuff here..
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, new fragmentOne(), "one");
        ft.commit();

        ft.addToBackStack(null);
    }

}