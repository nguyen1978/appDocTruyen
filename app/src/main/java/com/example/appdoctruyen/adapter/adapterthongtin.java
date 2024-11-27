package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.Taikhoan;

import java.util.List;

public class adapterthongtin extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Taikhoan> taikhoanList;

    public adapterthongtin(Context context, int layout, List<Taikhoan> taikhoanList) {
        this.context = context;
        this.layout = layout;
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int getCount() {
        return taikhoanList.size();
    }

    @Override
    public Object getItem(int posititon) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtTenTaiKhoan = (TextView) convertView.findViewById(R.id.text_name);
        TextView txtemail = (TextView) convertView.findViewById(R.id.text_email);

        Taikhoan taikhoan = taikhoanList.get(position);

        txtTenTaiKhoan.setText(taikhoan.getmTentaikhoan());
        txtemail.setText(taikhoan.getmEmail());

        return convertView;
    }
}
