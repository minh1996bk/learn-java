package hocjava;

public class SinhVien {
  String tenSinhVien;
  String maSoSinhVIen;
   
  public String getTenSinhVien() {
    return tenSinhVien;
  }

  public void setTenSinhVien(String tenSinhVien) {
    this.tenSinhVien = tenSinhVien;
  }

  public String getMaSoSinhVIen() {
    return maSoSinhVIen;
  }

  public void setMaSoSinhVIen(String maSoSinhVIen) {
    this.maSoSinhVIen = maSoSinhVIen;
  }

  public int getTuoi() {
    return tuoi;
  }

  public void setTuoi(int tuoi) {
    this.tuoi = tuoi;
  }

  int tuoi;
   
  public void inThongTin() {
    System.out.println("Ten : " + tenSinhVien);
  }
}
