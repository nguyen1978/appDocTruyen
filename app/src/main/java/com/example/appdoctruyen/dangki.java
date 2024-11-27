package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdoctruyen.database.databasedoctruyen;
import com.example.appdoctruyen.model.Taikhoan;

public class dangki extends AppCompatActivity {

    EditText edtTaikhoan, edtMatkhau, edtEmail;
    Button btnDKDangky, btnDKDangnhap;

    databasedoctruyen databasedoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);

        databasedoctruyen = new databasedoctruyen(this);

        AnhXa();

        // click button đăng ký
        btnDKDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtTaikhoan.getText().toString();
                String matkhau = edtMatkhau.getText().toString();
                String email = edtEmail.getText().toString();

                Taikhoan taikhoan1 = CreateTaikhoan();
                if(taikhoan.equals("") || matkhau.equals("") || email.equals("")){
                    Log.e("Thông báo : ", "Chưa nhập đủ thông tin");
                }
                else {
                    databasedoctruyen.AddTaikhoan(taikhoan1);
                    Toast.makeText(dangki.this, "Đang ký thành công", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDKDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // phương thức tạo 1 tài khoản
    private Taikhoan CreateTaikhoan(){
        String taikhoan = edtTaikhoan.getText().toString();
        String matkhau = edtMatkhau.getText().toString();
        String email = edtEmail.getText().toString();
        int phanquyen = 1;

        Taikhoan tk = new Taikhoan(taikhoan, matkhau, email, phanquyen);

        return tk;
    }

    private void AnhXa() {
        edtEmail = findViewById(R.id.email);
        edtMatkhau = findViewById(R.id.dkmatkhau);
        edtTaikhoan = findViewById(R.id.dktaikhoan);
        btnDKDangky = findViewById(R.id.dkdangky);
        btnDKDangnhap = findViewById(R.id.dangnhap);
    }

}