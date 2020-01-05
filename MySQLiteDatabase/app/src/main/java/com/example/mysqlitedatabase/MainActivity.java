package com.example.mysqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2, editText3, editText4;
    private Button button1, button2, button3, button4, button5, button6;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.nameId);
        editText2 = (EditText) findViewById(R.id.ageId);
        editText3 = (EditText) findViewById(R.id.genderId);
        editText4 = (EditText) findViewById(R.id.idId);

        button1 = (Button) findViewById(R.id.saveId);
        button2 = (Button) findViewById(R.id.clearId);
        button3 = (Button) findViewById(R.id.readId);
        button4 = (Button) findViewById(R.id.updateId);
        button5 = (Button) findViewById(R.id.deleteId);
        button6 = (Button) findViewById(R.id.dataListId);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    private void showData(String title, String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();
    }

    @Override
    public void onClick(View v) {
        String studentId = editText4.getText().toString();
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();
        String gender = editText3.getText().toString();

        if (v.getId()==R.id.saveId){

            long id = databaseHelper.insert(name, age, gender);

            if (id==-1){
                Toast.makeText(this, "Data "+id+" Insertion failed!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Data "+id+" Inserted Successfully!", Toast.LENGTH_LONG).show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        }
        if (v.getId()==R.id.clearId){
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
        }

        if (v.getId()==R.id.readId){

            Cursor cursor = databaseHelper.displayAllData();
            if(cursor.getCount() == 0){
                showData("Error", "No Data found.");
                return;
            }else{
                StringBuffer stringBuffer = new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("ID: "+cursor.getString(0)+"\n");
                    stringBuffer.append("Name: "+cursor.getString(1)+"\n");
                    stringBuffer.append("Age: "+cursor.getString(2)+"\n");
                    stringBuffer.append("Gender: "+cursor.getString(3)+"\n\n");
                }
                showData("Result Set", stringBuffer.toString());
            }

        }

        if (v.getId()==R.id.updateId){
            Boolean isUpdated = databaseHelper.updateData(studentId, name, age, gender);
            if(isUpdated=true){
                Toast.makeText(this, "Updated Successfully!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Update Failed!", Toast.LENGTH_LONG).show();
            }
        }

        if (v.getId()==R.id.deleteId){
            int value = databaseHelper.deleteDate(studentId);
            if (value>0){
                Toast.makeText(this, "Deleted Successfully!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Delete failed!", Toast.LENGTH_LONG).show();
            }
        }

        if (v.getId()==R.id.dataListId){
            Intent intent = new Intent(MainActivity.this, DataList.class);
            startActivity(intent);
        }
    }
}
