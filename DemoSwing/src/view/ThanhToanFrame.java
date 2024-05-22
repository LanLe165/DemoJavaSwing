package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import dao.OrderDAO;
import model.PhieuOrder;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ThanhToanFrame extends JFrame {

	DefaultTableModel tableModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCO;
	private JTextField priceCO;
	double thanhTien = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToanFrame frame = new ThanhToanFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public ThanhToanFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bàn: ");
		lblNewLabel_2.setBounds(10, 30, 55, 28);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JComboBox cbtable1 = new JComboBox();
		cbtable1.setBounds(206, 34, 71, 21);
		cbtable1.setModel(new DefaultComboBoxModel(new String[] {"Bàn 1", "Bàn 2", "Bàn 3", "Bàn 4", "Bàn 5", "Bàn 6", "Bàn 7", "Bàn 8", "Bàn 9", "Bàn 10"}));
		cbtable1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(cbtable1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 152, 877, 241);
		contentPane.add(scrollPane);
		
		tableCO = new JTable();
		tableCO.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn kh\u00E1ch h\u00E0ng", "M\u00F3n \u0103n/\u0110\u1ED3 u\u1ED1ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		tableCO.getColumnModel().getColumn(1).setPreferredWidth(87);
		tableCO.getColumnModel().getColumn(2).setPreferredWidth(110);
		scrollPane.setViewportView(tableCO);
		
		
		
		JLabel lblNewLabel = new JLabel("Giảm giá(%):");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(383, 30, 103, 28);
		contentPane.add(lblNewLabel);
		
		JComboBox discountCO = new JComboBox();
		discountCO.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		discountCO.setModel(new DefaultComboBoxModel(new String[] {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "60", "70", "80"}));
		discountCO.setBounds(496, 30, 70, 26);
		contentPane.add(discountCO);
		
		JLabel lblNewLabel_1 = new JLabel("Thành Tiền:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(383, 89, 94, 25);
		contentPane.add(lblNewLabel_1);
		
		priceCO = new JTextField();
		priceCO.setBounds(496, 84, 110, 28);
		contentPane.add(priceCO);
		priceCO.setColumns(10);
		
		JButton btnCO = new JButton("Thanh Toán");
		btnCO.setBounds(10, 89, 145, 34);
		btnCO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel = (DefaultTableModel) tableCO.getModel();
				showOrder(cbtable1.getSelectedItem().toString());
				OrderDAO od = new OrderDAO();
				ArrayList<PhieuOrder> listCO = new ArrayList<>();
				listCO = od.Find(cbtable1.getSelectedItem().toString());
				final double[] thanhTien = { 0.0 };
				listCO.forEach((PhieuOrder phieuOrder) -> {
					thanhTien[0] += phieuOrder.getGia() * phieuOrder.getSoLuong();
				});
				
				thanhTien[0] = thanhTien[0] - thanhTien[0] * (Integer.parseInt((String) discountCO.getSelectedItem()))/100;
				priceCO.setText(String.valueOf(thanhTien[0]));
			}
		});
		btnCO.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(btnCO);
		
	}
	private void showOrder(String ban){
		ArrayList<PhieuOrder> show = new ArrayList<>();
		OrderDAO od = new OrderDAO();
		show = od.Find(ban);
		
		tableModel.setRowCount(0);
		show.forEach((PhieuOrder) -> {
			tableModel.addRow(new Object[] {
				tableModel.getRowCount() + 1, PhieuOrder.getTenKhachHang(),  PhieuOrder.getMonAn_DoUong()
				, PhieuOrder.getSoLuong(),PhieuOrder.getGia()
		});
		});
	}
}
