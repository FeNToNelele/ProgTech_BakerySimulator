package GUI;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;
import javax.swing.AbstractButton;
import java.util.Enumeration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent bakeStart) {
                System.out.println("Belép a factoryba");
                //Start abstract factory
                int amount;
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
                            prototype = new WhiteBread(1);
                            //ide kenyer sütéshez majd kéne valami for loop hogy a megadott számba süsse vagy ilyesmi
                            System.out.println("feher kenyer");
                            break;
                        case "FruitBread":
                            prototype = new FruitBread(1);
                            System.out.println("fruit kenyeret süt");
                            break;
                        case "SeedyBread":
                            prototype = new SeedyBread(1);
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
