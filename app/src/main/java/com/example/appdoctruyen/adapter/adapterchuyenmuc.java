package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.chuyenmuc;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterchuyenmuc extends BaseAdapter {

    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmucList;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmucList = chuyenmucList;
    }

    @Override
    public int getCount() {
        return chuyenmucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.img_chuyenmuc);

        TextView txt = (TextView) convertView.findViewById(R.id.text_view_chuyenmuc);

        chuyenmuc cm = chuyenmucList.get(position);

        txt.setText(cm.getTenchuyenmuc());

        Picasso.get().load(cm.getHinhanhchhuyemuc()).placeholder(R.drawable.ic_load).error(R.drawable.ic_img).into(img);

        return convertView;
    }
}
