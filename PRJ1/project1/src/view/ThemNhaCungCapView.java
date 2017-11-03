package view;

import controller.ThemNhaCungCapController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ThemNhaCungCapView {

  private JFrame frame;
  private JTextField txtName;
  private JTextField txtAddress;
  private JTextField txtEmail;
  
  public MyPanel getBangNhaCungCap() {
    return bangNhaCungCap;
  }

  public void setBangNhaCungCap(MyPanel bangNhaCungCap) {
    this.bangNhaCungCap = bangNhaCungCap;
  }

  private JTextField txtPhoneNo;
  private MyPanel bangNhaCungCap;
  
  public ThemNhaCungCapView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    Font font = new Font("Đialog", Font.BOLD, 15);
    
    JLabel lblName = new JLabel("Ten nha cung cap");
    lblName.setFont(font);
    lblName.setBounds(40, 40, 150, 25);
    frame.getContentPane().add(lblName);
    
    JLabel lblAddress = new JLabel("Dia chi");
    lblAddress.setFont(font);
    lblAddress.setBounds(40, 90, 150, 25);
    frame.getContentPane().add(lblAddress);
    
    JLabel lblEmail = new JLabel("Email");
    lblEmail.setFont(font);
    lblEmail.setBounds(40, 140, 150, 25);
    frame.getContentPane().add(lblEmail);
    
    JLabel lblPhoneNo = new JLabel("So dien thoai");
    lblPhoneNo.setFont(font);
    lblPhoneNo.setBounds(40, 190, 150, 25);
    frame.getContentPane().add(lblPhoneNo);
    
    txtName = new JTextField();
    txtName.setFont(font);
    txtName.setBounds(250, 40, 300, 25);
    frame.getContentPane().add(txtName);
    
    txtAddress = new JTextField();
    txtAddress.setFont(font);
    txtAddress.setBounds(250, 90, 300, 25);
    frame.getContentPane().add(txtAddress);
    
    txtEmail = new JTextField();
    txtEmail.setFont(font);
    txtEmail.setBounds(250, 140, 300, 25);
    frame.getContentPane().add(txtEmail);
    
    txtPhoneNo = new JTextField();
    txtPhoneNo.setFont(font);
    txtPhoneNo.setBounds(250, 190, 300, 25);
    frame.getContentPane().add(txtPhoneNo);
    
    JButton btnAdd = new JButton("Add");
    btnAdd.setFont(font);
    btnAdd.setBounds(40, 250, 150, 25);
    btnAdd.addActionListener(new ThemNhaCungCapController(this));
    frame.getContentPane().add(btnAdd);
    
    JLabel lblDsNcc = new JLabel("Danh sach nha cung cap : ");
    lblDsNcc.setFont(new Font("Dialog", Font.BOLD, 25));
    lblDsNcc.setBounds(30, 350, 500, 40);
    frame.add(lblDsNcc);
    
    bangNhaCungCap = new MyPanel();
    frame.getContentPane().add(bangNhaCungCap);
    
    JButton btnBack = new JButton("Back");
    btnBack.setFont(font);
    btnBack.setBounds(320, 250, 150, 25);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();        
      }
    });
    frame.getContentPane().add(btnBack);
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }

  public JTextField getTxtAddress() {
    return txtAddress;
  }

  public void setTxtAddress(JTextField txtAddress) {
    this.txtAddress = txtAddress;
  }

  public JTextField getTxtEmail() {
    return txtEmail;
  }

  public void setTxtEmail(JTextField txtEmail) {
    this.txtEmail = txtEmail;
  }

  public JTextField getTxtPhoneNo() {
    return txtPhoneNo;
  }

  public void setTxtPhoneNo(JTextField txtPhoneNo) {
    this.txtPhoneNo = txtPhoneNo;
  }

}
