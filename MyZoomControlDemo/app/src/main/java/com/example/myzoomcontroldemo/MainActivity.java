package com.example.myzoomcontroldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imgId);
        zoomControls = (ZoomControls) findViewById(R.id.zmId);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();
                imageView.setScaleX((float)x+1);
                imageView.setScaleY((float) y+1);

                Toast.makeText(MainActivity.this, "Zoom In", Toast.LENGTH_SHORT).show();
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                if(x>.5 && y>.5) {
                    imageView.setScaleX((float) (x - 0.5));
                    imageView.setScaleY((float) (y - .5));
                }

                Toast.makeText(getApplicationContext(), "Zoom Out", Toast.LENGTH_SHORT).show();
            }
        });
    }
}