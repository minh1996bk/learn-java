package classes;

import java.io.Serializable;

public class SinhVien implements Serializable {
  
  private static final long serialVersionUID = 1L;
  private String name;
  private int id;
  
  public SinhVien() {
    this.name = "No name";
    this.id = 0;
  }
  
  public SinhVien(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "SinhVien [name=" + name + ", id=" + id + "]";
  }
  
  
  
  

}
