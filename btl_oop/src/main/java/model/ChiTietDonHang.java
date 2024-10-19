/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class ChiTietDonHang {
    private String maChiTiet, maHoaDon, maSanPham;
    private int soLuong, donGia;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maChiTiet, String maHoaDon, String maSanPham, int soLuong, int donGia) {
        this.maChiTiet = maChiTiet;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaChiTiet() {
        return maChiTiet;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }
    
}
