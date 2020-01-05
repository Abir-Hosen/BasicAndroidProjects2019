package com.example.myvideoviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.vdoId);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback);

        MediaController mediaController = new MediaController(this);

        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
