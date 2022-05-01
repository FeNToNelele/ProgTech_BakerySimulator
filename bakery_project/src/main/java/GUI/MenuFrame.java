package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private JButton btnCheckStorage;
    private JButton btnStartProducing;
    private JPanel menuPanel;

    public MenuFrame() {
        setContentPane(menuPanel);
        setTitle("Menu");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE?
        setVisible(true);
        btnCheckStorage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StorageFrame storageFrame = new StorageFrame();
            }
        });
    }
}
