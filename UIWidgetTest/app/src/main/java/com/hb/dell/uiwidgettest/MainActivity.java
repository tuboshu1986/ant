package com.hb.dell.uiwidgettest;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, ">>>>点击");
                EditText editText = ((EditText)findViewById(R.id.editText1));
                String msg = editText == null ? "点击" : editText.getText().toString();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.hideProgressBar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = ((ProgressBar)findViewById(R.id.progressBar1));
                int progress = progressBar.getProgress();
                if(progress < 100){
                    progressBar.setProgress(progress + 10);
                }else{
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    dialogBuilder.setTitle("消息");
                    dialogBuilder.setMessage("进度条已满");
                    dialogBuilder.setCancelable(false);
                    dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialogBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialogBuilder.show();
                }
                //progressBar.setVisibility(View.GONE);
            }
        });

        findViewById(R.id.showProgressBar).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = ((ProgressBar)findViewById(R.id.progressBar1));
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.showProgressDialog).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度");
                progressDialog.setMessage("正在处理......");
                progressDialog.setCancelable(false);
                progressDialog.show();
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        ProgressBar progressBar = ((ProgressBar)findViewById(R.id.progressBar1));
                        while(true){
                            int progress = progressBar.getProgress();
                            if(progress < 100){
                                progressBar.setProgress(progress + 10);
                                progressBar.setVisibility(View.VISIBLE);
                                try {
                                    Thread.sleep(1000);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }else{
                                progressDialog.show();
                            }
                        }
                    }
                }).start();
            }
        });

        findViewById(R.id.showLinearLayoutDemo).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.showRelativeLayoutDemo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
