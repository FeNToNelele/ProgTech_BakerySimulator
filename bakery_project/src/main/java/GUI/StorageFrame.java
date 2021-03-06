package GUI;

import Bakeries.ABakery;
import Bakeries.FruitBreadBakery;
import Bakeries.SeedyBreadBakery;
import Bakeries.WhiteBreadBakery;
import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Strategies.LogAdd;
import Storage.Strategies.LogError;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;;
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
    private JScrollPane scrllpnData;

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
                            refreshTable();
                        } catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        catch (BreadAlreadyExistsException e) {
                            System.out.println("You cannot bake the same bread twice!");
                        }
                        break;
                    case "FruitBread":
                        bakery = new FruitBreadBakery(new FruitBread(), userId);
                        initializeObservers(bakery);
                        try {
                            bakery.bake(amount);
                            refreshTable();
                        }
                        catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        catch (BreadAlreadyExistsException e) {
                            System.out.println("You cannot bake the same bread twice!");
                        }
                        break;
                    case "SeedyBread":
                        bakery = new SeedyBreadBakery(new SeedyBread(), userId);
                        initializeObservers(bakery);
                        try {
                            bakery.bake(amount);
                            refreshTable();
                        }
                        catch (IOException e) {
                            System.out.println("Could not create log file.");
                        }
                        catch (BreadAlreadyExistsException e) {
                            System.out.println("You cannot bake the same bread twice!");
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
        initTable();

        DefaultTableModel defaultTableModel = (DefaultTableModel)tblData.getModel();
        setTitle("Storage");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        breadCombo.addItem("WhiteBread");
        breadCombo.addItem("FruitBread");
        breadCombo.addItem("SeedyBread");
    }

    private void initTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblData.getModel();
        tblData.setModel(new DefaultTableModel(
                getStorageDataAsJaggedArray(),
                new String[] {"Id", "Name", "Price"}
        ));
        defaultTableModel.setRowCount(0);
    }

    private void refreshTable() {
        initTable();
    }


    private String[][] getStorageDataAsJaggedArray() {
        String[][] dataFromTable = getTableData(tblData);
        String[][] data = new String[bakery.storage.getProducts().size()][];
        List<ABread> products = bakery.storage.getProducts();
        for (int i = 0; i < products.size(); i++) {
            ABread bread = products.get(i);
            data[i] = new String[]{ Integer.toString(bread.getId()), bread.getName(), Integer.toString(bread.getPrice()) };
        }
        String[][] finData = Stream.concat( Arrays.stream( dataFromTable ), Arrays.stream( data ) ).toArray( String[][]::new );
        return finData;
    }


    private String[][] getTableData (JTable table) {
        TableModel dtm = table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        String[][] tableData = new String[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++) {
            for (int j = 0; j < nCol; j++) {
                tableData[i][j] = dtm.getValueAt(i, j).toString();
            }
        }
        return tableData;
    }
}
