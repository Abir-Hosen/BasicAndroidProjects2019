package com.example.myintentdemodatatransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = (TextView) findViewById(R.id.text1Id);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null){
            String name = bundle.getString("name");
            textView.setText(name);
        }
    }
}
