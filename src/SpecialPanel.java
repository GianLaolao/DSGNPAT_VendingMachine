
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class SpecialPanel extends JPanel implements ActionListener {

    JLabel b, m, c, s, addOn;
    JRadioButton sesame, wheat, brioche;
    ButtonGroup breadGroup;
    JRadioButton beef, vegan, chicken;
    ButtonGroup meatGroup;
    JRadioButton american, cheddar, swiss, noC;
    ButtonGroup cheeseGroup;
    JRadioButton bbq, ket, mayo, thouIsl, noS;
    ButtonGroup sauceGroup;
    JRadioButton bacon, ham, egg, sausage, tomato, lettuce, pickle, onion;
    JPanel addOnPanel;
    JScrollPane scrollAddOn;

    JTextField sellField[] = new JTextField[10];
    JTextField nonSellField[] = new JTextField[8];
    JTextField createdField[] = new JTextField[3];

    JRadioButton[] sellable = new JRadioButton[10];
    JRadioButton[] nonSellable = new JRadioButton[8];

    JLabel[] sellLabels = new JLabel[10];
    JLabel[] nonSellLabels = new JLabel[8];
    JLabel[] createdLabels = new JLabel[3];

    JButton cancel, regular, mainte;
    JTextArea screen;
    JTextField total;

    ArrayList<Item> burger = new ArrayList<>();
    Item order[] = {null, null, null, null};
    ArrayList<Item> addOns = new ArrayList<>();

    VendingMachine vendo;

    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);
    
    private final String indent = "                             ";

    SpecialPanel(JButton cancel, JButton regular, JButton mainte, JTextArea screen, JTextField total, VendingMachine vendo) {  

        this.cancel = cancel;
        cancel.addActionListener(this);

        this.regular = regular;
        regular.addActionListener(this);

        this.mainte = mainte;
        mainte.addActionListener(this);

        this.total = total;
        this.screen = screen;
        this.vendo = vendo;

        b = new JLabel("Choose Bun:");
        b.setBounds(0,0, 400, 20);
        b.setFont(font2);
        b.setOpaque(true);
        b.setBackground(Color.LIGHT_GRAY);
        b.setHorizontalAlignment(JLabel.CENTER);

        m = new JLabel("Choose Meat:");
        m.setBounds(0, 120, 400, 20);
        m.setFont(font2);
        m.setOpaque(true);
        m.setBackground(Color.LIGHT_GRAY);
        m.setHorizontalAlignment(JLabel.CENTER);

        c = new JLabel("Choose Cheese:");
        c.setBounds(0, 240,400, 20);
        c.setFont(font2);
        c.setOpaque(true);
        c.setBackground(Color.LIGHT_GRAY);
        c.setHorizontalAlignment(JLabel.CENTER);

        s = new JLabel("Choose Sauce:");
        s.setBounds(0, 390, 400, 20);
        s.setFont(font2);
        s.setOpaque(true);
        s.setBackground(Color.LIGHT_GRAY);
        s.setHorizontalAlignment(JLabel.CENTER);

        addOn = new JLabel("Choose Add-ons:");
        addOn.setBounds(0, 570,400, 20);
        addOn.setFont(font2);
        addOn.setOpaque(true);
        addOn.setBackground(Color.LIGHT_GRAY);
        addOn.setHorizontalAlignment(JLabel.CENTER);
        
        sesame = new JRadioButton("Sesame Seed Bun");
        sesame.setFont(font2);
        sesame.setBounds(20, 30, 200, 20);
        sesame.setFocusable(false);
        sesame.setBackground(Color.white);
        sesame.addActionListener(this);

        wheat = new JRadioButton("Whole Wheat Bun");
        wheat.setFont(font2);
        wheat.setBounds(20, 60, 200, 20);
        wheat.setFocusable(false);
        wheat.setBackground(Color.white);
        wheat.addActionListener(this);

        brioche = new JRadioButton("Soft Brioche Bun");
        brioche.setFont(font2);
        brioche.setBounds(20, 90, 200,20);
        brioche.setFocusable(false);
        brioche.setBackground(Color.white);
        brioche.addActionListener(this);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            price.setBounds(240, 30+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            sellLabels[i] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 30+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i].getStock().size()));

            sellField[i] = stockTF;

            add(price);
            add(stockTF);
        }        

        breadGroup = new ButtonGroup();
        breadGroup.add(sesame);
        breadGroup.add(wheat);
        breadGroup.add(brioche);

        beef = new JRadioButton("Beef Patty");
        beef.setFont(font2);
        beef.setBounds(20, 150, 200, 20);
        beef.setFocusable(false);
        beef.setBackground(Color.white);
        beef.addActionListener(this);

        vegan = new JRadioButton("Plant Based Patty");
        vegan.setFont(font2);
        vegan.setBounds(20, 180, 200, 20);
        vegan.setFocusable(false);
        vegan.setBackground(Color.white);
        vegan.addActionListener(this);

        chicken = new JRadioButton("Crispy Chicken");
        chicken.setFont(font2);
        chicken.setBounds(20, 210, 200, 20);
        chicken.setFocusable(false);
        chicken.setBackground(Color.white);
        chicken.addActionListener(this);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(RegularVendo.sellableItems[i+3].getPrice()));
            price.setBounds(240, 150+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            sellLabels[i+3] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 150+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i+3].getStock().size()));

            sellField[i+3] = stockTF;

            add(price);
            add(stockTF);
        }        

        meatGroup = new ButtonGroup();
        meatGroup.add(beef);
        meatGroup.add(vegan);
        meatGroup.add(chicken);

        american = new JRadioButton("American Cheese");
        american.setFont(font2);
        american.setBounds(20, 270, 200, 20);
        american.setFocusable(false);
        american.setBackground(Color.white);
        american.addActionListener(this);

        cheddar = new JRadioButton("Cheddar Cheese");
        cheddar.setFont(font2);
        cheddar.setBounds(20, 300, 200, 20);
        cheddar.setFocusable(false);
        cheddar.setBackground(Color.white);
        cheddar.addActionListener(this);

        swiss = new JRadioButton("Swiss Cheese");
        swiss.setFont(font2);
        swiss.setBounds(20, 330, 200, 20);
        swiss.setFocusable(false);
        swiss.setBackground(Color.white);
        swiss.addActionListener(this);

        noC = new JRadioButton("No Cheese");
        noC.setFont(font2);
        noC.setBounds(20, 360, 300, 20);
        noC.setFocusable(false);
        noC.setBackground(Color.white);
        noC.addActionListener(this);

        for (int i = 0; i < 3; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i+4].getPrice()));
            price.setBounds(240, 270+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            nonSellLabels[i+4] = price;

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 270+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[i+4].getStock().size()));

            nonSellField[i+4] = stockTF;

            add(price);
            add(stockTF);
        }        
    
        cheeseGroup = new ButtonGroup();
        cheeseGroup.add(american);
        cheeseGroup.add(cheddar);
        cheeseGroup.add(swiss);
        cheeseGroup.add(noC);

        bbq = new JRadioButton("Barbeque Sauce");
        bbq.setFont(font2);
        bbq.setBounds(20, 420, 200, 20);
        bbq.setFocusable(false);
        bbq.setBackground(Color.white);
        bbq.addActionListener(this);

        ket = new JRadioButton("Tomato Ketchup");
        ket.setFont(font2);
        ket.setBounds(20, 450, 200, 20);
        ket.setFocusable(false);
        ket.setBackground(Color.white);
        ket.addActionListener(this);
        
        mayo = new JRadioButton("Mayonnaise");
        mayo.setFont(font2);
        mayo.setBounds(20, 480, 200, 20);
        mayo.setFocusable(false);
        mayo.setBackground(Color.white);
        mayo.addActionListener(this);

        thouIsl = new JRadioButton("Thousand Island");
        thouIsl.setFont(font2);
        thouIsl.setBounds(20, 510, 200, 20);
        thouIsl.setFocusable(false);
        thouIsl.setBackground(Color.white);
        thouIsl.addActionListener(this);

        noS = new JRadioButton("No Sauce");
        noS.setFont(font2);
        noS.setBounds(20, 540, 300, 20);
        noS.setFocusable(false);
        noS.setBackground(Color.white);
        noS.addActionListener(this);    

        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel(Integer.toString(i));
            price.setBounds(240, 420+(30*i), 80, 20);
            price.setFont(font2);
            price.setBackground(Color.WHITE);

            JTextField stockTF = new JTextField();
            stockTF.setBounds(340, 420+(30*i), 30, 20);
            stockTF.setEditable(false);
            stockTF.setFocusable(false);

            if (i == 0) {
                price.setText("Php: " + Integer.toString(SpecialVendo.nonSellableItems[7].getPrice()));
                stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[7].getStock().size()));
                nonSellField[7] = stockTF;
                nonSellLabels[7] = price;
            }      
            else  {
                price.setText("Php: " + Integer.toString(SpecialVendo.createdItems[i-1].getPrice()));
                stockTF.setText(Integer.toString(SpecialVendo.createdItems[i-1].getStock().size()));  
                createdField[i-1] = stockTF;
                createdLabels[i-1] = price;
            }

            add(price);
            add(stockTF);
        }        

        sauceGroup = new ButtonGroup();
        sauceGroup.add(bbq);
        sauceGroup.add(ket);
        sauceGroup.add(mayo);
        sauceGroup.add(thouIsl);
        sauceGroup.add(noS);

        addOnPanel = new JPanel();
        addOnPanel.setLayout(new GridLayout(8, 3));
        addOnPanel.setSize(new Dimension(400, 135));
        addOnPanel.setBackground(Color.WHITE);

        bacon = new JRadioButton("Crispy Bacon Strips");
        bacon.setFont(font2);
        bacon.setFocusable(false);
        bacon.setBackground(Color.white);
        bacon.addActionListener(this);

        ham = new JRadioButton("Sweet Smoked Ham");
        ham.setFont(font2);
        ham.setFocusable(false);
        ham.setBackground(Color.white);
        ham.addActionListener(this);

        egg = new JRadioButton("Sunny Side Up Egg");
        egg.setFont(font2);
        egg.setFocusable(false);
        egg.setBackground(Color.white);
        egg.addActionListener(this);

        sausage = new JRadioButton("Smoked Sausage");
        sausage.setFont(font2);
        sausage.setFocusable(false);
        sausage.setBackground(Color.white);
        sausage.addActionListener(this);

        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.sellableItems[i+6].getPrice()));
            price.setSize(new Dimension(80, 20));
            price.setFont(font2);
            price.setBackground(Color.WHITE);
            price.setHorizontalAlignment(JLabel.CENTER);

            sellLabels[i+6] = price;

            JTextField stockTF = new JTextField();
            stockTF.setSize(new Dimension(30, 20));
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(RegularVendo.sellableItems[i+6].getStock().size()));

            sellField[i+6] = stockTF;
        }

        tomato = new JRadioButton("Fresh Tomato Slices");
        tomato.setFont(font2);
        tomato.setFocusable(false);
        tomato.setBackground(Color.white);
        tomato.addActionListener(this);

        lettuce = new JRadioButton("Iceberg Lettuce");
        lettuce.setFont(font2);
        lettuce.setFocusable(false);
        lettuce.setBackground(Color.white);
        lettuce.addActionListener(this);

        pickle = new JRadioButton("Fresh Pickles");
        pickle.setFont(font2);
        pickle.setFocusable(false);
        pickle.setBackground(Color.white);
        pickle.addActionListener(this);

        onion = new JRadioButton("Sweet Red Onion");
        onion.setFont(font2);
        onion.setFocusable(false);
        onion.setBackground(Color.white);
        onion.addActionListener(this);    

        for (int i = 0; i < 4; i++) {
            JLabel price = new JLabel("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            price.setSize(new Dimension(80, 20));
            price.setFont(font2);
            price.setBackground(Color.WHITE);
            price.setHorizontalAlignment(JLabel.CENTER);

            nonSellLabels[i] = price;

            JTextField stockTF = new JTextField();
            stockTF.setSize(new Dimension(30, 20));
            stockTF.setEditable(false);
            stockTF.setFocusable(false);
            stockTF.setText(Integer.toString(SpecialVendo.nonSellableItems[i].getStock().size()));

            nonSellField[i] = stockTF;
        }
        
        addOnPanel.add(bacon);
        addOnPanel.add(sellLabels[6]);
        addOnPanel.add(sellField[6]);
        addOnPanel.add(ham);
        addOnPanel.add(sellLabels[7]);
        addOnPanel.add(sellField[7]);
        addOnPanel.add(egg);
        addOnPanel.add(sellLabels[8]);
        addOnPanel.add(sellField[8]);
        addOnPanel.add(sausage);
        addOnPanel.add(sellLabels[9]);
        addOnPanel.add(sellField[9]);
        addOnPanel.add(tomato);
        addOnPanel.add(nonSellLabels[0]);
        addOnPanel.add(nonSellField[0]);
        addOnPanel.add(lettuce);
        addOnPanel.add(nonSellLabels[1]);
        addOnPanel.add(nonSellField[1]);
        addOnPanel.add(pickle);
        addOnPanel.add(nonSellLabels[2]);
        addOnPanel.add(nonSellField[2]);
        addOnPanel.add(onion);
        addOnPanel.add(nonSellLabels[3]);
        addOnPanel.add(nonSellField[3]);

        scrollAddOn = new JScrollPane(addOnPanel);
        scrollAddOn.setBounds(0, 590, 400, 135);
        scrollAddOn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollAddOn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setBounds(20, 10, 400, 720);
        setBackground(Color.WHITE);
        setLayout(null);
        setBorder(BorderFactory.createLoweredBevelBorder());
        add(b);
        add(m);
        add(c);
        add(s);
        add(addOn);
        add(sesame);
        add(wheat);
        add(brioche);
        add(beef);
        add(vegan);
        add(chicken);
        add(american);
        add(cheddar);
        add(swiss);
        add(noC);
        add(bbq);
        add(ket);
        add(mayo);
        add(thouIsl);
        add(noS);
        add(scrollAddOn);

    }

    private void printProcess(){

        screen.setText( "\nPreparing Burger...\n\n");

        ArrayList<String> string = new ArrayList<>();

        if(order[0] != null) {        
            string.add("Toasting Buns...\n\n");
        }
        if (order[1] != null) {
            string.add("Grilling Patty...\n\n");
        }
        if (order[2] != null) {
            string.add("Melting Cheese...\n\n");
        }
        string.add("Assembling Burger...\n\n");
        if (order[3] != null) {
            string.add("Adding " + order[3].getName() + "\n\n");
        }
        if (addOns.size() != 0) {
            string.add("Adding add-ons...\n\n");
        }
        string.add("Dispensing Burger...\n\n");

        Timer delay = new Timer(500, new ActionListener() {
            private int i = 0;
            public void actionPerformed(ActionEvent e) {
             if (i < string.size()) {
                    screen.append(string.get(i));
                    i++;
                } else {
                    ((Timer) e.getSource()).stop();
                    printOrder();
                    clearButtons();
                }
            }
            
        });

        delay.start();
    }

    private void printScreen() {
        
        String textOrder = "\t        Order: \n\n" + "  Item\t\t            Price \n";
        int totalPrice = 0;
        for (int i = 0; i < 4; i++) {
            if (order[i] != null) {
                String string = order[i].getName();
                string += indent.substring(0, indent.length() - string.length());
                string = String.format("  %s \t            %d\n", string, order[i].getPrice());
                textOrder += string;
                totalPrice += order[i].getPrice();
            }   
        }

        textOrder += "\n  Add-Ons: \n";

        for (Item a : addOns) {
    
            String string = a.getName();
            string += indent.substring(0, indent.length() - string.length());
            string = String.format("  %s \t            %d\n", string, a.getPrice());
            textOrder += string;
            totalPrice += a.getPrice();
        } 

        total.setText(Integer.toString(totalPrice));
        screen.setText(textOrder);
    }

    private void printOrder() {

        JTextArea text = new JTextArea();
        int total = 0;
        int calories = 0;
        text.setEditable(false);
        text.setFocusable(false);
        text.setFont(font2);
        text.setBackground(new Color(0xEEEEEE));
        text.setSize(new Dimension(300, 300));

        String message = "\tOrder: \n\n";

        for (Item item : burger) {
            String a = item.getName();
            a += indent.substring(0, indent.length() - a.length());
            a += "\tPrice: " + item.getPrice() + "\n";
            a += "        Calories: " + item.getCalories() + "\n"; 
            message += a;
            total += item.getPrice();
            calories += item.getCalories();
        }       

        message += "\nTotal Calories: " + calories + "\n";
        message += "\n\tTotal Price: " + Integer.toString(total);
        text.setText(message);

        JOptionPane.showMessageDialog(null, text, "Burger", JOptionPane.PLAIN_MESSAGE);
    }

    public void update () {

        for (int i = 0; i < 10; i++) { 
            sellField[i].setText(Integer.toString(RegularVendo.sellableItems[i].getStock().size()));
            sellLabels[i].setText("Php: " + Integer.toString(RegularVendo.sellableItems[i].getPrice()));
            
            if(i < 8) {
                nonSellField[i].setText(Integer.toString(SpecialVendo.nonSellableItems[i].getStock().size()));
                nonSellLabels[i].setText("Php: " + Integer.toString(SpecialVendo.nonSellableItems[i].getPrice()));
            }  
            
            if (i < 3) {
                createdField[i].setText(Integer.toString(SpecialVendo.createdItems[i].getStock().size()));
                createdLabels[i].setText("Php: " + Integer.toString(SpecialVendo.createdItems[i].getPrice()));
            }
        }
    }

    private void clearButtons () {

        for (int i = 0; i < 4; i++) {
            order[i] = null;
        }

        screen.setText("\t        Order: \n\n");
        screen.append("  Item\t\t            Price \n");

        addOns.clear();
        burger.clear();

        breadGroup.clearSelection();
        meatGroup.clearSelection();
        sauceGroup.clearSelection();
        cheeseGroup.clearSelection();
        bacon.setSelected(false);
        egg.setSelected(false);
        ham.setSelected(false);
        sausage.setSelected(false);
        tomato.setSelected(false);
        lettuce.setSelected(false); 
        pickle.setSelected(false);
        onion.setSelected(false);
    }

    private void removeAddOn(Item item) {

        for (int i = 0; i < addOns.size(); i++) {
            if (addOns.get(i).equals(item))
                addOns.remove(i);
        }
    }

    private boolean isSellable(Item item) {

        for (Item i : RegularVendo.sellableItems) {
            if (i.equals(item))
                return true;
        }

        return false;
    } 

    private boolean checkOrder () {

        for (Item i : burger) {
            if (i.getStock().size() == 0)
             return false;
        }

        return true;
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == sesame) {
            order[0] = RegularVendo.sellableItems[0];
            printScreen();
        }
        if (e.getSource() == wheat) {
            order[0] = RegularVendo.sellableItems[1];
            printScreen();
        }
        if (e.getSource() == brioche) {
            order[0] = RegularVendo.sellableItems[2];
            printScreen();
        }
        if (e.getSource() == beef) {
            order[1] = RegularVendo.sellableItems[3];
            printScreen();
        }
        if (e.getSource() == vegan) {
            order[1] = RegularVendo.sellableItems[4];
            printScreen();
        }
        if (e.getSource() == chicken) {
            order[1] = RegularVendo.sellableItems[5];
            printScreen();
        }
        if (e.getSource() == american) {
            order[2] = SpecialVendo.nonSellableItems[4];
            printScreen();
        }
        if (e.getSource() == cheddar) {
            order[2] = SpecialVendo.nonSellableItems[5];
            printScreen();
        }
        if (e.getSource() == swiss) {
            order[2] = SpecialVendo.nonSellableItems[6];
            printScreen();
        }
        if (e.getSource() == noC) {
            order[2] = null;
            printScreen();
        }
        if (e.getSource() == bbq) {
            order[3] = SpecialVendo.nonSellableItems[7];
            printScreen();
        }
        if (e.getSource() == ket) {
            order[3] = SpecialVendo.createdItems[0];
            printScreen();
        }
        if (e.getSource() == mayo) {
            order[3] = SpecialVendo.createdItems[1];
            printScreen();
        }
        if (e.getSource() == thouIsl) {
            order[3] = SpecialVendo.createdItems[2];
            printScreen();
        }
        if (e.getSource() == noS) {
            order[3] = null;
            printScreen();
        }   
        if (e.getSource() == bacon) {
            if (bacon.isSelected())
                if (addOns.size() != 5)
                    addOns.add(RegularVendo.sellableItems[6]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    bacon.setSelected(false);
                }
            else
                removeAddOn(RegularVendo.sellableItems[6]);
            printScreen();
        }
        if (e.getSource() == ham) {
            if (ham.isSelected())
                if (addOns.size() != 5) 
                    addOns.add(RegularVendo.sellableItems[7]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    ham.setSelected(false);
                }
            else
                removeAddOn(RegularVendo.sellableItems[7]);
            printScreen();
        }
        if (e.getSource() == egg) {
            if (egg.isSelected())
                if (addOns.size() != 5) 
                    addOns.add(RegularVendo.sellableItems[8]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    egg.setSelected(false);
                }
            else
                removeAddOn(RegularVendo.sellableItems[8]);
            printScreen();
        }
        if (e.getSource() == sausage) {
            if (sausage.isSelected())
                if (addOns.size() != 5)
                    addOns.add(RegularVendo.sellableItems[9]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    sausage.setSelected(false);
                }
            else
                removeAddOn(RegularVendo.sellableItems[9]);
            printScreen();
        }
        if (e.getSource() == tomato) {
            if (tomato.isSelected())
                if (addOns.size() != 5)
                    addOns.add(SpecialVendo.nonSellableItems[0]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    tomato.setSelected(false);
                }
            else
                removeAddOn(SpecialVendo.nonSellableItems[0]);

            printScreen();
        }
        if (e.getSource() == lettuce) {
            if (lettuce.isSelected())
                if (addOns.size() != 5)
                    addOns.add(SpecialVendo.nonSellableItems[1]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    lettuce.setSelected(false);
                }
            else
                removeAddOn(SpecialVendo.nonSellableItems[1]);

            printScreen();
        }
        if (e.getSource() == pickle) {
            if (pickle.isSelected())
                if (addOns.size() != 5)
                    addOns.add(SpecialVendo.nonSellableItems[2]);
                else {
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    pickle.setSelected(false);
                }
            else
                removeAddOn(SpecialVendo.nonSellableItems[2]);

            printScreen();
        }
        if (e.getSource() == onion) {
            if (onion.isSelected())
                if (addOns.size() != 5)
                    addOns.add(SpecialVendo.nonSellableItems[3]);
                else { 
                    JOptionPane.showMessageDialog(null, "Add-On Limit! (Max: 5)", "Limit", JOptionPane.INFORMATION_MESSAGE, null);
                    onion.setSelected(false);
                }
            else
                removeAddOn(SpecialVendo.nonSellableItems[3]);
            printScreen();
        }
        if (e.getSource() == regular || e.getSource() == mainte) {
            clearButtons();
            vendo.getUserMoney().resetUserMoney();
        }
        if (e.getSource() == cancel) {
            clearButtons();
            total.setText("0");
        }
    }    

    public boolean dispense() {
        try {
                if (vendo.getUserMoney().checkUserMoney(Integer.parseInt(total.getText()))) {
                    burger = new ArrayList<>(); 
                    for (int i = 0; i < 4; i++) {
                         if (order[i] != null)
                            burger.add(order[i]);
                    } 
                    for (Item item : addOns) {
                        burger.add(item);
                    }   
                    if (burger.size() == 1) {
                        if (isSellable(burger.get(0))) {
                            if (checkOrder()) {
                                vendo.dispenseItem(burger.get(0));
                                printOrder();
                                clearButtons();  
                                update();    
                                return true;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Item is not Sellable!", "Invalid Transaction", JOptionPane.INFORMATION_MESSAGE, null);
                                clearButtons();  
                                return false;     
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Item is not Sellable!", "Invalid Transaction", JOptionPane.INFORMATION_MESSAGE, null);
                            clearButtons();       
                            return false;
                        }
                    }
                    else if (order[0] != null) {
                        if (checkOrder()) {
                            vendo.getOrder(burger);
                            printProcess();
                            update();
                            return true;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid Order!", "Invalid Transaction", JOptionPane.INFORMATION_MESSAGE, null);
                            clearButtons();
                            return false;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please Select a Bun!", "Invalid Transaction", JOptionPane.INFORMATION_MESSAGE, null);
                        clearButtons();       
                        return false;
                    }
                }   
                else
                    clearButtons();
            }
            catch (NumberFormatException v) {
                JOptionPane.showMessageDialog(null, "Not enough Payment!", "Payment", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

        return true;
    }
}
