package com.example.mycheckboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbx1, cbx2, cbx3;
    TextView msg;
    Button showbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbx1 = (CheckBox) findViewById(R.id.ckbx1);
        cbx2 = (CheckBox) findViewById(R.id.ckbx2);
        cbx3 = (CheckBox) findViewById(R.id.ckbx3);

        msg = (TextView) findViewById(R.id.msg);
        showbtn = (Button) findViewById(R.id.show);

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();
                if(cbx1.isChecked()){
                    String value = cbx1.getText().toString();
                    stringBuilder.append(value +" is ordered!\n");
                }
                if(cbx2.isChecked()){
                    String value = cbx2.getText().toString();
                    stringBuilder.append(value +" is ordered!\n");
                }
                if(cbx3.isChecked()){
                    String value = cbx3.getText().toString();
                    stringBuilder.append(value +" is ordered!\n");
                }

                msg.setText(stringBuilder);
            }
        });

    }
}
