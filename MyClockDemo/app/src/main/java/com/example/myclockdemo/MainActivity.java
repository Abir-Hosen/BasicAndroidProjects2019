package com.example.myclockdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Analyzer;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextClock textClock;
    private AnalogClock analogClock;
    private DigitalClock digitalClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock = (AnalogClock) findViewById(R.id.algId);
        digitalClock = (DigitalClock) findViewById(R.id.dgtlId);
        textClock = (TextClock) findViewById(R.id.txtId);

        analogClock.setOnClickListener(this);
        digitalClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.algId){
            Toast.makeText(MainActivity.this, "Analog Clock", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.dgtlId){
            Toast.makeText(MainActivity.this, "Digital Clock", Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.txtId){
            Toast.makeText(MainActivity.this, "Text Clock", Toast.LENGTH_LONG).show();
        }
    }
}
