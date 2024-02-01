import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener {
    JButton deposit,fastcash,pinchange,cashwith,ministat,balance,exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Select your Withdrawal Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text); 

        deposit = new JButton("Rs 500");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        cashwith = new JButton("Rs 1000");
        cashwith.setBounds(355,415,150,30);
        cashwith.addActionListener(this);
        label.add(cashwith);

        fastcash = new JButton("Rs 2000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministat = new JButton("Rs 5000");
        ministat.setBounds(355,450,150,30);
        ministat.addActionListener(this);
        label.add(ministat);

        pinchange = new JButton("Rs 10000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance = new JButton("Rs 15000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);

        exit = new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else{
            String amount = ((JButton) e.getSource()).getText().substring(3);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from deposit where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    if(e.getSource() !=exit && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into deposit values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }

        }
    }

    public static void main(String[] args) {
        Fastcash t = new Fastcash("");
    }
    
}
