package com.example.myradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton gender;
    RadioGroup group;
    Button show;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.radio_groupId);
        show = (Button) findViewById(R.id.show_btn);
        msg = (TextView) findViewById(R.id.msg);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                gender = (RadioButton) findViewById(id);
                String value = gender.getText().toString();
                msg.setText("You have selected "+value);
            }
        });


    }
}
