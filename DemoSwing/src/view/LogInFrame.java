package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame frame = new LogInFrame();
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
	public LogInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 63, 96, 38);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtUser.setBounds(121, 63, 181, 30);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMtKhu.setBounds(10, 115, 96, 38);
		contentPane.add(lblMtKhu);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(121, 115, 181, 30);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.AccountController.checkAccount(txtUser.getText(), txtPass.getText()) == 1){
					CafeFrame cf = new CafeFrame();
					cf.setVisible(true);
					
				}else {
					FailureDialog f = new FailureDialog(LogInFrame.this);
					f.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(45, 183, 121, 38);
		contentPane.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng kí");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame sg = new SignUpFrame();
				sg.setVisible(true);
			
			}
		});
		btnngK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnngK.setBounds(220, 183, 121, 38);
		contentPane.add(btnngK);
	}
}
