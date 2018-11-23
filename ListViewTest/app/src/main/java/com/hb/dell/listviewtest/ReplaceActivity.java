package com.hb.dell.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hb.dell.listviewtest.model.Replace;

import java.util.ArrayList;
import java.util.List;

public class ReplaceActivity extends AppCompatActivity {

    private List<Replace> replaces = new ArrayList<Replace>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);

        ReplaceAdapter adapter = new ReplaceAdapter(ReplaceActivity.this, R.layout.replace_item, initReplace());
        ListView listView = (ListView)findViewById(R.id.list_view_2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Replace replace = replaces.get(position);
                Toast.makeText(ReplaceActivity.this, replace.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String[] data = {"in", "by", "beside", "near", "behind", "in front of", "many", "building", "playground", "school", "airpoot", "farm",
            "bank", "cinema", "factory", "hospital", "hotel", "library", "market", "museum", "office", "post office", "park", "restautant", "shop", "supermarket", "stadium",
            "aoo", "there is"};

    private List<Replace> initReplace(){
        for(int i=0; i < 100 ; i++) {
            for (String str : data) {
                replaces.add(new Replace(R.drawable.icon4, str + "(" + i + ")"));
            }
        }
        return replaces;
    }

}
