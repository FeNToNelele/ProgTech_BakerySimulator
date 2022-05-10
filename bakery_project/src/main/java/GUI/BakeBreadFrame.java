package GUI;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import javax.swing.AbstractButton;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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


    public BakeBreadFrame() throws HeadlessException {
        setContentPane(bakeBreadPanel);
        setTitle("Give order");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE?
        setVisible(true);


        breadCombo.addItem("WhiteBread");
        breadCombo.addItem("FruitBread");
        breadCombo.addItem("Seedy Bread");

        ArrayList<WhiteBread> WhiteList = new ArrayList<WhiteBread>();
        ArrayList<FruitBread> FruitList = new ArrayList<FruitBread>();
        ArrayList<SeedyBread> SeedyList = new ArrayList<SeedyBread>();



        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent bakeStart) {
                System.out.println("Belép a factoryba");
                //Start abstract factory
                int amount;
                int ActualIndexInt;
                String ActualIndexString;
                try {
                    amount = Integer.parseInt(spnrAmount.getValue().toString());
                    System.out.println(amount);
                    if (amount < 0) {
                        throw new Exception();
                    }
                    ABread prototype;
                    String selectedBread = breadCombo.getSelectedItem().toString();
                    switch (selectedBread) {
                        case "WhiteBread":
                            ActualIndexString = WhiteList.get(WhiteList.size()-1).toString();
                            ActualIndexInt = Integer.parseInt(ActualIndexString);
                            amount = amount+ActualIndexInt;
                            for (int i = ActualIndexInt; i < amount; i++) {
                                prototype = new WhiteBread(i);
                                WhiteList.add((WhiteBread) prototype);

                            }
                            for (WhiteBread element : WhiteList){
                                System.out.print(element.getId()+"\n");
                            }
                            break;
                        case "FruitBread":
                            ActualIndexString = FruitList.get(FruitList.size()-1).toString();
                            ActualIndexInt = Integer.parseInt(ActualIndexString);
                            amount = amount+ActualIndexInt;
                            for (int i = ActualIndexInt; i < amount; i++) {
                                prototype = new FruitBread(i);
                                FruitList.add((FruitBread) prototype);

                            }
                            for (FruitBread element : FruitList){
                                System.out.print(element.getId()+"\n");
                            }
                            break;
                        case "SeedyBread":
                            ActualIndexString = SeedyList.get(SeedyList.size()-1).toString();
                            ActualIndexInt = Integer.parseInt(ActualIndexString);
                            amount = amount+ActualIndexInt;
                            for (int i = ActualIndexInt; i < amount; i++) {
                                prototype = new SeedyBread(i);
                                SeedyList.add((SeedyBread) prototype);

                            }
                            for (SeedyBread element : SeedyList){
                                System.out.print(element.getId()+"\n");
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
}
