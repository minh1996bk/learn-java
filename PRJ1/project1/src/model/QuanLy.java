package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

public class QuanLy extends NhanVien {
  /**
   * Them nhan vien vao csdl.
   * @param nhanVien nhan vien duoc them moi
   */
  
  public void themNhanVien(NhanVien nhanVien) {
    String sql = "insert into employeeinfo_tb "
        + "(id, name, ages, sex, birth_date, hire_date, salary) "
        + "values (null, '" + nhanVien.getTenNhanVien() + "', " + nhanVien.getTuoiNhanVien() + ","
        + " '" + nhanVien.getGioiTinh() + "', '" + nhanVien.getNgaySinh().toString() + "',"
        + " '" + nhanVien.getNgayVaoLam().toString() + "', " + nhanVien.getLuongCoBan() + " )";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    String sql1 = "select max(id) from employeeinfo_tb";
    try {
      ResultSet result = new KetNoiCsdl().getStatement().executeQuery(sql1);
      while (result.next()) {
        nhanVien.setIdNhanVien(result.getInt(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    nhanVien.batDauThangLamViecMoi();
   
  }
  
  /**
   * Tao tai khoan dang nhap cho nhanVien.
   * @param nhanVien nhan vien duoc tao tai khoan moi
   */
  
  public void taoTaiKhoanDangNhapChoNhanVien(NhanVien nhanVien) {
    
    
    String sql = "insert into account_tb (id, user_name, password)"
        + "values (" + nhanVien.getIdNhanVien() + ", '" + nhanVien.getTenNhanVien()
        + "', '" + nhanVien.getTenNhanVien() + "')";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void thayDoiLuongNhanVien(NhanVien nhanVien, int luongMoi) {
    nhanVien.setLuongCoBan(luongMoi);
    nhanVien.saveNhanVien();
  }
  
  /**
   * Phuong thuc lay thong tin danh sach nhan vien tu csdl.
   * @return vector chua thong tin nhan vien
   */
  
  public Vector<String[]> getDanhSachNhanVien() {
    String sql = "select em.id, em.name, em.salary, w.session_count "
        + "from employeeinfo_tb as em, work_time_tb as w "
        + "where em.id = w.id and w.end_date = '99-99-9999' ";
    KetNoiCsdl con = new KetNoiCsdl();
    ResultSet result;
    Vector<String[]> vector = new Vector<>();
    try {
      result = con.getStatement().executeQuery(sql);
      while (result.next()) {
        String[] str = {"" + result.getInt(1), result.getString(2), "" + result.getInt(3), "" 
            + result.getInt(4)};
        vector.add(str);
      }
      return vector;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
    
  }
  
  public ArrayList<NhanVien> loadDanhSachNhanVien() {
    String sql = "select id from employeeinfo_tb";
    ResultSet result;
    NhanVien nv;
    ArrayList<NhanVien> listNhanVien = new ArrayList<>();
    try {
      result = new KetNoiCsdl().getStatement().executeQuery(sql);
      while (result.next()) {
        nv = new NhanVien();
        nv.setIdNhanVien(result.getInt(1));
        nv.loadNhanVien();
        nv.loadLsLamViec();
        listNhanVien.add(nv);
      }
      return listNhanVien;
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }
  /**
   * Luu du lieu san pham duoc nhap vao trong csdl.
   * @param hangHoa hang hoa duoc nhap vao
   */
  
  public void themHangHoa(HangHoa hangHoa) {
    String sql = "insert into goods_tb (code, name, price, producer, produce_date, expire_date, "
        + "remain_amount, sold_amount) values (null, '" + hangHoa.getTenSanPham() + "', "
        + hangHoa.getGiaSanPham() + ", '" + hangHoa.getNhaSanXuat() + "', '"
        + hangHoa.getNgaySanXuat().toString() + "', '" + hangHoa.getNgayHetHan().toString() 
        + "', " + hangHoa.getSoLuongHienCo() + ", 0)";
    KetNoiCsdl con = new KetNoiCsdl();
    try {
      con.getStatement().executeUpdate(sql);
      String sql1 = "select max(code) from goods_tb";
      try {
        ResultSet result = con.getStatement().executeQuery(sql1);
        int maHangHoa = 0;
        while (result.next()) {
          maHangHoa = result.getInt(1);
        }
        String sql2 = "insert into import_bill_tb (code_import, id_nha_cung_cap, code, "
            + "time, sold_price) values (null, " + hangHoa.getMaNhaCungCap() + ", "
            + maHangHoa + ", '" + new MyDate(new Date()).toString() + "', " 
            + hangHoa.getGiaSanPham() + ")";
        System.out.println(sql2);
        con.getStatement().executeUpdate(sql2);
      } catch (SQLException e) {
        e.printStackTrace();
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
  }

  /**
   * Luu du lieu nha cung cap moi vao csdl.
   * @param ncc doi tuong nha cung cap moi
   */
  
  public void addNhaCungCap(NhaCungCap ncc) {
    String sql = "insert into nha_cung_cap_tb (id, name, address, mail, phone_no) values (null, '" 
        + ncc.getTenNhaCungCap() + "', '" + ncc.getDiaChia() + "', '" + ncc.getEmail() + "', '" 
        + ncc.getSoDienThoai() + "')";
    try {
      new KetNoiCsdl().getStatement().executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Lay danh sach nha cung cap tu csdl.
   * @return vector luu du lieu
   */
  
  public Vector<String[]> getDanhSachNhaCungCap() {
    String sql = "select * from nha_cung_cap_tb";
    KetNoiCsdl con = new KetNoiCsdl();
    ResultSet result;
    Vector<String[]> vector = new Vector<>();
    try {
      result = con.getStatement().executeQuery(sql);
      while (result.next()) {
        String[] str = {"" + result.getInt(1), result.getString(2), result.getString(3),
            result.getString(4), result.getString(5)};
        vector.add(str);
      }
      return vector;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
    
  }
  
  /**
   * tra luong nhan vien.
   * @param listNhanVien danh sach nhan vien
   */
  
  public void traLuongNhanVien(ArrayList<NhanVien> listNhanVien) {
    ArrayList<LichSuLamViec> list = listNhanVien.get(0).getLsLamViec();
    int index = list.size();
    LichSuLamViec ls = list.get(index - 1);
    if (ls.getNgayBatDau().toString().equals(new MyDate(new Date()).toString())) {
      JOptionPane.showMessageDialog(null, "Ban vua thuc hien tra luong");
      return;
    }
    for (NhanVien nv : listNhanVien) {
      nv.traLuong();
      nv.batDauThangLamViecMoi();
    }
    try {
      this.inBangLuong(listNhanVien);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * in bang luong nhan vien.
   * @param listNhanVien danh sach nhan vien
   * @throws IOException bao loi
   */
  
  public void inBangLuong(ArrayList<NhanVien> listNhanVien) throws IOException {
    BufferedWriter writer = null;
    LichSuLamViec ls = new LichSuLamViec();
    try {
      writer = new BufferedWriter(new FileWriter("D:\\bangLuong.txt"));
      for (NhanVien nv : listNhanVien) {
        ls = nv.getLsLamViec().get(nv.getLsLamViec().size() - 2);
        writer.write(nv.getIdNhanVien());
        writer.write("+++++");
        writer.write(nv.getTenNhanVien());
        writer.write("+++++");
        writer.write("" + ls.getLuongThoiDiem());
        writer.write("+++++");
        writer.write(ls.getSoCaLamViec());
        writer.write("+++++");
        writer.newLine();;
      }
    } catch (IOException ex) {
      System.out.println(ex);
    } finally {
      writer.close();
    }
    
  }
}
