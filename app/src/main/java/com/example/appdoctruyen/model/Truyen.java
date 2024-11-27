package com.example.appdoctruyen.model;

public class Truyen {
    private int ID;
    private String TenTruyen;
    private String NoiDung;
    private String Anh;
    private int ID_Tk;

    public Truyen(int ID, String tenTruyen, String noiDung, String anh, int ID_Tk) {
        this.ID = ID;
        TenTruyen = tenTruyen;
        NoiDung = noiDung;
        Anh = anh;
        this.ID_Tk = ID_Tk;
    }

    public Truyen(String tenTruyen, String noiDung, String anh, int ID_Tk) {
        TenTruyen = tenTruyen;
        NoiDung = noiDung;
        Anh = anh;
        this.ID_Tk = ID_Tk;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public int getID_Tk() {
        return ID_Tk;
    }

    public void setID_Tk(int ID_Tk) {
        this.ID_Tk = ID_Tk;
    }
}
