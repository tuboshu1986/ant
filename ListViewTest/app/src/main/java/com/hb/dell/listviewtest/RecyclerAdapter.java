package com.hb.dell.listviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hb.dell.listviewtest.model.Replace;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Replace> replaces;

    public RecyclerAdapter(List<Replace> replaces){
        this.replaces = replaces;
    }

    @Override
    public int getItemCount() {
        return this.replaces.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.replace_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.getMyView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), replaces.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "图片》" + replaces.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Replace replace = replaces.get(i);
        viewHolder.getImageView().setImageResource(replace.getId());
        viewHolder.getTextView().setText(replace.getName());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private View myView;

        public ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.replace_image);
            textView = view.findViewById(R.id.replace_name);
            this.myView = view;
        }

        public View getMyView() {
            return myView;
        }

        public void setMyView(View myView) {
            this.myView = myView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}
