package com.example.appdoctruyen.model;

public class Taikhoan {
    // các biến
    private int mId;
    private String mTentaikhoan;
    private String mMatkhau;
    private String  mEmail;
    private int mQuyen;

    // hàm khởi tạo
    public Taikhoan(String mTentaikhoan, String mMatkhau, String mEmail, int mQuyen) {
        this.mTentaikhoan = mTentaikhoan;
        this.mMatkhau = mMatkhau;
        this.mEmail = mEmail;
        this.mQuyen = mQuyen;
    }

    public Taikhoan(String mTentaikhoan, String mEmail) {
        this.mTentaikhoan = mTentaikhoan;
        this.mEmail = mEmail;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTentaikhoan() {
        return mTentaikhoan;
    }

    public void setmTentaikhoan(String mTentaikhoan) {
        this.mTentaikhoan = mTentaikhoan;
    }

    public String getmMatkhau() {
        return mMatkhau;
    }

    public void setmMatkhau(String mMatkhau) {
        this.mMatkhau = mMatkhau;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmQuyen() {
        return mQuyen;
    }

    public void setmQuyen(int mQuyen) {
        this.mQuyen = mQuyen;
    }
}

