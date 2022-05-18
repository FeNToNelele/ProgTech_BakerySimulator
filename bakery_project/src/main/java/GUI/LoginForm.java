package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
//import java.sql.DriverManager;

public class LoginForm extends JFrame {
    private JLabel lblLogin;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblPasswd;
    private JButton btnLogin;
    private JPasswordField pfPasswd;
    private JPanel loginPanel;
    private JLabel lblNotification;

    public LoginForm() {
        setContentPane(loginPanel);
        setTitle("Login");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] userIndex = login();

                try {
                    MenuFrame menuFrame = new MenuFrame(Integer.parseInt(userIndex[0]));
                    lblNotification.setText("Login was successful.");
                }
                catch (NumberFormatException ex) {
                    lblNotification.setText("Wrong credentials. Please try again.");
                }
            }
        });
    }

    private String[] login() {
        String[] actualUserIndex = new String[1];
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/bakery";
        try {
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String email = tfEmail.getText().toString();
            String password = String.valueOf(pfPasswd.getPassword());

            String query = "select * from users where email = '" + email + "' and password = '" + password + "' ";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.isBeforeFirst()) {
                System.out.println("Successful login.");
                rs.next();
                System.out.println(rs.getString(1));

                actualUserIndex[0] = rs.getString(1);
                st.close();
            } else {
                System.out.println("Login was not successful.");
                st.close();
            }
        } catch (Exception ex) {
            System.err.println("An error occoured while logging in.");
            System.err.println(ex.getMessage());
        }
        finally {
            return actualUserIndex;
        }
    }
}
