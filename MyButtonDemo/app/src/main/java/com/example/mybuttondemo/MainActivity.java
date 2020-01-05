package com.example.mybuttondemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView clicked, clickText;
    private Button login;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicked = (TextView) findViewById(R.id.clickedId);
        login = (Button) findViewById(R.id.login);
        logout = (Button) findViewById(R.id.logout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked.setText("Login Clicked");
                Toast.makeText(MainActivity.this, "Button Clicked by Toast", Toast.LENGTH_SHORT).show();
            }
        });

        Handler handler = new Handler();

        logout.setOnClickListener(handler);
    }

    public void showMessage(View v){
        clickText = (TextView) findViewById(R.id.clickText);
        clickText.setText("Button clicked using XML OnClick");
        Toast toast = Toast.makeText(MainActivity.this, "Button Clicked by Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();

    }

    class Handler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.logout){
                clicked.setText("Logout Clicked");
                Toast.makeText(MainActivity.this, "Button Clicked by Toast", Toast.LENGTH_SHORT).show();
                Log.d("tag", "Logout clicked in debug!");
            }
        }
    }
    }

