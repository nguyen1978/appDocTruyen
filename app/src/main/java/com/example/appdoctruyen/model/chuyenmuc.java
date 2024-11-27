package com.example.appdoctruyen.model;

public class chuyenmuc {
    private String tenchuyenmuc;
    private int hinhanhchhuyemuc;

    public chuyenmuc(String tenchuyenmuc, int hinhanhchhuyemuc) {
        this.tenchuyenmuc = tenchuyenmuc;
        this.hinhanhchhuyemuc = hinhanhchhuyemuc;
    }

    public String getTenchuyenmuc() {
        return tenchuyenmuc;
    }

    public void setTenchuyenmuc(String tenchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
    }

    public int getHinhanhchhuyemuc() {
        return hinhanhchhuyemuc;
    }

    public void setHinhanhchhuyemuc(int hinhanhchhuyemuc) {
        this.hinhanhchhuyemuc = hinhanhchhuyemuc;
    }
}
