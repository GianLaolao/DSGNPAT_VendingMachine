package gui;
import javax.swing.*;

import backend.Initialize;
import backend.RegularVendo;
import backend.SpecialVendo;
import backend.VendingMachine;

import java.awt.event.*;
import java.awt.*;

public class VendoGUI extends JFrame implements ActionListener{
    
    JFrame frame;
    ImageIcon iconReg = new ImageIcon("Images/vendo.png");
    ImageIcon iconBurg = new ImageIcon("Images/burger.png");
    ImageIcon iconWrench =  new ImageIcon("Images/mainte.png");

    JButton mainte, regular, special, cancel, dispense; 

    CardLayout cardLayout;
    JPanel card;

    RegularPanel regPanel;
    SpecialPanel specPanel;
    MaintenancePanel maintePanel;

    JLabel totalLabel;
    JPanel paymentHolder;
    PaymentPanel paymentPanel;
    JTextField payment, total;
    JTextArea screen;

    Font s = new Font("Dialog Plain", Font.PLAIN, 13);
    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
 
    Initialize initialize = new Initialize();
    VendingMachine vendo = new VendingMachine();

    public VendoGUI (int choice){ 
        
        RegularVendo.sellableItems = initialize.initialize("src/ItemSellable.txt", "sellable");
        SpecialVendo.nonSellableItems = initialize.initialize("src/ItemNonSell.txt", "nonSellable");
        SpecialVendo.createdItems = initialize.initializeCreated();


        vendo.getRegular().setRecords(initialize.createRecord(RegularVendo.sellableItems));
        vendo.getSpecial().setNonSellRecords(initialize.createRecord(SpecialVendo.nonSellableItems));
        vendo.getSpecial().setCreatedRecords(initialize.createRecord(SpecialVendo.createdItems));

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,870);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLocationRelativeTo(null);
        
        paymentHolder = new JPanel();
        paymentHolder.setBounds(440,30, 280, 700);
        paymentHolder.setLayout(null);
        paymentHolder.setBackground(Color.LIGHT_GRAY);
        
        screen = new JTextArea();
        screen.setBounds(20, 0, 250, 300);
        screen.setEditable(false);
        screen.setFont(s);
        screen.setFocusable(false);
        screen.setBackground(Color.DARK_GRAY);
        screen.setForeground(Color.WHITE);
        screen.setText("\t        Order: \n\n");

        totalLabel = new JLabel("Total: ");
        totalLabel.setBounds(20, 310, 100, 20);
        totalLabel.setFont(font1);
        totalLabel.setBackground(Color.LIGHT_GRAY);

        total = new JTextField();
        total.setBounds(130, 305, 140, 30);
        total.setFont(font1);
        total.setEditable(false);
        total.setFocusable(false);
        total.setText("0");
        total.setHorizontalAlignment(JTextField.CENTER);

        payment = new JTextField("Php 0.00");
        payment.setBounds(20, 350, 250, 40);
        payment.setEditable(false);
        payment.setFocusable(false);  
        payment.setFont(font1);
        payment.setHorizontalAlignment(JTextField.CENTER);
        payment.setBackground(Color.DARK_GRAY);
        payment.setForeground(Color.WHITE);

        mainte = new JButton("Maintenance");
        special = new JButton("Special Vending Machine");
        dispense = new JButton("Dispense");
        cancel = new JButton("Cancel");

        dispense.setBounds(20, 630, 250, 30);
        dispense.setFont(font1);
        dispense.setFocusable(false);
        dispense.setBackground(Color.WHITE);
        dispense.setBorder(BorderFactory.createRaisedBevelBorder());
        dispense.addActionListener(this);

        cancel.setBounds(20, 670, 250, 30);
        cancel.setFont(font1);
        cancel.setFocusable(false);
        cancel.setBackground(Color.WHITE);
        cancel.setBorder(BorderFactory.createRaisedBevelBorder());
        cancel.addActionListener(this);

        mainte.setBounds(50, 750, 320, 60);
        mainte.setFont(font1);
        mainte.setFocusable(false);
        mainte.setBackground(Color.WHITE);
        mainte.setBorder(BorderFactory.createRaisedBevelBorder());
        mainte.addActionListener(this);

        special.setBounds(395, 750, 320, 60);
        special.setFont(font1);
        special.setFocusable(false);
        special.setBackground(Color.WHITE);
        special.setBorder(BorderFactory.createRaisedBevelBorder());
        special.addActionListener(this);
        
        regular = new JButton("Regular Vending Machine");
        regular.setBounds(395, 750, 320, 60);
        regular.setFont(font1);
        regular.setFocusable(false);
        regular.setBackground(Color.WHITE);
        regular.setBorder(BorderFactory.createRaisedBevelBorder());
        regular.addActionListener(this);

        regPanel = new RegularPanel(cancel, special, mainte, screen, total, vendo);
        specPanel = new SpecialPanel(cancel, regular, mainte, screen, total, vendo);
        maintePanel = new MaintenancePanel(vendo);
        paymentPanel = new PaymentPanel(payment, total, screen, dispense, cancel, vendo);

        card = new JPanel(new CardLayout());
        card.setBounds(30, 10, 400, 720);
        card.add(regPanel, "Regular");
        card.add(specPanel, "Special");
        cardLayout = (CardLayout) card.getLayout();

        maintePanel.regularB.addActionListener(this);
        maintePanel.specB.addActionListener(this);
    
        switch(choice) {
            case 0:
                frame.add(card);   
                cardLayout.show(card, "Regular");
                frame.setTitle("Regular Vending Machine");
                frame.add(special);
                frame.add(mainte);   
                frame.setIconImage(iconReg.getImage());
                frame.add(paymentHolder);  
                break;
            case 1:
                frame.add(card);   
                cardLayout.show(card, "Special");
                frame.setTitle("Special Vending Machine");
                frame.add(regular);
                frame.add(mainte);   
                frame.setIconImage(iconBurg.getImage());
                frame.add(paymentHolder);  
                break;
            case 2: 
                frame.add(maintePanel);
                frame.setTitle("Vending Machine Maintenance");
                frame.setIconImage(iconWrench.getImage());
                break;
        }

        paymentHolder.add(paymentPanel);
        paymentHolder.add(payment);
        paymentHolder.add(screen);
        paymentHolder.add(totalLabel);
        paymentHolder.add(total);
        paymentHolder.add(dispense);
        paymentHolder.add(cancel);

        frame.setVisible(true);
    }

    public void cancel() {
        screen.setText("\t        Order: \n\n");
        total.setText("0");
        payment.setText("Php: 0.00");
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == dispense) {
            for (Component panel : card.getComponents()) {
                if (panel.isVisible() && panel.equals(regPanel)) {
                        regPanel.dispense();
                        paymentPanel.dispense();
                }
                else if (panel.isVisible() && panel.equals(specPanel)) {
                    if (specPanel.dispense()) 
                        paymentPanel.dispense();
                    else
                        paymentPanel.returnChange();
                        cancel();
                }
            }
             
        }
        if (e.getSource() == cancel) {
            payment.setText("Php 0.00");
            cancel();
        }   
        if (e.getSource() == regular) {

            regPanel.updateSlots();

            frame.revalidate();
            frame.repaint();

            frame.setTitle("Regular Vending Machine");
            frame.remove(regular);
            cardLayout.show(card, "Regular");
            frame.add(special);

            payment.setText("Php: 0.00");

            frame.revalidate();
            frame.repaint();

            cancel();

            frame.setIconImage(iconReg.getImage());
        }
        if (e.getSource() == special) {
            
            specPanel.update();

            frame.revalidate();
            frame.repaint();

            frame.setTitle("Special Vending Machine");
            frame.remove(special);
            cardLayout.show(card, "Special");
            frame.add(regular);

            payment.setText("Php: 0.00");

            frame.revalidate();
            frame.repaint();

            cancel();

            frame.setIconImage(iconBurg.getImage());
        }
        if (e.getSource() == maintePanel.regularB){

            frame.remove(maintePanel);

            frame.revalidate();
            frame.repaint();

            frame.add(paymentHolder);
            frame.add(card);
            cardLayout.show(card, "Regular");
            frame.add(mainte);
            frame.add(special);

            regPanel.updateSlots();
            payment.setText("Php: 0.00");

            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconReg.getImage());
        }
        if (e.getSource() == maintePanel.specB) {
        
            frame.remove(maintePanel);

            frame.revalidate();
            frame.repaint();

            frame.add(card);
            frame.add(paymentHolder);
            frame.add(card);
            cardLayout.show(card, "Special");
            frame.add(mainte);
            frame.add(regular);

            specPanel.update();
            payment.setText("Php: 0.00");

            frame.revalidate();
            frame.repaint();

            frame.setIconImage(iconBurg.getImage());
        }
        if (e.getSource() == mainte){

            frame.setTitle("Vending Machine Maintenance");
            frame.remove(paymentHolder);

            if(frame.isAncestorOf(regPanel)) {
                frame.remove(regular);
                frame.remove(special);
            }
            if(frame.isAncestorOf(specPanel)) {
                frame.remove(regular);
                frame.remove(special);
            }
            frame.remove(card);
            frame.remove(mainte);

            frame.revalidate();
            frame.repaint();

            frame.add(maintePanel);

            maintePanel.updateStockValue();
            payment.setText("Php: 0.00");

            frame.revalidate();
            frame.repaint();

            cancel();
    
            frame.setIconImage(iconWrench.getImage());
        } 

    }
}

