/*
 * Created by JFormDesigner on Tue Jan 10 16:51:47 EET 2017
 */

package GUI;

import CarriablePackage.CargoItem;
import CompartmentPackage.CargoCompartment;
import ShipBay.ShipBay;
import ShipPackage.Ship;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Andrei Branga
 */
public class NewCargoShip extends JFrame {
    ShipBay shipBay;
    public NewCargoShip(ShipBay shipBay) {
        this.shipBay=shipBay;
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        Ship<CargoCompartment> cargoCompartmentShip=new Ship<CargoCompartment>(textArea4.getText());
        CargoItem cargoItem=new CargoItem(textArea1.getText(),Integer.parseInt(textArea2.getText()));
        for (int i = 0;i<Integer.parseInt(textArea3.getText());i++)
        {
            cargoCompartmentShip.addCompartment(new CargoCompartment(cargoItem));
        }
        for (int j=0; j<Integer.parseInt(textField1.getText()); j++)
        {
            shipBay.addShip(cargoCompartmentShip);
        }
        MainMenu form=new MainMenu(shipBay);
        form.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrei Branga
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        button1 = new JButton();
        label4 = new JLabel();
        textArea4 = new JTextArea();
        label5 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Cargo Item Name");
        contentPane.add(label1);
        label1.setBounds(0, 45, 110, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Cargo Item Profit");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(0, 75), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("How Many Items?");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(0, 110), label3.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(110, 45, 170, scrollPane1.getPreferredSize().height);
        contentPane.add(textArea2);
        textArea2.setBounds(110, 75, 168, 17);
        contentPane.add(textArea3);
        textArea3.setBounds(110, 110, 168, 17);

        //---- button1 ----
        button1.setText("ADD");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(125, 180, 130, button1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Ship Name");
        contentPane.add(label4);
        label4.setBounds(0, 10, 100, label4.getPreferredSize().height);
        contentPane.add(textArea4);
        textArea4.setBounds(110, 10, 168, 17);

        //---- label5 ----
        label5.setText("How Many compartments:");
        contentPane.add(label5);
        label5.setBounds(0, 140, 155, label5.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(175, 140, 100, textField1.getPreferredSize().height);

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
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton button1;
    private JLabel label4;
    private JTextArea textArea4;
    private JLabel label5;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
