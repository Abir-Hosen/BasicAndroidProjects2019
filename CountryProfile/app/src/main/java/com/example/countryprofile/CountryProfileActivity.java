package com.example.countryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class CountryProfileActivity extends AppCompatActivity {

    ImageView imageView;
    TextView c_name, details;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_profile);

        imageView = (ImageView) findViewById(R.id.imgId);
        c_name = (TextView) findViewById(R.id.nameId);
        details = (TextView) findViewById(R.id.detailsId);
        scrollView = (ScrollView) findViewById(R.id.scrollId);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null){
            String name = bundle.getString("name");
            if(name.matches("Bangladesh")){
                details.setText(R.string.details1);
                c_name.setText(name);
                imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/bangladeshimg", null, getPackageName())));
            }
            else if(name.matches("India")){
                c_name.setText(name);
                details.setText(R.string.details2);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.indiaimg));
            }
            else if(name.matches("Pakistan")){
                c_name.setText(name);
                details.setText(R.string.details3);
                imageView.setImageResource(R.drawable.pakistanimg);
            }
        }

    }
}
