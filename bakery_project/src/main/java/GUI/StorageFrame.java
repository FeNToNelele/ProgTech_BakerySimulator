package GUI;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import Storage.Classes.Storage;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Interfaces.IObserver;
import Storage.Strategies.LogAdd;
import Storage.Strategies.LogError;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import Storage.Classes.Storage;
import Storage.Strategies.LogRemove;


public class StorageFrame extends JFrame {
    private JPanel storagePanel;
    private JButton btnBakeBreads;
    private JTable tblData;
    private JLabel lblAmount;
    private JSpinner spnrAmount;
    private JButton btnStart;
    private JLabel lblType;
    private JLabel lblNotification;
    private JComboBox breadCombo;

    private int userId;

    static Storage storage = new Storage();

    public StorageFrame(int userId) {
        this.userId = userId;
        initializeObservers();
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

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent bakeStart) {
                System.out.println("Enters the factory");
                //Start abstract factory
                int amount;
                try {
                    amount = Integer.parseInt(spnrAmount.getValue().toString());
                    if (amount < 0) {
                        System.out.println("Error");
                        throw new Exception();
                    }
                    System.out.println("the amount of bread: " + amount);
                    ABread prototype;
                    String selectedBread = breadCombo.getSelectedItem().toString();

                    switch (selectedBread) {
                        case "WhiteBread":
                            System.out.println("Baking white Bread");
                            for (int i = 0; i < amount; i++) {
                                prototype = new WhiteBread();
                                try {
                                    storage.addBread(prototype);
                                    storage.notifyObservers(
                                            storage.getObservers().stream()
                                                    .filter(x -> x instanceof LogAdd).toList(), userId, prototype.getId()
                                    );
                                } catch (BreadAlreadyExistsException e) {
                                    e.printStackTrace();
                                    storage.notifyObservers(storage.getObservers().stream().filter(x -> x instanceof LogError).toList(),userId,prototype.getId());
                                }
                            }
                            break;
                        case "FruitBread":
                            System.out.println("Baking white Bread");
                            for (int i = 0; i < amount; i++) {
                                prototype = new FruitBread();
                                try {
                                    storage.addBread(prototype);
                                } catch (BreadAlreadyExistsException e) {
                                    e.printStackTrace();
                                    storage.notifyObservers(storage.getObservers().stream().filter(x -> x instanceof LogError).toList(),userId,prototype.getId());
                                }
                            }
                            break;
                        case "SeedyBread":
                            System.out.println("Baking white Bread");
                            for (int i = 0; i < amount; i++) {
                                prototype = new SeedyBread();
                                try {
                                    storage.addBread(prototype);
                                } catch (BreadAlreadyExistsException e) {
                                    e.printStackTrace();
                                    storage.notifyObservers(storage.getObservers().stream().filter(x -> x instanceof LogError).toList(),userId,prototype.getId());
                                }
                            }
                            break;
                    }
                }
                catch (Exception ex) {
                    lblNotification.setText("The amount must be greater than 0.");
                    return;
                }
            }
        });
    }
    public static void initializeObservers() {
        storage.registerObserver(new LogAdd());
        storage.registerObserver(new LogRemove());
        storage.registerObserver(new LogError());
    }
}
