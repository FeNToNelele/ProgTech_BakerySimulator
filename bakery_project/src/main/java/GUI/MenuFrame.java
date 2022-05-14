package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MenuFrame extends JFrame {
    private JButton btnCheckStorage;
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
