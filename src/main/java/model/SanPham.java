/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class SanPham {
    private String maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac;
    private int giaMua, giaBan, soLuongTonKho;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String loaiSanPham, String kichCo, String mauSac, int giaBan, int giaMua, int soLuongTonKho) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loaiSanPham = loaiSanPham;
        this.kichCo = kichCo;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.giaMua = giaMua;
        this.soLuongTonKho = soLuongTonKho;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public String getKichCo() {
        return kichCo;
    }

    public String getMauSac() {
        return mauSac;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }
    
}
