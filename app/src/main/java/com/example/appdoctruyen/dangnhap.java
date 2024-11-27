package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appdoctruyen.database.databasedoctruyen;

public class dangnhap extends AppCompatActivity {
    // tạo biến cho đăng nhập
    EditText edtTaiKhoan, edtmatKhau;
    Button btnDangNhap, btnDangKy;

    // tạo đối tượng cho databasedoctruyen
    databasedoctruyen databasedoctruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        AnhXa();
        // đối tượng database
        databasedoctruyen = new databasedoctruyen(this);

        // sự kiện click button chuyển sang màn đăng ký
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, dangki.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gán các biến là các giá trị nhập vào
                String taikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtmatKhau.getText().toString();

                //sử dụng con trỏ lấy dữ liệu
                Cursor cursor = databasedoctruyen.getData();

                //thực hiện vòng lặp để lấy dữ liệu từ cursor
                while (cursor.moveToNext()){
                    //lấy dữ liệu gán vào biến
                    String datataikhoan = cursor.getString(1);
                    String datamatkhau = cursor.getString(2);

                    //kiểm tk và mk nhập vào khớp với database
                    if(datataikhoan.equals(taikhoan) && datamatkhau.equals(matkhau)){
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        //chuyển qua màn activity
                        Intent intent = new Intent(dangnhap.this, MainActivity.class);

                        //gửi dữ liệu qua activity
                        intent.putExtra("phanquyen", phanquyen);
                        intent.putExtra("idd", idd);
                        intent.putExtra("email", email);
                        intent.putExtra("taikhoan", tentk);

                        startActivity(intent);

                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }

    private void AnhXa() {
        edtmatKhau = findViewById(R.id.matkhau);
        edtTaiKhoan = findViewById(R.id.taikhoan);
        btnDangKy = findViewById(R.id.dangky);
        btnDangNhap = findViewById(R.id.dangnhap);
    }
}