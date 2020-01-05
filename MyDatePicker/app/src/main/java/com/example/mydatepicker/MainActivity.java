package com.example.mydatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private DatePicker datePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.vwId);
        button = (Button) findViewById(R.id.btnId);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        txtView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                txtView.setText(currentDate());
            }
        });

    }

    String currentDate(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current Date: ");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
        stringBuilder.append( (1+datePicker.getMonth()) +"/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}
