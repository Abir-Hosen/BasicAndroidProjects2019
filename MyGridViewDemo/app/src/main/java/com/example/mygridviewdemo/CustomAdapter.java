package com.example.mygridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    Context context;
    int[] flag;
    String[] countryName;

    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] countryName, int[] flag){
        this.context = context;
        this.countryName = countryName;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.sample_view, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgId);
        TextView textView = (TextView) convertView.findViewById(R.id.txtId);

        imageView.setImageResource(flag[position]);
        textView.setText(countryName[position]);

        return convertView;
    }
}
