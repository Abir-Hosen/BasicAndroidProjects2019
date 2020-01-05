package com.example.myexpendablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listCountry;
    HashMap<String, List<String>> listDataChild;
    private int lastExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();
        expandableListView = (ExpandableListView) findViewById(R.id.expId);
        customAdapter = new CustomAdapter(this, listCountry, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String groupName = listCountry.get(groupPosition);

                Toast.makeText(getApplicationContext(),"Group name: "+groupName, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String groupName = listCountry.get(groupPosition);

                Toast.makeText(getApplicationContext(),groupName+" is collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String chieldS = listDataChild.get(listCountry.get(groupPosition)).get(childPosition);

                Toast.makeText(getApplicationContext(),chieldS, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpand != -1 && lastExpand!=groupPosition){
                    expandableListView.collapseGroup(lastExpand);
                }
                lastExpand = groupPosition;
            }
        });

    }

    private void prepareListData() {

/*        String[] countries = getResources().getStringArray(R.array.country_names);
        String[] country_details = getResources().getStringArray(R.array.country_details);*/

        listCountry = new ArrayList<>();
        listDataChild = new HashMap<>();
/*
        for(int i=0; i<countries.length; i++){
            listCountry.add(countries[i]);
            List<String> child = new ArrayList<>();
            child.add(country_details[i]);

            listDataChild.put(listCountry.get(i), child);
        }*/

//-----------       -----     new Way    ----        --------
        listCountry.add("1. Overview");
        listCountry.add("2. Brief");

        List<String> overview = new ArrayList<>();
        overview.add("1.1 What is C language");
        overview.add("1.2 What is C++ language");
        overview.add("1.3 What is Python language");
        overview.add("1.4 What is Java language");

        List<String> brief = new ArrayList<>();
        brief.add("2.1 Brief of C language");
        brief.add("2.2 Brief of C++ language");
        brief.add("2.3 Brief of Python language");
        brief.add("2.4 Brief of Java language");

        listDataChild.put(listCountry.get(0), overview);
        listDataChild.put(listCountry.get(1), brief);
    }
}
