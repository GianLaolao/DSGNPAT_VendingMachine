import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel implements ActionListener {

    JButton one, five, ten, twenty, fifty, hundred, twoHun, fiveHun, thou;
    JButton moneyButton[] = new JButton[9];

    JTextField payment, totalPrice;
    JTextArea screen;
    JButton cancel, dispense;

    Font font1 = new Font("Monospaced Bold", Font.BOLD, 20);
    Font font2 = new Font("Monospaced Bold", Font.BOLD, 15);

    VendingMachine vendo;

    private final String indent = "                  ";

    public PaymentPanel(JTextField payment, JTextField total, JTextArea screen, JButton dispense, JButton cancel, VendingMachine vendo) {

        this.payment = payment;
        this.totalPrice = total;
        this.screen = screen;

        this.cancel = cancel;
        cancel.addActionListener(this);

        this.dispense = dispense;

        this.vendo = vendo;

        moneyButton[0] = one = new JButton("1");
        moneyButton[1] = five = new JButton("5");
        moneyButton[2] = ten = new JButton("10");
        moneyButton[3] = twenty = new JButton("20");
        moneyButton[4] = fifty = new JButton("50");
        moneyButton[5] = hundred = new JButton("100");
        moneyButton[6] = twoHun = new JButton("200");
        moneyButton[7] = fiveHun = new JButton("500");
        moneyButton[8] = thou = new JButton("1000");

        setLayout(new GridLayout(3, 3, 2, 2));
        setBounds(35, 400, 220, 220);
        setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < 9; i++) {
            moneyButton[i].setBounds(0, 0, 50, 50);
            moneyButton[i].setFont(font2);
            moneyButton[i].addActionListener(this);
            moneyButton[i].setFocusable(false);
            moneyButton[i].setBackground(Color.WHITE);
            moneyButton[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            this.add(moneyButton[i]);
        }
    }

    public void returnChange() {

        MoneyBox x =  vendo.getMoneyCalc().getUserMoney();
        String message = "         Payment Returned \n\n" +
                        "Value:\t\tQuantity: \n";
        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(font2);
        text.setBackground(new Color(0xEEEEEE));
        
        for (int i = 0; i < 9; i++) {
            if (x.getCash(i).getQuantity() != 0) {
                String a = Integer.toString(x.getCash(i).getValue());
                a += indent.substring(0, indent.length() - a.length());
                message += " " + a + "\t\t " + x.getCash(i).getQuantity() + "\n"; 
            }
        }
        text.setText(message);
        vendo.getMoneyCalc().resetUserMoney();
        JOptionPane.showMessageDialog(null, text, "Payment Return", JOptionPane.INFORMATION_MESSAGE);
    }

    private void printReceipt(MoneyBox change) {

        JTextArea text = new JTextArea();
        int total = 0;
        text.setEditable(false);
        text.setFocusable(false);
        text.setFont(font2);
        text.setBackground(new Color(0xEEEEEE));
        text.setSize(new Dimension(300, 300));

        String message = "\tChange \n\n" +
                            "Value:\t\tQuantity: \n";

        for (int i = 0; i < 9; i++) {
            if (change.getCash(i).getQuantity() != 0) {
                String a = Integer.toString(change.getCash(i).getValue());
                a += indent.substring(0, indent.length() - a.length());
                message += " " + a + "\t\t " + change.getCash(i).getQuantity() + "\n"; 
                total += change.getCash(i).getTotal();
            }
        }
        message += "\n\n\tTotal:       Php: " + total;
        text.setText(message);
        JOptionPane.showMessageDialog(null, text, "Change", JOptionPane.INFORMATION_MESSAGE);
        

    }
    
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == one){
            vendo.getMoneyCalc().takePayment(0);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == five){
            vendo.getMoneyCalc().takePayment(1);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == ten){
            vendo.getMoneyCalc().takePayment(2);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == twenty){
            vendo.getMoneyCalc().takePayment(3);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == fifty){
            vendo.getMoneyCalc().takePayment(4);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == hundred){
            vendo.getMoneyCalc().takePayment(5);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == twoHun){
            vendo.getMoneyCalc().takePayment(6);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == fiveHun){
            vendo.getMoneyCalc().takePayment(7);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == thou){
            vendo.getMoneyCalc().takePayment(8);
            payment.setText(String.format("%d", vendo.getMoneyCalc().getUserMoney().getTotal()));
        }
        if (e.getSource() == dispense) {

            boolean check = vendo.getMoneyCalc().checkUserMoney(Integer.parseInt(totalPrice.getText()));
            MoneyBox change = vendo.getMoneyCalc().produceChange(Integer.parseInt(totalPrice.getText()));
            
            try {
                if (check && change != null) {
                    printReceipt(change);
                    screen.setText("\t        Order: \n\n");
                    screen.append("  Item\t\t            Price \n");
                    totalPrice.setText("0");
                    payment.setText("Php 0.00");
                }
                else {
                    if (Integer.parseInt(totalPrice.getText()) > vendo.getMoneyCalc().getUserMoney().getTotal())
                        JOptionPane.showMessageDialog(null, "Not enough Payment!", "Payment", JOptionPane.INFORMATION_MESSAGE);
                    else if (change == null) {
                        JOptionPane.showMessageDialog(null, "Not Enough Change.", "Transaction Fail", JOptionPane.INFORMATION_MESSAGE);
                        returnChange();
                        vendo.getMoneyCalc().resetUserMoney();
                        payment.setText("Php 0.00");
                        totalPrice.setText("0");
                        screen.setText("\t        Order: \n\n");
                        screen.append("  Item\t\t            Price \n");
                    }            
                }
            }
            catch (NumberFormatException v) {
                JOptionPane.showMessageDialog(null, "Not enough Payment!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        if (e.getSource() ==  cancel) {
            returnChange();
        }
    }
    public void dispense() {

        if (Integer.parseInt(totalPrice.getText()) > vendo.getMoneyCalc().getUserMoney().getTotal()) {
                JOptionPane.showMessageDialog(null, "Not enough Payment!", "Payment", JOptionPane.INFORMATION_MESSAGE);
                payment.setText("Php: 0.00");
                returnChange();
        }
        else {
            boolean check = vendo.getMoneyCalc().checkUserMoney(Integer.parseInt(totalPrice.getText()));
            MoneyBox change = vendo.getMoneyCalc().produceChange(Integer.parseInt(totalPrice.getText()));
                
            if (check && change != null) {
                printReceipt(change);
                screen.setText("\t        Order: \n\n");
                screen.append("  Item\t\t            Price \n");
                totalPrice.setText("0");
                payment.setText("Php 0.00");
            }
            else if (change == null) {
                JOptionPane.showMessageDialog(null, "Not Enough Change.", "Transaction Fail", JOptionPane.INFORMATION_MESSAGE);
                returnChange();
                vendo.getMoneyCalc().resetUserMoney();
                payment.setText("Php 0.00");
                totalPrice.setText("0");
                screen.setText("\t        Order: \n\n");
                screen.append("  Item\t\t            Price \n");
            }            
        }
    }
}
