import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,400,40);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 200, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 250, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 150, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1106");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetail = new JLabel("Your 16-Digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 15));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);

        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(330,370,300,30);
        add(pinnumber);

        JLabel pindetail = new JLabel("Your 16-Digit Card Number");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 15));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,400,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Net Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alets");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(100,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby decllare that all the above entered details are correct to the best of my knowledge ");
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(220, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Savings Account";
            }
            else if(r2.isSelected()){
                accounttype = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accounttype = "Current Account";
            }
            else if(r4.isSelected()){
                accounttype = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 9000000L) + 1040936000000000L); 
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            } else if (c2.isSelected()){
                facility = facility + " Net Banking";
            } else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()){
                facility = facility + " E-Statement";
            }

            try {
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    conn c = new conn();
                    String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query1 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber + "\n Pin : "+pinnumber); 
                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }

        }else if (e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        Signup3 s = new Signup3("");    
    }
    
}
