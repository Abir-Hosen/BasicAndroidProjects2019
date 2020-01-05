package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2, editText3, editText4, editText5;
    private Button button1, button2;
    private TextView textView1;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        editText1 = (EditText) findViewById(R.id.nameId);
        editText2 = (EditText) findViewById(R.id.emailId);
        editText3 = (EditText) findViewById(R.id.userId);
        editText4 = (EditText) findViewById(R.id.passwordId);
        editText5 = (EditText) findViewById(R.id.confirmPasswordId);

        button1 = (Button) findViewById(R.id.signUpId);
        button2 = (Button) findViewById(R.id.signInId);

        textView1 = (TextView) findViewById(R.id.msgId);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String user = editText3.getText().toString();
        String password = editText4.getText().toString();
        String confirmPass = editText5.getText().toString();

        if (v.getId()==R.id.signUpId){
            if (name.equals("") || email.equals("") || user.equals("") || password.equals("") || confirmPass.equals("")){
                textView1.setText("Fill up the fields.");
            }
            else if(email.endsWith("@gmail.com")==false){
                textView1.setText("Invalid Email!");
            }
            else if(password.equals(confirmPass)==false){
                textView1.setText("Password is not matched!");
            }
            else {

                boolean result = databaseHelper.findEmail(email, user);
                if (result==false){

                    long rowId = databaseHelper.insert(name, email, user, password);
                    if (rowId==-1){
                        Toast.makeText(this, "Sign Up failed!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, SignIn.class);
                        startActivity(intent);
                    }

                    textView1.setText("field condition filled.");
                }else{
                    textView1.setText("Duplicate email or user entry");
                }
            }

        }
        else if (v.getId()==R.id.signInId){

            Intent intent = new Intent( MainActivity.this, SignIn.class);
            startActivity(intent);
        }
    }
}
