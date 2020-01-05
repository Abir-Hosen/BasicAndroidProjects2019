package com.example.mysharedpreferenceexampletwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1, button2;
    LinearLayout linearLayout;
    EditText editText;
    Button button3, button4, button5;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.scoreId);
        button1 = (Button) findViewById(R.id.incId);
        button2 = (Button) findViewById(R.id.decId);
        linearLayout = (LinearLayout) findViewById(R.id.layoutId);

        editText = (EditText) findViewById(R.id.editTextId);
        button3 = (Button) findViewById(R.id.saveId);
        button4 = (Button) findViewById(R.id.clearId);
        button5 = (Button) findViewById(R.id.loadId);

        loadScore();
        loadColor();
        readFile();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.incId){
            score= score+10;

            saveScore(score);
            textView.setText("Score: "+score);

        }
        if(v.getId()==R.id.decId){
            score= score-10;

            saveScore(score);
            textView.setText("Score: "+score);
        }

        if(v.getId()==R.id.saveId){
            String text = editText.getText().toString();
            if (text!=null){
                writeToFile(text);
            }else {
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==R.id.clearId){
            editText.setText("");
        }
        if(v.getId()==R.id.loadId){
            readFile();
        }
    }

    private void saveScore(int score){

        SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", score);
        editor.commit();
    }

    private void loadScore(){

        SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        score = sharedPreferences.getInt("score", 0);
        textView.setText("Score: "+score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.redId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        }
        else if (item.getItemId()==R.id.greenId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));
        }
        else if (item.getItemId()==R.id.blueId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));
        }
        else if (item.getItemId()==R.id.yellowId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
            storeColor(getResources().getColor(R.color.yellow));
        }
        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("background", color);
        editor.commit();
    }

    private void  loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        int color = sharedPreferences.getInt("background", getResources().getColor(R.color.blue));
        linearLayout.setBackgroundColor(color);
    }

    public void writeToFile(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("diary.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error to save!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Byte Conversion failed!", Toast.LENGTH_LONG).show();
        }
    }

    public void readFile(){
        try {
            FileInputStream fileInputStream = openFileInput("diary.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line+ "\n");
            }
            editText.setText(stringBuffer.toString());
            Toast.makeText(this, "Data read successfully!", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "File not found!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "I/O error!", Toast.LENGTH_LONG).show();
        }
    }
}
