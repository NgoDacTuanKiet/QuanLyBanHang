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
public class NhanVien {
    private String maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi;
    private Date ngaySinh;
    private String chucVu;
    private Date ngayBatDau;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTen, String gioiTinh, String soDienThoai, String diaChi, Date ngaySinh, String chucVu, Date ngayBatDau) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.ngayBatDau = ngayBatDau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
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

    public String getChucVu() {
        return chucVu;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    
}
