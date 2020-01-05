package com.example.mydatepickerdialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView msg;
    Button btn;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (TextView) findViewById(R.id.textId);
        btn = (Button) findViewById(R.id.btnId);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        DatePicker datePicker = new DatePicker(this);
        int currentDay = datePicker.getDayOfMonth();
        int currentMonth = datePicker.getMonth();
        int currentYear = datePicker.getYear();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                msg.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, currentYear, currentMonth, currentDay);

        datePickerDialog.show();
    }
}
