package com.example.mytimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView msg;
    Button btn;
    TimePickerDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (TextView) findViewById(R.id.msg);
        btn = (Button) findViewById(R.id.btnId);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int currentHour = new TimePicker(this).getCurrentHour();
        int currentMinute = new TimePicker(this).getCurrentMinute();

        dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                msg.setText(hourOfDay+":"+minute);
            }
        }, currentHour, currentMinute, true);

        dialog.show();
    }
}
