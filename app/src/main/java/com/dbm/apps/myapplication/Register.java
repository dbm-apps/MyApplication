package com.dbm.apps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private EditText textViewUsername;
    private EditText textViewPassword;
    private Button button,buttona;
    private int count=0;

    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000);

        textViewUsername = (EditText) findViewById(R.id.textview_username);
        textViewPassword = (EditText) findViewById(R.id.textview_password);
        button = (Button) findViewById(R.id.button);
        buttona = (Button) findViewById(R.id.buttona);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textViewUsername.getText().toString().equals(""))
                {
                    if (!textViewPassword.getText().toString().equals(""))
                    {
                        if (count==1)
                        {
                            Intent intent=new Intent(Register.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(Register.this, "יש להירשם!", Toast.LENGTH_SHORT).show();

                        }

                    }
                    else {
                        Toast.makeText(Register.this, "אין להשאיר שדות ריקים", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(Register.this, "אין להשאיר שדות ריקים", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String username, String password) {
        textViewUsername.setText(username);
        textViewPassword.setText(password);
        count=1;
    }
}