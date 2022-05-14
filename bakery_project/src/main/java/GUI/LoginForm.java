package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

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

        //Itt van az aktuális user indexe eltárolva!!!
        String[] actualUserIndex = new String[1];

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // create our mysql database connection
                    String myDriver = "com.mysql.jdbc.Driver";
                    String myUrl = "jdbc:mysql://localhost:3306/bakery";
                    //Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    // our SQL SELECT query.
                    // if you only need a few columns, specify them by name instead of using "*"
                    //String query = "SELECT * FROM users";

                    String email = tfEmail.getText().toString();
                    String password = String.valueOf(pfPasswd.getPassword());

                    String query = "select * from users where email = '" + email + "' and password = '" + password + "' ";

                    // create the java statement
                    Statement st = conn.createStatement();

                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);

                    // iterate through the java resultset
                    if (rs.isBeforeFirst()) {
                        System.out.println("siker");
                        rs.next();
                        System.out.println(rs.getString(1));
                        actualUserIndex[0] = rs.getString(1);
                        MenuFrame menuFrame = new MenuFrame(Integer.parseInt(actualUserIndex[0]));
                    } else {
                        System.out.println("nem siker");
                    }
                    st.close();
                } catch (Exception ex) {
                    System.err.println("Got an exception! ");
                    System.err.println(ex.getMessage());
                }
            }
        });
    }


}
