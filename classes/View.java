package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          View window = new View();
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
  public View() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLayout(new BorderLayout());
    
    ArrayList<SinhVien> arr = new ArrayList<>();
    arr.add(new SinhVien());
    arr.add(new SinhVien("minh",1));
    
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Name");
    model.addColumn("ID");
    model.setRowCount(0);
    for (SinhVien sv : arr) {
      Vector<Object> vec = new Vector<Object>();
      vec.add(sv.getId());
      vec.add(sv.getName());
      model.addRow(vec);
    }
    JTable jTable = new JTable(model);
    
    JScrollPane scr = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    frame.add(scr, BorderLayout.CENTER);
    
  }

}
