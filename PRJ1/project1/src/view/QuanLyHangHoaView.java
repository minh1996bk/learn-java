package view;

import controller.CapNhatNhaCungCapController;
import controller.TimKiemSanPhamController;
import controller.XemThongTinSanPhamController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class QuanLyHangHoaView {

  private JFrame frame;
  private MyPanel panel;
  private JLabel lblName;
  private JTextField txtName;
  private JLabel lblProducer;
  private JTextField txtProducer;
  private JLabel lblRemainAmount;
  private JTextField txtRemainAmount;
  private JLabel lblSoldAmount;
  private JTextField txtSoldAmount;
  private JTextField txtCode;
  private JLabel lblCode;
  private JLabel lblProviderId;
  private JTextField txtProviderId;
  
  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public MyPanel getPanel() {
    return panel;
  }

  public void setPanel(MyPanel panel) {
    this.panel = panel;
  }

  public QuanLyHangHoaView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
      
    panel = new MyPanel();
    panel.setBounds(20, 250, 860, 400);
    frame.getContentPane().add(panel);
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(750, 730, 100, 30);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new QuanLyView();
      }
    
    });
    frame.getContentPane().add(btnBack);
    
    lblCode = new JLabel("Ma san pham");
    lblCode.setFont(new Font("Dialog", Font.BOLD, 15));
    lblCode.setBounds(30, 27, 150, 25);
    frame.getContentPane().add(lblCode);
    
    txtCode = new JTextField();
    txtCode.setBounds(200, 27, 200, 25);
    frame.getContentPane().add(txtCode);
    txtCode.setColumns(10);
    
    lblName = new JLabel("Ten san pham");
    lblName.setBounds(30, 75, 150, 25);
    lblName.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblName);
    
    txtName = new JTextField();
    txtName.setBounds(200, 75, 200, 25);
    txtName.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtName);
    
    lblProviderId = new JLabel("Ma nha cung cap");
    lblProviderId.setBounds(420, 27, 150, 25);
    lblProviderId.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblProviderId);
    
    txtProviderId = new JTextField();
    txtProviderId.setBounds(620, 27, 200, 25);
    txtProviderId.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtProviderId);
    
    lblProducer = new JLabel("Nha san xuat");
    lblProducer.setBounds(420, 75, 150, 25);
    lblProducer.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblProducer);
    
    txtProducer = new JTextField();
    txtProducer.setBounds(620, 75, 200, 25);
    txtProducer.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtProducer);
    
    lblRemainAmount = new JLabel("So luong hien co");
    lblRemainAmount.setBounds(30, 123, 150, 25);
    lblRemainAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblRemainAmount);
    
    txtRemainAmount = new JTextField();
    txtRemainAmount.setBounds(200, 123, 200, 25);
    txtRemainAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtRemainAmount);
    
    lblSoldAmount = new JLabel("So luong da ban");
    lblSoldAmount.setBounds(420, 123, 150, 25);
    lblSoldAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblSoldAmount);
    
    txtSoldAmount = new JTextField();
    txtSoldAmount.setBounds(620, 123, 200, 25);
    txtSoldAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtSoldAmount);
    
    JButton btnSearch = new JButton("Search");
    btnSearch.setBounds(30, 178, 150, 25);
    btnSearch.addActionListener(new TimKiemSanPhamController(this));
    btnSearch.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnSearch);
    
    JButton btnAddGoods = new JButton("Add goods");
    btnAddGoods.setBounds(230, 178, 150, 25);
    btnAddGoods.addActionListener(new TimKiemSanPhamController(this));
    btnAddGoods.setFont(new Font("Dialog", Font.BOLD, 15));
    btnAddGoods.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new ThemHangHoaView();
      }
    });
    frame.getContentPane().add(btnAddGoods);
    
    JButton btnAddProvider = new JButton("Add provider");
    btnAddProvider.setBounds(430, 178, 150, 25);
    btnAddProvider.setFont(new Font("Dialog", Font.BOLD, 15));
    btnAddProvider.addActionListener(new CapNhatNhaCungCapController());
    frame.getContentPane().add(btnAddProvider);
    
    JButton btnInfo = new JButton("Info");
    btnInfo.setBounds(630, 178, 150, 25);
    btnInfo.setFont(new Font("Dialog", Font.BOLD, 15));
    btnInfo.addActionListener(new XemThongTinSanPhamController(panel));
    frame.getContentPane().add(btnInfo);
    
  
  }

  public JTextField getTxtProviderId() {
    return txtProviderId;
  }

  public void setTxtProviderId(JTextField txtProviderId) {
    this.txtProviderId = txtProviderId;
  }

  public JTextField getTxtCode() {
    return txtCode;
  }

  public void setTxtCode(JTextField txtCode) {
    this.txtCode = txtCode;
  }

  public JLabel getLblName() {
    return lblName;
  }

  public void setLblName(JLabel lblName) {
    this.lblName = lblName;
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }

  public JLabel getLblProducer() {
    return lblProducer;
  }

  public void setLblProducer(JLabel lblProducer) {
    this.lblProducer = lblProducer;
  }

  public JTextField getTxtProducer() {
    return txtProducer;
  }

  public void setTxtProducer(JTextField txtProducer) {
    this.txtProducer = txtProducer;
  }

  public JLabel getLblPrice() {
    return lblRemainAmount;
  }

  public void setLblPrice(JLabel lblPrice) {
    this.lblRemainAmount = lblPrice;
  }

  public JTextField getTxtRemainamount() {
    return txtRemainAmount;
  }

  public void setTxtPrice(JTextField txtPrice) {
    this.txtRemainAmount = txtPrice;
  }

  public JLabel getLblRemainAmount() {
    return lblSoldAmount;
  }

  public void setLblRemainAmount(JLabel lblRemainAmount) {
    this.lblSoldAmount = lblRemainAmount;
  }

  public JTextField getTxtSoldAmount() {
    return txtSoldAmount;
  }

  public void setTxtRemainAmount(JTextField txtRemainAmount) {
    this.txtSoldAmount = txtRemainAmount;
  }
}
