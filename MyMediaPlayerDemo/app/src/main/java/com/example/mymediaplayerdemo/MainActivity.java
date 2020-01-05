package com.example.mymediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton previousButton;
    private ImageButton rewButton;
    private ImageButton playButton;
    private ImageButton ffButton;
    private ImageButton nextButton;
    private TextView durationtxt;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousButton = (ImageButton) findViewById(R.id.previousId);
        rewButton = (ImageButton) findViewById(R.id.rewdId);
        playButton = (ImageButton) findViewById(R.id.playId);
        ffButton = (ImageButton) findViewById(R.id.ffId);
        nextButton = (ImageButton) findViewById(R.id.nextId);
        durationtxt = (TextView) findViewById(R.id.durationId);

        mediaPlayer = MediaPlayer.create(this, R.raw.toxacity);

        playButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.previousId){

        }else if(v.getId()==R.id.rewdId){

        }else if(v.getId()==R.id.playId){

            if (mediaPlayer!=null){
                int duration = mediaPlayer.getDuration()/1000;

                if (mediaPlayer.isPlaying()==true){
                    mediaPlayer.pause();
                    Toast.makeText(this, "Media Player Paused!", Toast.LENGTH_SHORT).show();
                }else {
                    mediaPlayer.start();
                    Toast.makeText(this, "Media Player Started! "+duration, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Media doesn't exist!", Toast.LENGTH_SHORT).show();
            }

        }else if(v.getId()==R.id.ffId){

        }else if(v.getId()==R.id.nextId){

        }
    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying()==true){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(this, "Media Player Stopped!", Toast.LENGTH_SHORT).show();
            }
        }
        super.onDestroy();
    }
}
