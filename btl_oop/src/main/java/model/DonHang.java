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
public class DonHang {
    private String maDonHang, maKhachHang;
    private Date ngayDatHang;
    private int tongTien;
    private String trangThai;

    public DonHang() {
    }

    public DonHang(String maDonHang, String maKhachHang, Date ngayDatHang, int tongTien, String trangThai) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.ngayDatHang = ngayDatHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public int getTongTien() {
        return tongTien;
    }
    
}
