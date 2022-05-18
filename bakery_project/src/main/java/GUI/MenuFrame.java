package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private JButton btnCheckStorage;
    private JPanel menuPanel;
    private JLabel lblWelcome;

    private int userId;
    public MenuFrame(int userId) {
        this.userId = userId;

        setContentPane(menuPanel);
        setTitle("Menu");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnCheckStorage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StorageFrame storageFrame = new StorageFrame(userId);
            }
        });
    }
}
