package com.hb.dell.uiwork;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hb.dell.uiwork.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private static final String TAG = "MessageActivity";
    
    private List<Message> messages = new ArrayList<>();
    private EditText messageInput;
    private Button send;
    private RecyclerView messagePanel;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initMsg();
        messageInput = (EditText)findViewById(R.id.inputText);
        send = (Button)findViewById(R.id.sendButton);
        messagePanel = (RecyclerView)findViewById(R.id.recyclerView1);
        messageAdapter = new MessageAdapter(messages);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messagePanel.setLayoutManager(layoutManager);
        messagePanel.setAdapter(messageAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = messageInput.getText().toString();
                if(!"".equals(content)){
                    Log.e(TAG, ">>>>" + content);
                    Message msg = new Message(Message.TYPE_SENT, content);
                    messages.add(msg);
                    messageAdapter.notifyItemChanged(messages.size() - 1);
                    messagePanel.scrollToPosition(messages.size() - 1);
                    messageInput.setText("");
                }
            }
        });

    }

    private void initMsg(){
        Message msg1 = new Message(Message.TYPE_RECEIVED, "Hello guy.");
        messages.add(msg1);
        Message msg2 = new Message(Message.TYPE_RECEIVED, "Hello,What is that?");
        messages.add(msg2);
        Message msg3 = new Message(Message.TYPE_RECEIVED, "This is Tom, Nice talking to you.");
        messages.add(msg3);
    }

}
