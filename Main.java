package main;

import classes.Class;
import classes.SinhVien;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
  /**
   * 
   * @param args is arguments command line.
   * @throws IOException when file not exist
   * @throws ClassNotFoundException when ..
   */
  
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SinhVien sv = new SinhVien("minh", 1);
    ArrayList<SinhVien> array = new ArrayList<>();
    array.add(sv);
    array.add(new SinhVien());
    Class newClass = new Class("11a", array);
    
    FileOutputStream fout = new FileOutputStream("D:\\object.txt");
    ObjectOutputStream oout = new ObjectOutputStream(fout);
    oout.writeObject(newClass);
    System.out.println("success...");
    oout.flush();
    oout.close();
    
    FileInputStream fin = new FileInputStream("D:\\object.txt");
    ObjectInputStream oin = new ObjectInputStream(fin);
    Class class11a = (Class) oin.readObject();
    oin.close();
    ArrayList<SinhVien> array1 = new ArrayList<>();
    array1 = class11a.getSinhVienList();
    System.out.println(class11a.getClassName());
    for (SinhVien sinhVien : array1) {
      System.out.println(sinhVien.toString());
    }
    
  }
}
