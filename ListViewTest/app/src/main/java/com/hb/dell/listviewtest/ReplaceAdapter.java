package com.hb.dell.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hb.dell.listviewtest.model.Replace;

import java.util.List;

public class ReplaceAdapter extends ArrayAdapter<Replace> {

    private int resourceId;

    public ReplaceAdapter(Context context, int textViewResourceId, List<Replace> objs){
        super(context, textViewResourceId, objs);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        Replace replace = this.getItem(position);
        View view = convertView;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setImageView((ImageView) view.findViewById(R.id.replace_image));
            viewHolder.setTextView((TextView)view.findViewById(R.id.replace_name));
            view.setTag(viewHolder);
        }
        ImageView imageView = ((ViewHolder) view.getTag()).getImageView();
        TextView textView = ((ViewHolder) view.getTag()).getTextView();
        imageView.setImageResource(replace.getId());
        textView.setText(replace.getName());
        return view;
    }
}

class ViewHolder {
    private ImageView imageView;
    private TextView textView;

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
