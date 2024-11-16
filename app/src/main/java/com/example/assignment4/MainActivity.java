package com.example.assignment4;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Samsung", R.drawable.ic_launcher_foreground));
        items.add(new Item("Apple", R.drawable.ic_launcher_foreground));
        items.add(new Item("Oppo", R.drawable.ic_launcher_foreground));

        CustomAdapter customAdapter = new CustomAdapter(this, items);
        listView.setAdapter(customAdapter);


        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        List<String> listGroup = new ArrayList<>();
        HashMap<String, List<String>> listChild = new HashMap<>();

        listGroup.add("Samsung");
        listGroup.add("Apple");

        List<String> samsung = new ArrayList<>();
        samsung.add("S20");
        samsung.add("S22");
        samsung.add("A50");

        List<String> apple = new ArrayList<>();
        apple.add("iphone10");
        apple.add("iphone15");
        apple.add("iphone16");

        listChild.put(listGroup.get(0), samsung);
        listChild.put(listGroup.get(1), apple);

        CustomExpandableListAdapter expandableAdapter = new CustomExpandableListAdapter(this, listGroup, listChild);
        expandableListView.setAdapter(expandableAdapter);
    }
}