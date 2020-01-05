package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = (Button) findViewById(R.id.signInId);
        button2 = (Button) findViewById(R.id.signUpId);
        button3 = (Button) findViewById(R.id.signOutId);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.signInId){
            Intent intent = new Intent(Home.this, SignIn.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.signUpId){
            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.signOutId){
            Intent intent = new Intent(Home.this, SignIn.class);
            startActivity(intent);
        }

    }
}
