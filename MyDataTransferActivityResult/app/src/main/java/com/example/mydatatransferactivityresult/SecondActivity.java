package com.example.mydatatransferactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText act2etxt1;
    Button act2btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        act2etxt1 = (EditText) findViewById(R.id.act2etxt1);
        act2btn1 = (Button) findViewById(R.id.act2btn1);

        act2btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = act2etxt1.getText().toString();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                intent.putExtra("key", value);
                setResult(1, intent);
                finish();
            }
        });
    }
}
