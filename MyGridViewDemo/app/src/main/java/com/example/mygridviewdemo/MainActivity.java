package com.example.mygridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private String[] countryNames;
    private int[] flags = {
            R.drawable.united_kingdom,
            R.drawable.united_states,
            R.drawable.mexico,
            R.drawable.germany,
            R.drawable.bangladesh,
            R.drawable.brazil,
            R.drawable.italy,
            R.drawable.portugal,
            R.drawable.australia,
            R.drawable.france,
            R.drawable.pakistan,
            R.drawable.spain
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid1Id);
        countryNames = getResources().getStringArray(R.array.country_names);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        gridView.setAdapter(adapter);
    }
}
