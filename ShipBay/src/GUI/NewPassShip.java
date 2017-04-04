/*
 * Created by JFormDesigner on Tue Jan 10 17:40:41 EET 2017
 */

package GUI;

import java.awt.event.*;

import CarriablePackage.Passenger;
import CompartmentPackage.PassengerCompartment;
import ShipBay.ShipBay;
import ShipPackage.Ship;
import com.intellij.codeHighlighting.Pass;

import java.awt.*;
import javax.swing.*;

/**
 * @author Andrei Branga
 */
public class NewPassShip extends JFrame {
    ShipBay shipBay;
    public NewPassShip(ShipBay shipBay) {
        initComponents();
        this.shipBay=shipBay;
    }

    private void button1MouseClicked(MouseEvent e) {
        Ship<PassengerCompartment> passengerCompartmentShip=new Ship<PassengerCompartment>(textField1.getText());
        for (int i=0; i<Integer.parseInt(textField3.getText());i++)
        {
            PassengerCompartment p=new PassengerCompartment();
            for (int j=0; j<Integer.parseInt(textField2.getText());j++)
            {
                p.addPassenger(new Passenger());
            }
            passengerCompartmentShip.addCompartment(p);
        }
        shipBay.addShip(passengerCompartmentShip);
        MainMenu f=new MainMenu(shipBay);
        f.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrei Branga
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Passengers per compartment:");
        contentPane.add(label1);
        label1.setBounds(10, 45, 205, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Number of compartments:");
        contentPane.add(label2);
        label2.setBounds(10, 70, 160, 15);

        //---- button1 ----
        button1.setText("ADD SHIP");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(90, 145, 150, button1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Ship Name:");
        contentPane.add(label3);
        label3.setBounds(10, 15, 150, label3.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(180, 10, 130, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(180, 40, 130, 24);
        contentPane.add(textField3);
        textField3.setBounds(180, 70, 130, 24);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Andrei Branga
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
