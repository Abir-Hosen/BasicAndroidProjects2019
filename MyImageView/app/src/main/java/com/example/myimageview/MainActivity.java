package com.example.myimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.img1);
        imageView2 = (ImageView) findViewById(R.id.img2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.img1){
            Toast.makeText(MainActivity.this,"Mumu with the most beautiful girl.", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.img2){
            Toast.makeText(MainActivity.this,"Mumu with the beauty of nature.", Toast.LENGTH_SHORT).show();
        }

    }
}
