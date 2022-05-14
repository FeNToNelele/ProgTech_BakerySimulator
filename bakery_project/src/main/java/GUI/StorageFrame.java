package GUI;

import Breads.ABread;
import Storage.Classes.Storage;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class StorageFrame extends JFrame {
    private JPanel storagePanel;

    String[] columns = new String[]{
            "Id", "Name", "Price"
    };
    Object[][] data = {
            {1, "Fehér kenyér", 200},
            {2, "Gyümölcskenéyr", 320}
    };

    private JButton btnBakeBreads;
    private JTable tblData;
    private JScrollPane scrollPaneTblData;

    private int userId;

    private Storage storage = new Storage();

    public StorageFrame(int userId) {
        this.userId = userId;
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
                BakeBreadFrame bakeBreadFrame = new BakeBreadFrame(userId);
            }
        });
    }

}
