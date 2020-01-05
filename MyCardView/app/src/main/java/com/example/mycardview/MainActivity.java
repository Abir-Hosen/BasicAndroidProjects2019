package com.example.mycardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cardView1, cardView2, cardView3, cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = (CardView) findViewById(R.id.card1Id);
        cardView2 = (CardView) findViewById(R.id.card2Id);
        cardView3 = (CardView) findViewById(R.id.card3Id);
        cardView4 = (CardView) findViewById(R.id.card4Id);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.card1Id){
            Toast.makeText(this, "Card 1 Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.card2Id){
            Toast.makeText(this, "Card 2 Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.card3Id){
            Toast.makeText(this, "Card 3 Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.card4Id){
            Toast.makeText(this, "Card 4 Clicked", Toast.LENGTH_SHORT).show();
        }

    }
}
