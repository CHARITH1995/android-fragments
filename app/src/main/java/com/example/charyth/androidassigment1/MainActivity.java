package com.example.charyth.androidassigment1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password ;
    private TextView hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

    }

    public void visiteNextUI(View view)
    {
        Intent gotoNextScreen = new Intent(getApplicationContext(),dashboard.class);
        gotoNextScreen.putExtra("userName", userName.getText().toString());
        gotoNextScreen.putExtra("password", password.getText().toString());
        startActivity(gotoNextScreen);
    }

}
