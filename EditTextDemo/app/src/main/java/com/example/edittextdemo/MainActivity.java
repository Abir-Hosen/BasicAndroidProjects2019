package com.example.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1, editText2;
    private Button addButon, subButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        addButon = (Button) findViewById(R.id.add);
        subButton = (Button) findViewById(R.id.sub);
        resultTextView = (TextView) findViewById(R.id.result);

        addButon.setOnClickListener(this);
        subButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            String n1 = editText1.getText().toString();
            String n2 = editText2.getText().toString();

            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);

            if(v.getId()==R.id.add){
                double sum = num1+num2;
                resultTextView.setText("Result "+sum);
            }else if(v.getId()==R.id.sub){
                double sub = num1-num2;
                resultTextView.setText("Result "+sub);
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Please Enter numbers", Toast.LENGTH_SHORT).show();
        }


    }
}
