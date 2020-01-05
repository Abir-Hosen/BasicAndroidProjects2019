package com.example.myframelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.img1Id);
        img2 = (ImageView) findViewById(R.id.img2Id);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img1Id){
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
        }
        else if(v.getId()==R.id.img2Id){
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
        }
    }
}
