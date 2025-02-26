package gui;

import javax.swing.*;

import backend.Item;
import backend.MoneyBox;
import backend.Record;
import backend.RegularVendo;
import backend.SpecialVendo;
import backend.VendingMachine;

import java.awt.event.*;
import java.awt.*;

public class MaintenancePanel extends JPanel implements ActionListener {

    JLabel lSell, lNonSell, lCreate, lMoney, lSlot;
    
    JPanel mainteCard;
    CardLayout mainteCardLayout;
    JPanel pSellable, pNonSellableCreated, pMoneySlot;

    JPanel moneyPanel, slotPanel;
    JLabel one, five, ten, twenty, fifty, hundred, twoHun, fiveHun, thou; 
    JButton[] bAddMoney = new JButton[9];
    JSpinner[] moneySpinner = new JSpinner[9];
    SpinnerModel[] moneyModel = new SpinnerModel[9];

    String[] sellableItems;
    JComboBox[] itemSell = new JComboBox[8];

    JSpinner[] sellSpinners = new JSpinner[10];
    SpinnerModel[] sellModel = new SpinnerModel[10];
    JButton[] restockSell = new JButton[10];
    JButton[] priceSell = new JButton[10];
    JTextField[] sellTextF = new JTextField[10];

    JSpinner[] nonSellSpinners = new JSpinner[8];
    SpinnerModel[] nonSellModel = new SpinnerModel[8];
    JButton[] restockNonSell = new JButton[8];
    JButton[] priceNonSell = new JButton[8];
    JTextField[] nonSellTextF = new JTextField[8];

    JSpinner[] createdSpinners = new JSpinner[3];
    SpinnerModel[] createdModel = new SpinnerModel[3];
    JButton[] restockCreated = new JButton[3];
    JButton[] priceCreated = new JButton[3];
    JTextField[] createdTextF = new JTextField[3];

    JButton sell, nonCre, monSlo;
    JButton regularB, specB, collectB, recordB;

    VendingMachine vendo;

    JComboBox[] slots = new JComboBox[8];
    Item[] slotItems = new Item[8];
    int[] slotQuantity = new int[8];

    Font money = new Font ("Courier Bold",  Font.BOLD, 19);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
    Font font3 = new Font("Monospaced Bold", Font.BOLD, 21);

    private final String indent = "                 ";

    public MaintenancePanel(VendingMachine vendo) {

        this.vendo = vendo;

        setLayout(null);
        setBounds(10,10,715,820);
        setBackground(Color.LIGHT_GRAY);

        mainteCard = new JPanel(new CardLayout());
        mainteCard.setBounds(5, 10, 705, 580);
        mainteCardLayout = (CardLayout) mainteCard.getLayout();

        pSellable = new JPanel();
        pSellable.setBounds(0, 0, 705, 580);
        pSellable.setBackground(Color.WHITE);
        pSellable.setLayout(null); 
        pSellable.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lSell = new JLabel("Sellable Items");
        lSell.setBounds(270, 20, 200, 20);
        lSell.setFont(font3);
        lSell.setBackground(Color.LIGHT_GRAY);
        lSell.setHorizontalTextPosition(JLabel.CENTER);

        pSellable.add(lSell);

        for (int i = 0; i < 10; i++) {
                
            JLabel name = new JLabel(RegularVendo.sellableItems[i].getName());
            name.setBounds(20, 60+(50*i), 200, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(190, 60+(50*i), 60, 30);
            spinner.setFocusable(false);
            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            
            sellModel[i] = value;

            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);
            
            sellSpinners[i] = spinner;
            
            JButton restock = new JButton("Restock");
            restock.setBounds(270, 60+(50*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockSell[i] = restock;

            JLabel php = new JLabel("Php:");
            php.setBounds(420, 60+(50*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setText(Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            newPr.setBounds(460, 60+(50*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            sellTextF[i] = newPr;

            JButton price = new JButton("Set Price");
            price.setBounds(585, 60+(50*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceSell[i] = price;

            pSellable.add(name);    
            pSellable.add(spinner);
            pSellable.add(restock);
            pSellable.add(php);
            pSellable.add(newPr);
            pSellable.add(price);
        }

        mainteCard.add(pSellable, "Sellable");

        pNonSellableCreated = new JPanel();
        pNonSellableCreated.setBounds(0, 0, 705, 580);
        pNonSellableCreated.setBackground(Color.WHITE);
        pNonSellableCreated.setLayout(null);
        pNonSellableCreated.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lNonSell = new JLabel("Non - Sellable Items");
        lNonSell.setBounds(270, 20, 200, 20);
        lNonSell.setFont(font2);
        lNonSell.setBackground(Color.LIGHT_GRAY);
        lNonSell.setHorizontalTextPosition(JLabel.CENTER);

        pNonSellableCreated.add(lNonSell);

        for (int i = 0; i < 8; i++) {

            JLabel name = new JLabel(SpecialVendo.nonSellableItems[i].getName());
            name.setBounds(20, 50+(40*i), 200, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(190, 50+(40*i), 60, 30);
            spinner.setFocusable(false);

            nonSellModel[i] = value;

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            nonSellSpinners[i] = spinner;

            JButton restock = new JButton("Restock");
            restock.setBounds(270, 50+(40*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockNonSell[i] = restock;
            
            JLabel php = new JLabel("Php:");
            php.setBounds(420, 50+(40*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setText(Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            newPr.setBounds(460, 50+(40*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            nonSellTextF[i] = newPr;

            JButton price = new JButton("Set Price");
            price.setBounds(585, 50+(40*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceNonSell[i] = price;

            pNonSellableCreated.add(name);
            pNonSellableCreated.add(spinner);
            pNonSellableCreated.add(restock);
            pNonSellableCreated.add(php);
            pNonSellableCreated.add(newPr);
            pNonSellableCreated.add(price);
        }

        lCreate = new JLabel("Created Items");
        lCreate.setBounds(300, 400, 250, 20);
        lCreate.setFont(font2);
        lCreate.setBackground(Color.LIGHT_GRAY);
        lCreate.setHorizontalTextPosition(JLabel.CENTER);

        pNonSellableCreated.add(lCreate);
        
        for (int i = 0; i < 3; i++) {

            JLabel name = new JLabel(SpecialVendo.createdItems[i].getName());
            name.setBounds(20, 440+(40*i), 200, 30);
            name.setBackground(Color.LIGHT_GRAY);
            name.setFont(font2);

            SpinnerModel value = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(190, 440+(40*i), 60, 30);
            spinner.setFocusable(false);

            createdModel[i] = value;

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            createdSpinners[i] = spinner;

            JButton restock = new JButton("Restock");
            restock.setBounds(270, 440+(40*i), 100 , 30);
            restock.setFocusable(false);
            restock.setBorder(BorderFactory.createRaisedBevelBorder());
            restock.setBackground(Color.DARK_GRAY);
            restock.setForeground(Color.WHITE);
            restock.setFont(font2);
            restock.addActionListener(this);

            restockCreated[i] = restock;
            
            JLabel php = new JLabel("Php:");
            php.setBounds(420, 440+(40*i), 50, 30);
            php.setBackground(Color.LIGHT_GRAY);
            php.setFont(font2);

            JTextField newPr = new JTextField();
            newPr.setText(Integer.toString(SpecialVendo.createdItems[i].getPrice()));
            newPr.setBounds(460, 440+(40*i), 100, 30);
            newPr.setBackground(Color.LIGHT_GRAY);
            newPr.setHorizontalAlignment(JTextField.CENTER);
            newPr.setFont(font2);

            createdTextF[i] = newPr;

            JButton price = new JButton("Set Price");
            price.setBounds(585, 440+(40*i), 100, 30);
            price.setFocusable(false);
            price.setBorder(BorderFactory.createRaisedBevelBorder());
            price.setBackground(Color.DARK_GRAY);
            price.setForeground(Color.WHITE);
            price.setFont(font2);
            price.addActionListener(this);

            priceCreated[i] = price;

            pNonSellableCreated.add(name);
            pNonSellableCreated.add(spinner);
            pNonSellableCreated.add(restock);
            pNonSellableCreated.add(php);
            pNonSellableCreated.add(newPr);
            pNonSellableCreated.add(price);
        }

        mainteCard.add(pNonSellableCreated, "NonSellCreated");

        pMoneySlot = new JPanel();
        pMoneySlot.setBounds(0, 0, 705, 580);
        pMoneySlot.setBackground(Color.WHITE);
        pMoneySlot.setLayout(null);
        pMoneySlot.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        moneyPanel = new JPanel();
        moneyPanel.setBounds(10,10, 340, 560);
        moneyPanel.setBackground(Color.WHITE);
        moneyPanel.setLayout(null);
        moneyPanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lMoney = new JLabel("Money Box");
        lMoney.setBounds(110, 10, 100, 20);
        lMoney.setFont(font2);
        lMoney.setBackground(Color.LIGHT_GRAY);
        lMoney.setHorizontalTextPosition(JLabel.CENTER);

        moneyPanel.add(lMoney);

        one = new JLabel("(1)");
        one.setFont(money);
        one.setBounds(20, 60, 100, 20);

        five = new JLabel("(5)");
        five.setFont(money);
        five.setBounds(20, 110, 100, 20);

        ten = new JLabel("(10)");
        ten.setFont(money);
        ten.setBounds(20, 160, 100, 20);    

        twenty = new JLabel("(20)");
        twenty.setFont(money);
        twenty.setBounds(20, 210, 100, 20);

        fifty = new JLabel("[ 50 ]");
        fifty.setFont(money);
        fifty.setBounds(20, 260, 100, 20);

        hundred = new JLabel("[ 100 ]");
        hundred.setFont(money);
        hundred.setBounds(20, 310, 100, 20);

        twoHun = new JLabel("[ 200 ]");
        twoHun.setFont(money);
        twoHun.setBounds(20, 360,100, 20);
        
        fiveHun = new JLabel("[ 500 ]");
        fiveHun.setFont(money);
        fiveHun.setBounds(20, 410, 100, 20);

        thou = new JLabel("[ 1000 ]");
        thou.setFont(money);
        thou.setBounds(20,460,100, 20);

        moneyPanel.add(one);
        moneyPanel.add(five);
        moneyPanel.add(ten);
        moneyPanel.add(twenty);
        moneyPanel.add(fifty);
        moneyPanel.add(hundred);
        moneyPanel.add(twoHun);
        moneyPanel.add(fiveHun);
        moneyPanel.add(thou);

        for (int i = 0; i < 9; i++) {

            SpinnerModel value = new SpinnerNumberModel(0,  vendo.getMoneyCalc().getVendoMoney().getDenominations()[i].getQuantity(), 99, 1);
            JSpinner spinner = new JSpinner(value);       
            spinner.setBounds(120, 60+(50*i), 80, 30);
            spinner.setFocusable(false);

            moneyModel[i] = value;

            spinner.setEditor(new JSpinner.DefaultEditor(spinner)); 
            JComponent editor = spinner.getEditor();
            ((JSpinner.DefaultEditor)editor).getTextField().setFocusable(false);

            moneySpinner[i] = spinner;

            JButton add = new JButton("Add");
            add.setBounds(220, 60+(50*i), 100 , 30);
            add.setFocusable(false);
            add.setBorder(BorderFactory.createRaisedBevelBorder());
            add.setBackground(Color.DARK_GRAY);
            add.setForeground(Color.WHITE);
            add.setFont(font2);
            add.addActionListener(this);

            bAddMoney[i] = add;

            moneyPanel.add(spinner);
            moneyPanel.add(add);
        }
        
        pMoneySlot.add(moneyPanel);

        slotPanel = new JPanel();
        slotPanel.setBounds(355,10, 340, 560);
        slotPanel.setBackground(Color.WHITE);
        slotPanel.setLayout(null);
        slotPanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));

        lSlot = new JLabel("Item Slots");
        lSlot.setBounds(120, 10, 100, 20);
        lSlot.setFont(font2);
        lSlot.setBackground(Color.LIGHT_GRAY);
        lSlot.setHorizontalTextPosition(JLabel.CENTER);

        slotPanel.add(lSlot);

        String[] sellableItems = new String[11];
        sellableItems[0] = "Empty";

        for(int i = 1; i <= 10; i++) {
            sellableItems[i] = RegularVendo.sellableItems[i-1].getName();
        }

        for (int i = 0; i < 8; i++) {

            JLabel slot = new JLabel("Slot " + (i+1));
            slot.setBounds(20, 80+(50*i), 100, 30);
            slot.setBackground(Color.LIGHT_GRAY);
            slot.setFont(font2);

            JComboBox items = new JComboBox(sellableItems);
            items.setBounds(120, 80+(50*i), 200, 30);
            items.setFont(font2);
            items.setEditable(false);
            items.setFocusable(false);
            items.addActionListener(this);

            slots[i] = items;

            slotPanel.add(slot);
            slotPanel.add(items);

        }

        pMoneySlot.add(slotPanel);

        mainteCard.add(pMoneySlot, "MonSlo");

        sell = new JButton("Sellable Items");
        sell.setBounds(40, 600, 200, 40);
        sell.setFocusable(false);
        sell.setBackground(Color.WHITE);
        sell.setBorder(BorderFactory.createRaisedBevelBorder());
        sell.setFont(font2);
        sell.addActionListener(this);

        nonCre = new JButton("Non-Sellable Items");
        nonCre.setBounds(260, 600, 200, 40);
        nonCre.setFocusable(false);
        nonCre.setBackground(Color.WHITE);
        nonCre.setBorder(BorderFactory.createRaisedBevelBorder());
        nonCre.setFont(font2);
        nonCre.addActionListener(this);

        monSlo = new JButton("Vending Settings");
        monSlo.setBounds(480, 600, 200, 40);
        monSlo.setFocusable(false);
        monSlo.setBackground(Color.WHITE);
        monSlo.setBorder(BorderFactory.createRaisedBevelBorder());
        monSlo.setFont(font2);
        monSlo.addActionListener(this);

        collectB = new JButton ("Collect Money");
        collectB.setBounds(40, 680, 300, 50);
        collectB.setFont(font3);
        collectB.setFocusable(false);
        collectB.setBackground(Color.WHITE);
        collectB.setBorder(BorderFactory.createRaisedBevelBorder());
        collectB.addActionListener(this);

        recordB = new JButton ("Print Records");
        recordB.setBounds(40, 740, 300,50);
        recordB.setFont(font3);
        recordB.setFocusable(false);
        recordB.setBackground(Color.WHITE);
        recordB.setBorder(BorderFactory.createRaisedBevelBorder());
        recordB.addActionListener(this);

        regularB = new JButton("Regular Vending Machine");
        regularB.setBounds(380, 680, 300, 50);
        regularB.setFont(font2);
        regularB.setFocusable(false);
        regularB.setBackground(Color.WHITE);
        regularB.setBorder(BorderFactory.createRaisedBevelBorder());
        regularB.addActionListener(this);

        specB = new JButton("Special Vending Machine");
        specB.setBounds(380, 740, 300, 50);
        specB.setFont(font2);
        specB.setFocusable(false);
        specB.setBackground(Color.WHITE);
        specB.setBorder(BorderFactory.createRaisedBevelBorder());
        specB.addActionListener(this);

        mainteCardLayout.show(mainteCard, "MonSlo");

        add(mainteCard);
        add(sell);
        add(nonCre);
        add(monSlo);

        add(collectB);
        add(recordB);
        add(regularB);
        add(specB);
    
    }

    public void updateStockValue () {

        for (int i = 0; i < 10; i++) {

            ((SpinnerNumberModel)sellModel[i]).setMinimum(RegularVendo.sellableItems[i].getStock().size());
            sellModel[i].setValue(RegularVendo.sellableItems[i].getStock().size());

            if (i < 8) {
                ((SpinnerNumberModel)nonSellModel[i]).setMinimum(SpecialVendo.nonSellableItems[i].getStock().size());
                nonSellModel[i].setValue(SpecialVendo.nonSellableItems[i].getStock().size());
            }

            if (i < 3) {
                ((SpinnerNumberModel)createdModel[i]).setMinimum(SpecialVendo.createdItems[i].getStock().size());
                createdModel[i].setValue(SpecialVendo.createdItems[i].getStock().size());
   
            }

            if (i < 9) {
                moneySpinner[i].setValue(vendo.getMoneyCalc().getVendoMoney().getCash(i).getQuantity());
                ((SpinnerNumberModel)moneyModel[i]).setMinimum(vendo.getMoneyCalc().getVendoMoney().getCash(i).getQuantity());
            }
        }
    }

    private boolean priceVerify (String price) {
        
        if(price.matches("^\\d+$")) {

            JDialog message = new JDialog();
            message.setTitle("Notice: ");
            message.setSize(new Dimension(200, 80));
            message.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            message.setLocationRelativeTo(null);

            JLabel label = new JLabel("Price Updated!");
            label.setBackground(new Color(0xEEEEEE));
            label.setHorizontalAlignment(JLabel.CENTER);
            message.addWindowFocusListener(new WindowFocusListener() {
                public void windowGainedFocus(WindowEvent e) {
                }
                public void windowLostFocus(WindowEvent e) {
                    message.dispose();
                }
            });

            message.add(label);
            message.setVisible(true);
            return true;
        }
        
        JOptionPane.showMessageDialog(null, "Invalid Price Input!", "Error", JOptionPane.INFORMATION_MESSAGE, null);
        return false;
    }

    private void printDialog() {
        JDialog message = new JDialog();
        message.setTitle("Notice: ");
        message.setSize(new Dimension(200, 80));
        message.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        message.setLocationRelativeTo(null);

        JLabel label = new JLabel("Stock Updated!");
        label.setBackground(new Color(0xEEEEEE));
        label.setHorizontalAlignment(JLabel.CENTER);
        message.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {
            }
            public void windowLostFocus(WindowEvent e) {
                message.dispose();
            }
        });

        message.add(label);
        message.setVisible(true);
    }

    private String printRecords (Record[] sell, Record[] nonSell, Record[] create) {

        String s = "", ns = "", cr = "";
        String in = "                               ";
        String message = "\t\tRecords \n\n" + 
                        "Item\t\tStart Inventory\tEnding Inventory\t    Quantity Sold\n\n";

        for (int i = 0; i < 10; i++) {
            String a = sell[i].getItem().getName();
            a += in.substring(0, in.length() - a.length());
            a += "\t\t" + Integer.toString(sell[i].getStartingInventory());
            a += "\t\t" + Integer.toString(sell[i].getItem().getStock().size());
            a += "\t\t" + sell[i].getSold() + "\n";
            s += a;

            if (i < 8) {
                String b = nonSell[i].getItem().getName();
                b += in.substring(0, in.length() - b.length());
                b += "\t\t" + Integer.toString(nonSell[i].getStartingInventory());
                b += "\t\t" + Integer.toString(nonSell[i].getItem().getStock().size());
                b += "\t\t" + sell[i].getSold() + "\n";
                ns += b;
            }

            if (i < 3) {
                String c = create[i].getItem().getName();
                c += in.substring(0, in.length() - c.length());
                c += "\t\t" + Integer.toString(create[i].getStartingInventory());
                c += "\t\t" + Integer.toString(create[i].getItem().getStock().size());
                c += "\t\t" + sell[i].getSold() + "\n";
                cr += c;
            }
        }

        message += s + "\n" + ns + "\n" + cr + "\n";

        return message;
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == sell) {
            mainteCardLayout.show(mainteCard, "Sellable");
            updateStockValue();
        }
        if (e.getSource() == nonCre) {
            mainteCardLayout.show(mainteCard, "NonSellCreated");
            updateStockValue();
        }
        if (e.getSource() == monSlo){
             mainteCardLayout.show(mainteCard, "MonSlo");
             updateStockValue();
        }
        if (e.getSource() == regularB || e.getSource() == specB) {
            mainteCardLayout.show(mainteCard, "MonSlo");
            updateStockValue();
        }
        if (e.getSource() == collectB) {
            MoneyBox profit = vendo.getMoneyCalc().getVendoMoney();
            String message = "\tProfit: \n\n" +
                            " Value:   \tQuantity:   \tTotal:  \n\n";

            JTextArea text = new JTextArea();
            text.setEditable(false);
            text.setFocusable(false);
            text.setFont(font2);
            text.setBackground(new Color(0xEEEEEE));
            text.setSize(new Dimension(300, 300));

            for (int i = 0; i < 9; i++) {
                if (profit.getDenominations()[i].getQuantity() != 0) {
                    String a = Integer.toString(profit.getDenominations()[i].getValue());
                    a += indent.substring(0, indent.length() - a.length());
                    String b = Integer.toString(profit.getDenominations()[i].getQuantity());
                    b += indent.substring(0, indent.length() - b.length());
                    message += " " + a + "\t" + b + "\t" + profit.getDenominations()[i].getTotal() + "\n";

                    ((SpinnerNumberModel)moneyModel[i]).setMinimum(0);
                    moneySpinner[i].setValue(0);
                }
            }
            
            String total = Integer.toString( vendo.getMoneyCalc().retrieveProfit());
            message += "\n\tTotal:          Php: " + total;
            text.setText(message);

            JOptionPane.showMessageDialog(null, text, "Payment Return", JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() == recordB) {
            
            Record[] sellable = vendo.getRegular().getSellableRecords();
            Record[] nonSellable = vendo.getSpecial().getNonSellRecords();
            Record[] created = vendo.getSpecial().getCreatedRecords();

            String total;
            int amount = 0;

            JTextArea text = new JTextArea();
            text.setEditable(false);
            text.setFocusable(false);
            text.setFont(font2);
            text.setBackground(new Color(0xEEEEEE));
            text.setSize(new Dimension(300, 300));

            String message = printRecords(sellable, nonSellable, created);

            amount = vendo.getTotalSales();
            total = Integer.toString(amount);
            
            message += "\n" + "\tTotal: " + total;
            text.setText(message);

            JOptionPane.showMessageDialog(null, text, "Transaction Records", JOptionPane.PLAIN_MESSAGE);
        }
        

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == restockSell[i]) {

                vendo.restockSellable((Integer)sellSpinners[i].getValue() - RegularVendo.sellableItems[i].getStock().size(), i);

                vendo.getRegular().getSellableRecords()[i].setStartingInventory();
                vendo.getRegular().getSellableRecords()[i].resetSoldAmount();
                vendo.getRegular().getSellableRecords()[i].setSold(0);

                ((SpinnerNumberModel)sellModel[i]).setMinimum(RegularVendo.sellableItems[i].getStock().size());

                printDialog();  
               
            }
            if (e.getSource() == priceSell[i]) {

                if(priceVerify(sellTextF[i].getText())) 
                    vendo.setSellabeItemPrice(Integer.parseInt(sellTextF[i].getText()), i);
                else
                    sellTextF[i].setText(Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            }
        }
        
        for (int i = 0; i < 8; i++) {
            if (e.getSource() == restockNonSell[i]) {

                vendo.restockNonSellable((Integer)nonSellSpinners[i].getValue() - SpecialVendo.nonSellableItems[i].getStock().size(), i);

                vendo.getSpecial().getNonSellRecords()[i].setStartingInventory();
                vendo.getSpecial().getNonSellRecords()[i].resetSoldAmount();
                vendo.getSpecial().getNonSellRecords()[i].setSold(0);

                ((SpinnerNumberModel)nonSellModel[i]).setMinimum(SpecialVendo.nonSellableItems[i].getStock().size());

                printDialog();

            }
            if (e.getSource() == priceNonSell[i]) {

                if(priceVerify(nonSellTextF[i].getText())) 
                    vendo.setNonSellabeItemPrice(Integer.parseInt(nonSellTextF[i].getText()), i);
                else 
                    nonSellTextF[i].setText(Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            }
        }

        for (int i = 0; i < 3; i++) {
            if (e.getSource() == restockCreated[i]) {
    
                if (vendo.restockCreatedItems((Integer)createdSpinners[i].getValue() - SpecialVendo.createdItems[i].getStock().size(), i)) {

                    vendo.getSpecial().getCreatedRecords()[i].setStartingInventory();
                    vendo.getSpecial().getCreatedRecords()[i].resetSoldAmount();
                    vendo.getSpecial().getCreatedRecords()[i].setSold(0);
                    
                    ((SpinnerNumberModel)createdModel[i]).setMinimum(SpecialVendo.createdItems[i].getStock().size());
                    
                    updateStockValue();
                    printDialog();
                }
                else {
                    createdModel[i].setValue(SpecialVendo.createdItems[i].getStock().size());
                    JOptionPane.showMessageDialog(null, "Not enough Ingredients to Restock", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == priceCreated[i]) {

                if(priceVerify(createdTextF[i].getText())) 
                    vendo.setCreatedItemPrice(Integer.parseInt(createdTextF[i].getText()), i);
                else 
                    createdTextF[i].setText(Integer.toString(SpecialVendo.createdItems[i].getPrice()));
            }
        }

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bAddMoney[i]) {
                vendo.getMoneyCalc().getVendoMoney().setDenom(i, (int)moneySpinner[i].getValue());
                ((SpinnerNumberModel)moneyModel[i]).setMinimum( vendo.getMoneyCalc().getVendoMoney().getCash(i).getQuantity());
                
                JDialog message = new JDialog();
                message.setTitle("Notice: ");
                message.setSize(new Dimension(200, 80));
                message.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                message.setLocationRelativeTo(null);

                JLabel label = new JLabel("Money Quantity Updated!");
                label.setBackground(new Color(0xEEEEEE));
                label.setHorizontalAlignment(JLabel.CENTER);

                message.addWindowFocusListener(new WindowFocusListener() {
                    public void windowGainedFocus(WindowEvent e) {
                    }
                    public void windowLostFocus(WindowEvent e) {
                        message.dispose();
                    }
                });

                message.add(label);
                message.setVisible(true);
            }
        }
        
        for (int i = 0; i < 8; i++) {
            if (e.getSource() == slots[i]) {
                if (slots[i].getSelectedIndex() == 0) {
                    vendo.getRegular().getSlotsItem()[i] = null;
                }
                else
                    vendo.addItem(i, slots[i].getSelectedIndex() - 1);
            }
        }
    }
}   
