package GUI;

import Breads.ABread;
import Breads.Classes.FruitBread;
import Breads.Classes.SeedyBread;
import Breads.Classes.WhiteBread;

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

    private ButtonGroup btngrpType = new ButtonGroup();

    public BakeBreadFrame() throws HeadlessException {
        setContentPane(bakeBreadPanel);
        setTitle("Give order");
        setSize(350, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE?
        setVisible(true);

        btngrpType.add(rdbtnWhiteBread);
        btngrpType.add(rdbtnFruitBread);
        btngrpType.add(rdbtnSeedyBread);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start abstract factory
                int amount;
                try {
                    amount = Integer.parseInt(spnrAmount.getValue().toString());
                    if (amount < 0) {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
                    lblNotification.setText("The amount must be greater than 0.");
                    return;
                }

                ABread prototype;
                switch (Integer.parseInt(spnrAmount.getValue().toString())) {
                    case 0:
                        prototype = new WhiteBread(1);
                        break;
                    case 1:
                        prototype = new FruitBread(1);
                        break;
                    case 2:
                        prototype = new SeedyBread(1);
                        break;
                }


            }
        });
    }
}
