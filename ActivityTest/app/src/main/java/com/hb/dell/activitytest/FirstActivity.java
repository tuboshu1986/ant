package com.hb.dell.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "你点击了按钮1", Toast.LENGTH_LONG).show();
            }
        });

        Button finishButton = (Button)findViewById(R.id.button_finid_first_activity);
        finishButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirstActivity.this.finish();
            }
        });

        Button startSecondActivity = (Button)findViewById(R.id.button_start_second);
        startSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("sv", "The universe remains.");
                FirstActivity.this.startActivityForResult(intent, 1);
            }
        });

        Button startSecondActivity1 = (Button)findViewById(R.id.button_start_second1);
        startSecondActivity1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.hb.dell.actiontest.ACTION_START");
                intent.addCategory("com.hb.dell.actiontest.MY_CATEGORY");
                FirstActivity.this.startActivity(intent);
            }
        });

        Button openBrower = (Button)findViewById(R.id.button_open_brower);
        openBrower.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                FirstActivity.this.startActivity(intent);
            }
        });

        Button openSelf = (Button) findViewById(R.id.button_open_self);
        openSelf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intet= new Intent(FirstActivity.this, FirstActivity.class);
                FirstActivity.this.startActivity(intet);
            }
        });

        Log.d(TAG, "创建FirstActivity");
        Log.i(TAG, "onCreate: " + getTaskId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "点击了add菜单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_item:
                Toast.makeText(FirstActivity.this, "点击了edit菜单", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    Toast.makeText(this, data.getStringExtra("call"), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
