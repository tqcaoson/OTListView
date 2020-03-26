package com.example.otlistview;

public class NVModel {
    private int check, gt;
    private String ma, ten;

    public NVModel(int check, int gt, String ma, String ten) {
        this.check = check;
        this.gt = gt;
        this.ma = ma;
        this.ten = ten;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
