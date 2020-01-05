package com.example.myprogressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.pBarId);
        textView = (TextView) findViewById(R.id.txtId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();
    }

    private void doWork(){
        for (progress=10; progress<=100; progress=progress+10) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
                textView.setText("Progress Report: "+ progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
