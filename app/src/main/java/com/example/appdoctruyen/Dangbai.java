package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdoctruyen.database.databasedoctruyen;
import com.example.appdoctruyen.model.Truyen;

public class Dangbai extends AppCompatActivity {

    EditText edtTenTruyen , edtNoiDung, edtAnh;
    Button btnDangBai;
    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangbai);

        edtAnh = findViewById(R.id.dbAnh);
        edtTenTruyen = findViewById(R.id.dbTenTruyen);
        edtNoiDung = findViewById(R.id.dbNoiDung);
        btnDangBai = findViewById(R.id.dbDangbai);

        databasedoctruyen = new databasedoctruyen(this);
        //button dang bai
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentruyen = edtTenTruyen.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();
                Truyen truyen = CreatTruyen();

                if(tentruyen.equals("") || noidung.equals("") || img.equals("")){
                    Toast.makeText(Dangbai.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("ERR", "Nhập đầy đủ thông tin");
                }
                else{
                    databasedoctruyen.AddTruyen(truyen);

                    Intent intent = new Intent(Dangbai.this, Admin.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }
    //phương thức tạo truyện
    private Truyen CreatTruyen(){
        String tentruyen = edtTenTruyen.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();

        Intent intent = getIntent();

        int id = intent.getIntExtra("Id", 0);

        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return truyen;
    }
}