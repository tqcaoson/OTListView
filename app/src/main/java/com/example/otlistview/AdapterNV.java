package com.example.otlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNV extends BaseAdapter {
    private Context context;
    private ArrayList<NVModel> datas;

    public AdapterNV(Context context, ArrayList<NVModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void remove(NVModel  object) {

        datas.remove(object);

        notifyDataSetChanged();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        ImageView anh = convertView.findViewById(R.id.gt);
        TextView ma = convertView.findViewById(R.id.ma);
        TextView ten = convertView.findViewById(R.id.ten);
        final CheckBox check = convertView.findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()) datas.get(position).setCheck(1);
                else datas.get(position).setCheck(1);
            }
        });
        anh.setImageResource(R.drawable.male);
        if (datas.get(position).getGt() == 0) anh.setImageResource(R.drawable.female);
        ma.setText(datas.get(position).getMa());
        ten.setText(datas.get(position).getTen());
        return convertView;
    }
}
