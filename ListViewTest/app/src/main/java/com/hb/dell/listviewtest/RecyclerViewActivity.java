package com.hb.dell.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.hb.dell.listviewtest.model.Replace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //recyclerView.setLayoutManager(layoutManager);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(new RecyclerAdapter(initReplace()));
    }

    private String[] data = {"in", "by", "beside", "near", "behind", "in front of", "many", "building", "playground", "school", "airpoot", "farm",
            "bank", "cinema", "factory", "hospital", "hotel", "library", "market", "museum", "office", "post office", "park", "restautant", "shop", "supermarket", "stadium",
            "aoo", "there is"};

    private List<Replace> initReplace(){
        List<Replace> replaces = new ArrayList<Replace>();
        for (String str : data) {
            replaces.add(new Replace(R.drawable.icon4, randomName(str)));
        }
        return replaces;
    }

    private String randomName(String name){
        Random r = new Random();
        int c = r.nextInt(5) + 1;
        for(int i=0 ; i<c  ; i++){
            name += name;
        }
        return name;
    }
}
