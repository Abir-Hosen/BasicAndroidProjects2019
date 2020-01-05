package com.example.mycustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView1;
    private String[] countryNames;
    private int[] flags = {
            R.drawable.united_kingdom,
            R.drawable.united_states,
            R.drawable.mexico,
            R.drawable.germany,
            R.drawable.bangladesh,
            R.drawable.brazil,
            R.drawable.italy,
            R.drawable.portugal,
            R.drawable.australia,
            R.drawable.france,
            R.drawable.pakistan,
            R.drawable.spain
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);

        listView1 = (ListView) findViewById(R.id.mainActListView1Id);
        searchView = (SearchView) findViewById(R.id.searchId);


        final CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        listView1.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
