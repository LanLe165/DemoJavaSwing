package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.OrderDAO;
import model.PhieuOrder;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class CafeFrame extends JFrame {
	DefaultTableModel tableModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTable tblOrder;
	private JTextField txtPhone;
	private JTextField txtOrder;
	private JTextField txtAmount;
	private JTextField txtCost;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeFrame frame = new CafeFrame();
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
	private void showOrder(){
		ArrayList<PhieuOrder> show = new ArrayList<>();
		OrderDAO od = new OrderDAO();
		show = od.ShowAll();
		
		tableModel.setRowCount(0);
		show.forEach((PhieuOrder) -> {
			tableModel.addRow(new Object[] {
				tableModel.getRowCount() + 1, PhieuOrder.getTenKhachHang(), PhieuOrder.getBan(),
				PhieuOrder.getSoDienThoai(), PhieuOrder.getMonAn_DoUong(), PhieuOrder.getSoLuong(),
				PhieuOrder.getGia(), PhieuOrder.getNgay()
			});
		});
	}
	
	public CafeFrame() {
		
		setTitle("Manager Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 885, 415);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input Order's Information Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 304, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 36, 134, 25);
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtName.setBounds(216, 38, 215, 23);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Bàn: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 71, 55, 28);
		panel.add(lblNewLabel_2);
		
		JComboBox cbTable = new JComboBox();
		cbTable.setModel(new DefaultComboBoxModel(new String[] {"Bàn 1", "Bàn 2", "Bàn 3", "Bàn 4", "Bàn 5", "Bàn 6", "Bàn 7", "Bàn 8", "Bàn 9", "Bàn 10"}));
		cbTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbTable.setBounds(216, 75, 71, 21);
		panel.add(cbTable);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenKhachHang = txtName.getText();
				String ban1 = (String) cbTable.getSelectedItem();
				String soDienThoai = txtPhone.getText();
				String monAn_DoUong = txtOrder.getText();
				int soLuong = Integer.parseInt(txtAmount.getText()) ;
				double gia = Double.parseDouble(txtCost.getText());
				String ngay = txtDate.getText();
				
				PhieuOrder po = new PhieuOrder(tenKhachHang, ban1, soDienThoai, monAn_DoUong, soLuong, gia, ngay);
				
				OrderDAO od = new OrderDAO();
				od.Save(po);
				
				tableModel = (DefaultTableModel) tblOrder.getModel();
				showOrder();
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSave.setBounds(20, 351, 85, 29);
		panel.add(btnSave);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String defaultText = "";
				txtName.setText(defaultText);
				cbTable.setSelectedIndex(0);
				txtPhone.setText(defaultText);
				txtOrder.setText(defaultText);
				txtAmount.setText(defaultText);
				txtCost.setText(defaultText);
				txtDate.setText(defaultText);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnReset.setBounds(127, 351, 85, 29);
		panel.add(btnReset);
		
		JButton btnDelete = new JButton("DELETE BY TABLE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDAO od = new OrderDAO();
				
				tableModel = (DefaultTableModel) tblOrder.getModel();
				
				String ban = cbTable.getSelectedItem().toString();
				
				od.Delete(ban);
				
				tableModel = (DefaultTableModel) tblOrder.getModel();
				showOrder();
				}
			}
		);	
		
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDelete.setBounds(238, 351, 193, 29);
		panel.add(btnDelete);
		
		JButton btnFind = new JButton("FIND BY TABLE");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel = (DefaultTableModel) tblOrder.getModel();
				String ban = cbTable.getSelectedItem().toString();
				ArrayList<PhieuOrder> show = new ArrayList<>();
				OrderDAO od = new OrderDAO();
				show = od.Find(ban);
				
				tableModel.setRowCount(0);
				show.forEach((PhieuOrder) -> {
					tableModel.addRow(new Object[] {
						tableModel.getRowCount() + 1, PhieuOrder.getTenKhachHang(), PhieuOrder.getBan(),
						PhieuOrder.getSoDienThoai(), PhieuOrder.getMonAn_DoUong(), PhieuOrder.getSoLuong(),
						PhieuOrder.getGia(), PhieuOrder.getNgay()
					});
				});
			}
		});
		btnFind.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnFind.setBounds(440, 351, 182, 29);
		panel.add(btnFind);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 109, 134, 25);
		panel.add(lblNewLabel_1_1);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(216, 111, 215, 23);
		panel.add(txtPhone);
		
		JLabel lblNewLabel_1_2 = new JLabel("Món ăn/ Đồ uống:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(20, 158, 134, 25);
		panel.add(lblNewLabel_1_2);
		
		txtOrder = new JTextField();
		txtOrder.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtOrder.setColumns(10);
		txtOrder.setBounds(216, 158, 215, 23);
		panel.add(txtOrder);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số lượng:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(20, 203, 134, 25);
		panel.add(lblNewLabel_1_3);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtAmount.setColumns(10);
		txtAmount.setBounds(216, 205, 215, 23);
		panel.add(txtAmount);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giá: ");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(20, 251, 134, 25);
		panel.add(lblNewLabel_1_4);
		
		txtCost = new JTextField();
		txtCost.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCost.setColumns(10);
		txtCost.setBounds(216, 253, 215, 23);
		panel.add(txtCost);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày: ");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(20, 298, 134, 25);
		panel.add(lblNewLabel_1_5);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDate.setColumns(10);
		txtDate.setBounds(216, 300, 215, 23);
		panel.add(txtDate);
		
		JButton btnSort = new JButton("SORT");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDAO od = new OrderDAO();
				
				tableModel = (DefaultTableModel) tblOrder.getModel();
				ArrayList<PhieuOrder> listSort = new ArrayList<>();
				
				listSort = od.Sort();
				tableModel.setRowCount(0);
				listSort.forEach((PhieuOrder) -> {
					tableModel.addRow(new Object[] {
						tableModel.getRowCount() + 1, PhieuOrder.getTenKhachHang(), PhieuOrder.getBan(),
						PhieuOrder.getSoDienThoai(), PhieuOrder.getMonAn_DoUong(), PhieuOrder.getSoLuong(),
						PhieuOrder.getGia(), PhieuOrder.getNgay()
					});
				});
			}
		});
		btnSort.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSort.setBounds(638, 351, 85, 29);
		panel.add(btnSort);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel = (DefaultTableModel) tblOrder.getModel();
				showOrder();
			}
		});
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRefresh.setBounds(744, 351, 118, 29);
		panel.add(btnRefresh);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThanhToan.setBounds(537, 161, 171, 29);
		panel.add(btnThanhToan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 415, 885, 216);
		contentPane.add(scrollPane);
		
		tblOrder = new JTable();
		tblOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblOrder.setForeground(new Color(0, 0, 0));
		tblOrder.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn Kh\u00E1ch H\u00E0ng", "B\u00E0n", "SDT", "M\u00F3n \u0103n/ \u0110\u1ED3 u\u1ED1ng", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Ng\u00E0y"
			}
		));
		tblOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblOrder.getColumnModel().getColumn(2).setPreferredWidth(57);
		tblOrder.getColumnModel().getColumn(3).setPreferredWidth(104);
		tblOrder.getColumnModel().getColumn(4).setPreferredWidth(124);
		tblOrder.getColumnModel().getColumn(7).setPreferredWidth(88);
		scrollPane.setViewportView(tblOrder);
		
		tableModel = (DefaultTableModel) tblOrder.getModel();
		showOrder();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SAVE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
