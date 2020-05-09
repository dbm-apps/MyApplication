package com.dbm.apps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        Boolean isFirstRun = getSharedPreferences("PREFERNCE", MODE_PRIVATE).getBoolean("isfirstrun", true);

        if (isFirstRun) {
            getSharedPreferences("PREFERNCE", MODE_PRIVATE).edit().putBoolean("isfirstrun", false).commit();

            Intent i = new Intent(Loading.this, Register.class);
            startActivity(i);


        } else {
            Intent intent = new Intent(Loading.this, Splash.class);
            startActivity(intent);
        }
    }
}