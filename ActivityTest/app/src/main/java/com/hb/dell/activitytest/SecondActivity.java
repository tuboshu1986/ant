package com.hb.dell.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        final Intent intent = getIntent();
        String msg = intent.getStringExtra("sv");
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        Button backButton = (Button) findViewById(R.id.button_2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                finish();
            }
        });

        Button openFirst = (Button)findViewById(R.id.button_open_first);
        openFirst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                SecondActivity.this.startActivity(intent);
            }
        });

        Button openThird = (Button) findViewById(R.id.button_open_third);
        openThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                SecondActivity.this.startActivity(intent);
            }
        });

        Log.i(TAG, "onCreate: " + getTaskId());

    }

    @Override
    public void onBackPressed() {
        call();
        finish();
    }

    private Intent call(){
        Intent intent = new Intent();
        intent.putExtra("call","Hail China");
        setResult(RESULT_OK, intent);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 第二活动销毁");
    }
}
