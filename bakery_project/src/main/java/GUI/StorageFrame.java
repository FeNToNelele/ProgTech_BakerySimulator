package GUI;

import javax.swing.*;

public class StorageFrame extends JFrame {
    private JPanel storagePanel;
    private JTable tableStorage;

    public StorageFrame() {
        setContentPane(storagePanel);
        setTitle("Storage");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE?
        setVisible(true);
    }
}
