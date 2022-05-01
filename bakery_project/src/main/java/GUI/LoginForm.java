package GUI;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JLabel lblLogin;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblPasswd;
    private JButton btnLogin;
    private JPasswordField pfPasswd;
    private JPanel loginPanel;

    public LoginForm() {
        setContentPane(loginPanel);
        setTitle("Login");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
