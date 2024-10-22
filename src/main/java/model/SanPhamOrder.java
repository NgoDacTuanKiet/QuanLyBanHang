/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class SanPhamOrder {
    private SanPham sanPham;
    private int soLuongNhap, thanhTien;

    public SanPhamOrder(SanPham sanPham, int soLuongNhap, int thanhTien) {
        this.sanPham = sanPham;
        this.soLuongNhap = soLuongNhap;
        this.thanhTien = thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public int getThanhTien() {
        return thanhTien;
    }
    
}
