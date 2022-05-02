package GUI;

import Breads.ABread;
import Storage.Classes.Storage;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorageFrame extends JFrame {
    private JPanel storagePanel;

    String[] columns = new String[] {
            "Id", "Name", "Price"
    };
    Object[][] data = {
            {1, "Fehér kenyér", 200},
            {2, "Gyümölcskenéyr", 320}
    };

    private JButton btnBakeBreads;
    private JTable tblData;
    private JScrollPane scrollPaneTblData;

    private Storage storage = new Storage();

    public StorageFrame() {
        setContentPane(storagePanel);

        scrollPaneTblData = new JScrollPane(tblData);
        tblData = new JTable(data, columns);
        JTableHeader jTableHeader = tblData.getTableHeader();
        jTableHeader.setVisible(true);

        setTitle("Storage");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btnBakeBreads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BakeBreadFrame bakeBreadFrame = new BakeBreadFrame();
            }
        });
    }
}
