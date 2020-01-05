package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button button1, button2;
    private TextView textView1;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        editText1 = (EditText) findViewById(R.id.emailId);
        editText2 = (EditText) findViewById(R.id.passwordId);

        button1 = (Button) findViewById(R.id.signInId);
        button2 = (Button) findViewById(R.id.signUpId);

        textView1 = (TextView) findViewById(R.id.msgId);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = editText1.getText().toString();
        String password = editText2.getText().toString();

        if (v.getId()==R.id.signInId){
            if (user.equals("") || password.equals("")){
                textView1.setText("Fill up the fields.");
            }
            else {
                boolean result = databaseHelper.findPassword(user, password);
                if (result==true){
                    Intent intent = new Intent(SignIn.this, Home.class);
                    startActivity(intent);
                }
                else {
                    textView1.setText("Wrong user or password.");
                }
            }

        }

        else if (v.getId()==R.id.signUpId){
            Intent intent = new Intent(SignIn.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
