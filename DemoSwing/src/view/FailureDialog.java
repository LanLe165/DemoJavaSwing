package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FailureDialog extends JDialog {
    public FailureDialog(JFrame parent) {
        super(parent, "Thông báo", true);
        initComponents();
    }

    private void initComponents() {
        JLabel messageLabel = new JLabel("Thất bại!");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng hộp thoại khi nhấn OK
                // Hiển thị lại màn hình đăng nhập
                LogInFrame logInFrame = new LogInFrame();
                logInFrame.setVisible(true);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(messageLabel, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setSize(300, 150);
        setLocationRelativeTo(getParent());
    }
}