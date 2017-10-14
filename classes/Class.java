package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
  
  private static final long serialVersionUID = 1L;
  private String className;
  private ArrayList<SinhVien> sinhVienList;
  
  public Class() {
    this.className = "no name";
    this.sinhVienList = null;
  }
  
  public Class(String className, ArrayList<SinhVien> sinhVienList) {
    this.className = className;
    this.sinhVienList = sinhVienList;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public ArrayList<SinhVien> getSinhVienList() {
    return sinhVienList;
  }

  public void setSinhVienList(ArrayList<SinhVien> sinhVienList) {
    this.sinhVienList = sinhVienList;
  }
  
  
}
