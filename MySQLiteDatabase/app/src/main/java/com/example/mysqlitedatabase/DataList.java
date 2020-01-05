package com.example.mysqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataList extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        listView = (ListView) findViewById(R.id.listId);

        loadData();
    }

    public void loadData(){
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = databaseHelper.showAllData();

        if (cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No data is available in database", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listData.add(cursor.getString(0)+".\t\t"+cursor.getString(1)+"\t-\t"+cursor.getString(2)+"\t-\t"+cursor.getString(3));
            }
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textViewId, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
