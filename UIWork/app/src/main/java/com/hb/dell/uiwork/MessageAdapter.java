package com.hb.dell.uiwork;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hb.dell.uiwork.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> msgs;

    public MessageAdapter(List<Message> msgs){
        this.msgs = msgs;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item, viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {
        Message msg = msgs.get(i);
        if(Message.TYPE_RECEIVED.equals(msg.getType())){
            messageViewHolder.getItemLeftLayout().setVisibility(View.VISIBLE);
            messageViewHolder.getItemRightLayout().setVisibility(View.GONE);
            messageViewHolder.getMessageLeftText().setText(msg.getContent());
        }else{
            messageViewHolder.getItemLeftLayout().setVisibility(View.GONE);
            messageViewHolder.getItemRightLayout().setVisibility(View.VISIBLE);
            messageViewHolder.getMessageRightText().setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    public List<Message> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Message> msgs) {
        this.msgs = msgs;
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemLeftLayout;
        private LinearLayout itemRightLayout;

        private TextView messageLeftText;
        private TextView messageRightText;

        public MessageViewHolder(View view){
            super(view);
            itemLeftLayout = view.findViewById(R.id.leftMsg);
            itemRightLayout = view.findViewById(R.id.rightMsg);
            messageLeftText = view.findViewById(R.id.leftMsgContent);
            messageRightText = view.findViewById(R.id.rightMsgContent);
        }

        public LinearLayout getItemLeftLayout() {
            return itemLeftLayout;
        }

        public void setItemLeftLayout(LinearLayout itemLeftLayout) {
            this.itemLeftLayout = itemLeftLayout;
        }

        public LinearLayout getItemRightLayout() {
            return itemRightLayout;
        }

        public void setItemRightLayout(LinearLayout itemRightLayout) {
            this.itemRightLayout = itemRightLayout;
        }

        public TextView getMessageLeftText() {
            return messageLeftText;
        }

        public void setMessageLeftText(TextView messageLeftText) {
            this.messageLeftText = messageLeftText;
        }

        public TextView getMessageRightText() {
            return messageRightText;
        }

        public void setMessageRightText(TextView messageRightText) {
            this.messageRightText = messageRightText;
        }
    }
}
