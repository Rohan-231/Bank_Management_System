import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transactions extends JFrame implements ActionListener {
    JButton deposit,fastcash,pinchange,cashwith,ministat,balance,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text); 

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        cashwith = new JButton("Cash Withdrawal");
        cashwith.setBounds(355,415,150,30);
        cashwith.addActionListener(this);
        label.add(cashwith);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministat = new JButton("Mini Statement");
        ministat.setBounds(355,450,150,30);
        ministat.addActionListener(this);
        label.add(ministat);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        label.add(exit);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        } else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        } else if (e.getSource()==cashwith){
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
        }  else if (e.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if(e.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        } else if (e.getSource() == balance){
            setVisible(false);        
            new Balance(pinnumber).setVisible(true);
        } else if (e.getSource() == ministat){
            new Ministatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        Transactions t = new Transactions("");
    }
    
}
