package view;

import controller.DangNhapController;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.KetNoiCsdl;



public class DangNhapView {
  private JFrame frame;
  private JTextField txtTaiKhoan;
  private JPasswordField txtMatKhau;
  private JCheckBox checkLuuMatKhau;
  
  public DangNhapView() {
    initialize();
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }
  
  public JTextField getTxtTaiKhoan() {
    return txtTaiKhoan;
  }

  public void setTxtTaiKhoan(JTextField txtTaiKhoan) {
    this.txtTaiKhoan = txtTaiKhoan;
  }

  public JPasswordField getTxtMatKhau() {
    return txtMatKhau;
  }

  public void setTxtMatKhau(JPasswordField txtMatKhau) {
    this.txtMatKhau = txtMatKhau;
  }
  
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(550, 300, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblTaiKhoan = new JLabel("Tai Khoan");
    lblTaiKhoan.setBounds(40, 80, 100, 30);
    lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblTaiKhoan);
    
    txtTaiKhoan = new JTextField();
    txtTaiKhoan.setBounds(150, 80, 180, 30);
    txtTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtTaiKhoan);
    
    JLabel lblMatKhau = new JLabel("Mat Khau");
    lblMatKhau.setBounds(40, 130, 100, 30);
    lblMatKhau.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblMatKhau);
    
    txtMatKhau = new JPasswordField();
    txtMatKhau.addActionListener(new DangNhapController(this));
    txtMatKhau.setBounds(150, 130, 180, 30);
    txtMatKhau.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtMatKhau);
  
    
    JButton btnDangNhap = new JButton("Dang Nhap");
    btnDangNhap.setBounds(40, 200, 130, 30);
    btnDangNhap.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnDangNhap);
    
    checkLuuMatKhau = new JCheckBox("Luu mat khau");
    checkLuuMatKhau.setBounds(201, 204, 129, 23);
    frame.getContentPane().add(checkLuuMatKhau);
    
    
    
    KetNoiCsdl con = new KetNoiCsdl();
    Vector<String> vector = con.getTaiKhoanMatKhau();
    if (vector.get(0).equals("1")) {
      txtTaiKhoan.setText(vector.get(1));
      txtMatKhau.setText(vector.get(2));
      checkLuuMatKhau.setSelected(true);
      
    }
    //Tao tin hieu gui den controller
    btnDangNhap.addActionListener(new DangNhapController(this));
    
    
  }

  public JCheckBox getCheckLuuMatKhau() {
    return checkLuuMatKhau;
  }

  public void setCheckLuuMatKhau(JCheckBox checkLuuMatKhau) {
    this.checkLuuMatKhau = checkLuuMatKhau;
  }
}