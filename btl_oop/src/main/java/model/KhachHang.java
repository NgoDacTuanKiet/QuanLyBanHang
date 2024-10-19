/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class KhachHang {
    private String maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi;
    private Date ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTen, String gioiTinh, String soDienThoai, String diaChi, Date ngaySinh) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
    
}
