package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AccountController;
import dao.AccountDao;
import model.Account;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogUser;
	private JTextField txtLogPass;
	private JTextField txtLogPass2;
	private JTextField txtKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame frame = new SignUpFrame();
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
	public SignUpFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 436, 263);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 25, 96, 38);
		contentPane_1.add(lblNewLabel_1);
		
		txtLogUser = new JTextField();
		txtLogUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLogUser.setColumns(10);
		txtLogUser.setBounds(158, 29, 181, 30);
		contentPane_1.add(txtLogUser);
		
		JLabel lblMtKhu_1 = new JLabel("Mật khẩu");
		lblMtKhu_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMtKhu_1.setBounds(10, 73, 96, 38);
		contentPane_1.add(lblMtKhu_1);
		
		txtLogPass = new JTextField();
		txtLogPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLogPass.setColumns(10);
		txtLogPass.setBounds(158, 77, 181, 30);
		contentPane_1.add(txtLogPass);
		
		JLabel lblNhpLiMt_1 = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhpLiMt_1.setBounds(10, 121, 138, 38);
		contentPane_1.add(lblNhpLiMt_1);
		
		txtLogPass2 = new JTextField();
		txtLogPass2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLogPass2.setColumns(10);
		txtLogPass2.setBounds(158, 125, 181, 30);
		contentPane_1.add(txtLogPass2);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKey.setBounds(10, 169, 138, 38);
		contentPane_1.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtKey.setColumns(10);
		txtKey.setBounds(158, 173, 181, 30);
		contentPane_1.add(txtKey);
		
		JButton btnngK = new JButton("Đăng kí");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtLogUser.getText();
				String pass = txtLogPass.getText();
				String pass2 = txtLogPass2.getText();
				String key = txtKey.getText();
				AccountController ac = new AccountController();
				if(ac.register(key) == 1 && pass.equals(pass2)) {
					Account a = new Account(user, pass);
					AccountDao.insert(a);
					SuccessDialog s = new SuccessDialog(SignUpFrame.this);
					s.setVisible(true);
				}else {
					FailureDialog f = new FailureDialog(SignUpFrame.this);
					f.setVisible(true);
					
				}
			}
		});
		btnngK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnngK.setBounds(218, 216, 121, 38);
		contentPane_1.add(btnngK);
		
		JButton btnNewButton = new JButton("< Quay lại");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(48, 217, 113, 36);
		contentPane_1.add(btnNewButton);
	}
}
