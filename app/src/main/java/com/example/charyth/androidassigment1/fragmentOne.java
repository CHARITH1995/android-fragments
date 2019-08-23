package com.example.charyth.androidassigment1;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragmentOne extends Fragment {

    View v;
    private TextView fragmentOne , fragmentTwo;
    public fragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void visiteNextUI(View view)
//    {
//        Intent gotoNextScreen = new Intent(getActivity(),dashboard.class);
//        startActivity(gotoNextScreen);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        Button button = (Button) v.findViewById(R.id.btn1);
        fragmentOne = (TextView) v.findViewById(R.id.fragment1);
        fragmentOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent gotoNextScreen = new Intent(getActivity(),dashboard.class);
                startActivity(gotoNextScreen);
            }
        });
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View newView){
                onButtonClicked(v);
            }
        });

        return v;
    }

    public void onButtonClicked(View view)
    {
        //do your stuff here..
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, new fragmentTwo(), "tow");
        ft.commit();

        ft.addToBackStack(null);
    }

}