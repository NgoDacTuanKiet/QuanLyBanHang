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
    private String taiKhoan, matKhau, maKhachHang;

    public DangNhap() {
    }

    public DangNhap(String taiKhoan, String matKhau, String maKhachHang) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maKhachHang = maKhachHang;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }
    
}
