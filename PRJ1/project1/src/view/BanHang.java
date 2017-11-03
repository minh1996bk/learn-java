package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BanHang {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang window = new BanHang();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BanHang() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbMaSP = new JLabel("MaSP");
		lbMaSP.setBounds(150, 70, 200, 25);
		lbMaSP.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lbMaSP);
		
		JTextField tfMaSP = new JTextField();
		tfMaSP.setBounds(350, 70, 320, 25);
		tfMaSP.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(tfMaSP);
		
		JLabel lbSoLuong = new JLabel("So Luong");
		lbSoLuong.setBounds(150, 130, 200, 25);
		lbSoLuong.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(lbSoLuong);
		
		JTextField tfSoLuong = new JTextField();
		tfSoLuong.setBounds(350, 130, 320, 25);
		tfSoLuong.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(tfSoLuong);
		
		JButton btThem = new JButton("Them");
		btThem.setBounds(150, 230, 100, 25);
		btThem.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(btThem);
		
		JButton btInHoaDon = new JButton("In");
		btInHoaDon.setBounds(150, 650, 100, 25);
		btInHoaDon.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(btInHoaDon);
		
		JPanel pnBangInHoaDon = new MyPanel();
		pnBangInHoaDon.setBounds(150, 280, 600, 320);
		pnBangInHoaDon.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(pnBangInHoaDon);
		
		
		
		
		
		 
		JPanel pnBangHoaDon = new MyPanel();
	}

}
