package com.example.myspinnercustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private TextView textView;
    private String[] countries;
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
    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerId);
        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);

        countries = getResources().getStringArray(R.array.country_names);
        CustomAdapter adapter = new CustomAdapter(this, countries, flags);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isFirstSelection==true){
                    isFirstSelection=false;
                }else {
                    String value = countries[position];
                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
