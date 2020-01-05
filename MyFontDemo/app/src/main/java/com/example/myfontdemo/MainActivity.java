package com.example.myfontdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    private Typeface typeface1, typeface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.txt1);
        textView2 = (TextView) findViewById(R.id.txt2);

        typeface1 = Typeface.createFromAsset(getAssets(), "font/Amadeus.ttf");
        textView2.setTypeface(typeface1);

    }
}
