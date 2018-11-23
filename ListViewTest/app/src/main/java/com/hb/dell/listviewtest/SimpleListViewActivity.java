package com.hb.dell.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListViewActivity extends AppCompatActivity {

    private String[] data = {"in", "by", "beside", "near", "behind", "in front of", "many", "building", "playground", "school", "airpoot", "farm",
            "bank", "cinema", "factory", "hospital", "hotel", "library", "market", "museum", "office", "post office", "park", "restautant", "shop", "supermarket", "stadium",
            "aoo", "there is"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SimpleListViewActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView)findViewById(R.id.list_view_1);
        listView.setAdapter(adapter);
    }
}
