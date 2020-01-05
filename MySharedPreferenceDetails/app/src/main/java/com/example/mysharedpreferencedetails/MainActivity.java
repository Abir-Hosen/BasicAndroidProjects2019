package com.example.mysharedpreferencedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button button1, button2, button3;
    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.userNameId);
        editText2 = (EditText) findViewById(R.id.userPassId);

        textView1 = (TextView) findViewById(R.id.userId);
        textView2 = (TextView) findViewById(R.id.passwordId);

        button1 = (Button) findViewById(R.id.saveButtonId);
        button2 = (Button) findViewById(R.id.clearButtonId);
        button3 = (Button) findViewById(R.id.loadButtonId);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveButtonId){
            String userName = editText1.getText().toString();
            String passName = editText2.getText().toString();

            if(userName.equals("") || passName.equals("")){
                Toast.makeText(getApplicationContext(), "Please Complete the field!", Toast.LENGTH_SHORT).show();
            }else {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", userName);
                editor.putString("password", passName);
                editor.commit();

                editText1.setText("");
                editText2.setText("");

                Toast.makeText(getApplicationContext(), "Data is stored successfully!", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId()==R.id.clearButtonId){
            editText1.setText("");
            editText2.setText("");
        }
        else if(v.getId()==R.id.loadButtonId){
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("username") && sharedPreferences.contains("password")) {
                String userName = sharedPreferences.getString("username", "Null");
                String passName = sharedPreferences.getString("password", "Null");
                textView1.setText("User Name: " +userName);
                textView2.setText("Password: " +passName);
            }
        }
    }
}
