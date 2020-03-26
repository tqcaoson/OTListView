package com.example.otlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button them;
    ImageButton xoa;
    EditText ma, ten;
    RadioButton nam, nu;
    ListView listViewNV;
    ArrayList<NVModel> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        datas.add(new NVModel(0, 1, "ma1", "son"));
        datas.add(new NVModel(0, 1, "ma1", "son"));
        datas.add(new NVModel(0, 1, "ma1", "son"));
        final AdapterNV adapterNV = new AdapterNV(MainActivity.this, datas);
        listViewNV.setAdapter(adapterNV);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gt = 1;
                if(nu.isChecked()) gt = 0;
                String mnv = ma.getText().toString();
                String tnv = ten.getText().toString();
                datas.add(new NVModel(0, gt, mnv, tnv));
                adapterNV.notifyDataSetChanged();
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Del(adapterNV);
            }
        });
    }
    void Del(AdapterNV adapterNV) {
        for (NVModel pos : datas) {
            if (pos.getCheck() == 1) {
                adapterNV.remove(pos);
                Del(adapterNV);
                break;
            }
        }
    }
    void anhXa(){
        them = findViewById(R.id.them);
        ma = findViewById(R.id.ma);
        ten = findViewById(R.id.ten);
        nam = findViewById(R.id.nam);
        nu = findViewById(R.id.nu);
        xoa = findViewById(R.id.del);
        listViewNV = findViewById(R.id.list);
        datas = new ArrayList<>();
    }
}
