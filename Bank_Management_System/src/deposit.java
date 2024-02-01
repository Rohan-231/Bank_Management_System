import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
// import java.sql.*;

public class deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel lab = new JLabel("Enter the amount you want to deposit");
        lab.setForeground(Color.WHITE);
        lab.setFont(new Font("System", Font.BOLD, 16));
        lab.setBounds(170,300,400,20);
        label.add(lab);

        amount  = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        label.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        label.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        label.add(back);
        back.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }if(Integer.parseInt(number)<0){
                JOptionPane.showMessageDialog(null,"Please Enter valid amount");
                return;
            }
            else{
                try{
                    conn n = new conn();
                    String query = "insert into deposit values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    n.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }
                catch(Exception ae){
                    System.out.println(ae);
                }
            }

        } else if (e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        deposit d = new deposit("");
    }
    
}
