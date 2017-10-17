package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class TaiKhoan implements Serializable {
  private String tenTaiKhoan;
  private String matKhau;
  
  public TaiKhoan() {
    
  }
  
  public TaiKhoan(String tenTaiKhoan, String matKhau) {
    this.tenTaiKhoan = tenTaiKhoan;
    this.matKhau = matKhau;
  }

  public String getTenTaiKhoan() {
    return tenTaiKhoan;
  }

  public void setTenTaiKhoan(String tenTaiKhoan) {
    this.tenTaiKhoan = tenTaiKhoan;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }
  
  /**
   * 
   * @param taiKhoan tai khoan so sanh.
   * @return true neu mat khau va ten tai khoan giong nhau, nguoc lai tra ve false
   */
  
  public boolean equals(TaiKhoan taiKhoan) {
   
    if (this.tenTaiKhoan.equals(taiKhoan.getTenTaiKhoan()) 
        && this.matKhau.equals(taiKhoan.getMatKhau())) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Phuong thuc luu tai khoan mat khau vao file.
   */
  
  public void luuTaiKhoan() {
    try {
      FileOutputStream out = new FileOutputStream("TaiKhoan");
      ObjectOutputStream objOut = new ObjectOutputStream(out);
      objOut.writeObject(this);
      objOut.flush();
      objOut.close();
      System.out.println("ok");

    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
  /**
   * Phuong kiem tra dang nhap.
   * @return true neu tai khoan mat khau dung, nguoc lai tra ve false neu khong chinh xac
   */
  
  public boolean kiemTraDangNhap() {
    try {
      FileInputStream in = new FileInputStream("TaiKhoan");
      ObjectInputStream objIn = new ObjectInputStream(in);
      TaiKhoan taiKhoan = (TaiKhoan) objIn.readObject();
      objIn.close();
      if (this.equals(taiKhoan)) {
        return true;
      } else {
        return false;
      }
  
    } catch (IOException e) {
      System.out.println(e);
      return false;
    } catch (ClassNotFoundException e) {
      System.out.println(e);
      return false;
    }
    
  }
  
}
