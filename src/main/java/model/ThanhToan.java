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
public class ThanhToan {
    private String maThanhToan, maDonHang;
    private Date ngayThanhToan;
    private String phuongThucThanhToan;
    private int soTien;

    public ThanhToan() {
    }

    public ThanhToan(String maThanhToan, String maDonHang, Date ngayThanhToan, String phuongThucThanhToan, int soTien) {
        this.maThanhToan = maThanhToan;
        this.maDonHang = maDonHang;
        this.ngayThanhToan = ngayThanhToan;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.soTien = soTien;
    }


    public String getMaThanhToan() {
        return maThanhToan;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public int getSoTien() {
        return soTien;
    }

    
}
