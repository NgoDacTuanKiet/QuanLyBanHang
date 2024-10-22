/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class DangNhap {
    private String taiKhoan, matKhau, maNhanVien;

    public DangNhap() {
    }

    public DangNhap(String taiKhoan, String matKhau, String maNhanVien) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    } 
}
