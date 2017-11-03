package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.HangHoa;
import model.NhaCungCap;
import view.MyPanel;
import view.ThongTinNhanVienView;
import view.ThongTinSanPhamView;

public class XemThongTinSanPhamController implements ActionListener {
  private MyPanel panel;
  
  public XemThongTinSanPhamController(MyPanel panel) {
    this.panel = panel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    DefaultTableModel model = panel.getModel();
    JTable table = panel.getTable();
    int row = table.getSelectedRow();
    if (row == -1) {
      return;
    }
    HangHoa hangHoa = new HangHoa();
    NhaCungCap ncc = new NhaCungCap();

    try {
      String maSanPham = (String) model.getValueAt(row, 0); 
      hangHoa.setMaHangHoa(Integer.parseInt(maSanPham));
      hangHoa.loadHangHoa();
      
      String maNhaCungCap = (String) model.getValueAt(row, 1);
      ncc.setMaNhaCungCap(Integer.parseInt(maNhaCungCap));
      ncc.loadNhaCungCap();
    } catch (NumberFormatException ex) {
      return;
    }
    ThongTinSanPhamView view = new ThongTinSanPhamView();
    ArrayList<JLabel> listInfo = view.getListInfo();
    listInfo.get(0).setText("Ma san pham        :    " + hangHoa.getMaHangHoa());
    listInfo.get(1).setText("Ten san pham       :    " + hangHoa.getTenSanPham());
    listInfo.get(2).setText("Ma nha cung cap    :    " + hangHoa.getMaNhaCungCap());
    listInfo.get(3).setText("Gia tien                :    " + hangHoa.getGiaSanPham());
    listInfo.get(4).setText("Nha san xuat       :    " + hangHoa.getNhaSanXuat());
    listInfo.get(5).setText("Ngay san xuat      :    " + hangHoa.getNgaySanXuat().toString());
    listInfo.get(6).setText("Ngay het han       :    " + hangHoa.getNgayHetHan().toString());
    listInfo.get(7).setText("So luong hien co   :    " + hangHoa.getSoLuongHienCo());
    listInfo.get(8).setText("So luong da ba     :    " + hangHoa.getSoLuongDaBan());
    
    ArrayList<JLabel> listNcc = view.getListNcc();
    listNcc.get(0).setText("Ten nha cung cap    :        " + ncc.getTenNhaCungCap());
    listNcc.get(1).setText("Dia chi             :        " + ncc.getDiaChia());
    listNcc.get(2).setText("Email               :        " + ncc.getEmail());
    listNcc.get(3).setText("So dien thoai       :        " + ncc.getSoDienThoai());


  }

}
