package GUI;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import Storage.Classes.Storage;
import Storage.Exceptions.BreadAlreadyExistsException;
import Storage.Strategies.LogAdd;
import Storage.Strategies.LogError;
import Storage.Strategies.LogRemove;
import com.mysql.cj.log.Log;

import javax.swing.AbstractButton;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class BakeBreadFrame extends JFrame {
    private JLabel lblType;
    private JList lstType;
    private JLabel lblAmount;
    private JSpinner spnrAmount;
    private JButton btnStart;
    private JPanel bakeBreadPanel;
    private JRadioButton rdbtnWhiteBread;
    private JRadioButton rdbtnFruitBread;
    private JRadioButton rdbtnSeedyBread;
    private JLabel lblNotification;
    private JComboBox breadCombo;

    static Storage storage = new Storage();

    public BakeBreadFrame() throws HeadlessException {
        setContentPane(bakeBreadPanel);
        setTitle("Give order");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE?
        setVisible(true);


        breadCombo.addItem("WhiteBread");
        breadCombo.addItem("FruitBread");
        breadCombo.addItem("SeedyBread");


        initializeObservers();

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
                                } catch (BreadAlreadyExistsException e) {
                                    e.printStackTrace();
                                }

                            }
                            /*List<ABread> ActualBreads = storage.getProducts();
                            for (ABread element : ActualBreads){
                                System.out.println(element.getId()+"\n");
                            }

                            ActualIndexInt = storage.;
                            amount = amount+ActualIndexInt;
                            for (int i = ActualIndexInt; i < amount; i++) {
                                prototype = new WhiteBread();
                                try {
                                    storage.addBread(prototype);
                                }
                                catch (BreadAlreadyExistsException e){
                                    return;
                                }

                            }*/
                            /*for (WhiteBread element : WhiteList){
                                System.out.print(element.getId()+"\n");

                            }

                             */
                            System.out.println("----White Bread Index list----");
                            System.out.println("------------------------------");
                            break;
                        case "FruitBread":
                            System.out.println("Baking white Bread");
                            for (int i = 0; i < amount; i++) {
                                prototype = new FruitBread();
                                try {
                                    storage.addBread(prototype);
                                } catch (BreadAlreadyExistsException e) {
                                    e.printStackTrace();
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

    public void initializeObservers() {
        LogAdd logAdd = new LogAdd();
        LogRemove logRemove = new LogRemove();
        LogError logError = new LogError();
        storage.registerObserver(new LogAdd());
        storage.registerObserver(new LogRemove());
        storage.registerObserver(new LogError());
    }
}
