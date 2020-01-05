package com.example.mylogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button button;
    private TextView textView;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.userNameId);
        editText2 = (EditText) findViewById(R.id.userPassId);
        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText1.getText().toString();
                String pass = editText2.getText().toString();

                if(user.equals("admin") && pass.equals("1234") && counter>0){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else{
                    counter--;
                    textView.setText("Number of attempt remaining "+counter);
                    if (counter==0){
                        button.setEnabled(false);
                    }
                }
            }
        });
    }
}
