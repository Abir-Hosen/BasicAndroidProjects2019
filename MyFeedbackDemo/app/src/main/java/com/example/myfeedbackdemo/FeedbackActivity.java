package com.example.myfeedbackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emai, feedback, msg;
    private Button send, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        emai = (EditText) findViewById(R.id.emailTextId);
        feedback = (EditText) findViewById(R.id.feedTextId);
        msg = (EditText) findViewById(R.id.msgTextId);

        send = (Button) findViewById(R.id.btnId);
        clear = (Button) findViewById(R.id.cBtnId);

        send.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String email = emai.getText().toString();
            String feedbacks = feedback.getText().toString();
            String mesg = msg.getText().toString();

            if (v.getId()==R.id.btnId){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abir040995.hosen@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: "+email+"\nFeedback: "+feedbacks+"\nMeessage: "+mesg);
                startActivity(Intent.createChooser(intent, "Feedback with"));
            }
            else if(v.getId()==R.id.cBtnId){
                emai.setText("");
                msg.setText("");
                feedback.setText("");
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Exception occured", Toast.LENGTH_SHORT).show();
        }
    }
}
