package com.dbm.apps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final Intent i=new Intent(Splash.this,MainActivity.class);
        Thread thread= new Thread(){

            public void  run (){

                try {
                    sleep(3100);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();


                }


            }

        };
        thread.start();

    }
}
