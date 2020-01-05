package com.example.mytimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView msg;
    TimePicker picker;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (TimePicker) findViewById(R.id.pkrId);
        picker.setIs24HourView(true);
        msg = (TextView) findViewById(R.id.msg);
        btn = (Button) findViewById(R.id.btnId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = picker.getCurrentHour()+":"+picker.getCurrentMinute();
                msg.setText(time);
            }
        });
    }
}
