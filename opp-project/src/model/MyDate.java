package model;

import java.util.Date;

public class MyDate {
  private int ngay;
  private int thang;
  private int nam;
  
  public MyDate() {
    
  }
  
  /**
   * Phuong thuc khoi tao nay nhan tham so la 3 chuoi ngay thang nam.
   * @param ngay ngay hien tai
   * @param thang thang hien tai
   * @param nam nam hien tai
   */
  
  public MyDate(String ngay, String thang, String nam) {
    this.ngay = Integer.parseInt(ngay);
    this.thang = Integer.parseInt(thang);
    this.nam = Integer.parseInt(nam);
  }
  
  /**
   * 
   * @param date tham so ngay kieu java.util.
   */
  
  @SuppressWarnings("deprecation")
  public MyDate(Date date) {
    this.ngay = date.getDate();
    this.thang = date.getMonth() + 1;
    this.nam = date.getYear() + 1900;
  }
  
  /**
   * Phuong thuc chuyen 1 doi tuong MyDate sang chuoi voi dinh dang phu hop.
   */
  
  public String toString() {
    String s = " ";
    if (this.ngay < 10) {
      s = s + "0" + this.ngay;
    } else {
      s = s + this.ngay;
    }
    if (this.thang < 10) {
      s = s + "-0" + this.thang;
    } else {
      s = s + "-" +  this.thang;
    }
    s = s + "-" + this.nam + " ";
    return s;
  }
  
  public int getNgay() {
    return ngay;
  }

  public void setNgay(int ngay) {
    this.ngay = ngay;
  }

  public int getThang() {
    return thang;
  }

  public void setThang(int thang) {
    this.thang = thang;
  }

  public int getNam() {
    return nam;
  }

  public void setNam(int nam) {
    this.nam = nam;
  }
  
  /**
   * Phuong thuc so ngay voi tham so myDate chuyen vao.
   * @param myDate ngay de so sanh
   * @return true neu ngay > myDate nguoc lai false neu ngay < myDate
   */
  
  public boolean lonHonHoacBang(MyDate myDate) {
    if (this.nam < myDate.getNam()) {
      return false;
    } else if (this.thang < myDate.getThang()) {
      return false;
    } else if (this.ngay < myDate.getNgay()) {
      return false;
    } else {
      return true;
    }
  }
  
  /**
   * Phuong thuc so ngay voi tham so myDate chuyen vao.
   * @param myDate ngay de so sanh
   * @return true neu ngay < myDate nguoc lai false neu ngay > myDate
   */
  
  public boolean nhoHonHoacBang(MyDate myDate) {
    if (this.nam > myDate.getNam()) {
      return false;
    } else if (this.thang > myDate.getThang()) {
      return false;
    } else if (this.ngay > myDate.getNgay()) {
      return false;
    } else {
      return true;
    }
  }
}
