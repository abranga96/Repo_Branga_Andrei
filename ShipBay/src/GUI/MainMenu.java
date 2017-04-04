/*
 * Created by JFormDesigner on Tue Jan 10 16:46:19 EET 2017
 */

package GUI;

import java.awt.event.*;
import CompartmentPackage.CargoCompartment;
import ShipBay.ShipBay;
import ShipPackage.Ship;

import java.awt.*;
import javax.swing.*;

/**
 * @author Andrei Branga
 */
public class MainMenu extends JFrame {
    ShipBay shipBay;
    public MainMenu(ShipBay shipBay) {
        initComponents();
        this.shipBay=shipBay;
    }

    private void button1MouseClicked(MouseEvent e) {
        NewCargoShip form=new NewCargoShip(shipBay);
        form.setVisible(true);
        this.dispose();
    }

    private void button2MouseClicked(MouseEvent e) {
        textArea1.setText("");
        for (Ship s:shipBay.shipList
                ) {textArea1.setText(textArea1.getText()+System.lineSeparator()+s.getName());

        }
    }

    private void button3MouseClicked(MouseEvent e) {
        label2.setText(String.valueOf(shipBay.getProfit()));
    }

    private void button4MouseClicked(MouseEvent e) {
        NewPassShip f=new NewPassShip(shipBay);
        f.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Andrei Branga
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("ADD CARGO SHIP");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(25, 20, 185, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("List Ships");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(485, 20, 125, button2.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(410, 60, 265, 235);

        //---- label1 ----
        label1.setText("Profit:");
        contentPane.add(label1);
        label1.setBounds(45, 235, 45, 20);

        //---- label2 ----
        label2.setText(">>>>>><<<<<<");
        contentPane.add(label2);
        label2.setBounds(85, 235, 100, 20);

        //---- button3 ----
        button3.setText("Get ShipBay Profit");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(50, 260, 150, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText("ADD PASSENGER SHIP");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(30, 65, 180, button4.getPreferredSize().height);

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
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private JLabel label2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
