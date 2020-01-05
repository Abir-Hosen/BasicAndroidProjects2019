package com.example.textviewdemo;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView detailsTextView;
    private Button detailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.nameId);
        detailsTextView = (TextView) findViewById(R.id.detailsId);
        detailsButton = (Button) findViewById(R.id.button1Id);

        detailsTextView.setTextIsSelectable(true);

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTextView.setText("Abir Hosen Ashik");
                detailsButton.setText("Hide Details");
                detailsTextView.setText(R.string.details);
            }
        });
    }
}
