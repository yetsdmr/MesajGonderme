package com.example.mesajgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeDoldur();
        tanimla();
    }
    private void listeDoldur(){
        list = new ArrayList<>();
        model m1 = new model("Emre","00000000000");
        model m2 = new model("Ali","00000000000");
        model m3 = new model("Onur","00000000000");
        list.add(m1);
        list.add(m2);
        list.add(m3);

    }
    private void tanimla(){
        ListView listView = findViewById(R.id.mesajList);
        adapter adp = new adapter(list,this,this);
        listView.setAdapter(adp);
    }
}