package GUI;

import Bakeries.ABakery;
import Bakeries.FruitBreadBakery;
import Bakeries.SeedyBreadBakery;
import Bakeries.WhiteBreadBakery;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import Storage.Classes.Storage;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Strategies.LogAdd;
import Storage.Strategies.LogError;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;;
import Storage.Strategies.LogRemove;

public class StorageFrame extends JFrame {
    private JPanel storagePanel;
    private JTable tblData;
    private JSpinner spnrAmount;
    private JButton btnStart;
    private JLabel lblNotification;
    private JComboBox breadCombo;
    private JLabel lblType;
    private JLabel lblAmount;

    private int userId;
    private ABakery bakery;

    public StorageFrame(int userId) {
        this.userId = userId;
        bakery = new WhiteBreadBakery(new WhiteBread(), userId);
        initializeObservers(this.bakery);
        initializeGUI();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent bakeStart) {
                int amount = Integer.parseInt(spnrAmount.getValue().toString());
                if (amount < 0) {
                    System.out.println("Error, amount cannot be negative.");
                    lblNotification.setText("Amount cannot be negative.");
                };

                String selectedBread = breadCombo.getSelectedItem().toString();
                switch (selectedBread) {
                    case "WhiteBread":
                        bakery = new WhiteBreadBakery(new WhiteBread(), userId);
                        initializeObservers(bakery);
                        try {
                            bakery.bake(amount);
                        } catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        break;
                    case "FruitBread":
                        bakery = new FruitBreadBakery(new FruitBread(), userId);
                        //initializeObservers(bakery);
                        try {
                            bakery.bake(amount);
                        }
                        catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        break;
                    case "SeedyBread":
                        bakery = new SeedyBreadBakery(new SeedyBread(), userId);
                        //initializeObservers(bakery);
                        try {
                            bakery.bake(amount);
                        }
                        catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        break;
                }
            }
        });
    }
    public static void initializeObservers(ABakery bakery) {
        bakery.storage.registerObserver(new LogAdd());
        bakery.storage.registerObserver(new LogRemove());
        bakery.storage.registerObserver(new LogError());
    }

    private void initializeGUI() {
        setContentPane(storagePanel);
        tblData = new JTable();
        JTableHeader jTableHeader = tblData.getTableHeader();
        jTableHeader.setVisible(true);
        setTitle("Storage");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        breadCombo.addItem("WhiteBread");
        breadCombo.addItem("FruitBread");
        breadCombo.addItem("SeedyBread");
    }
}
