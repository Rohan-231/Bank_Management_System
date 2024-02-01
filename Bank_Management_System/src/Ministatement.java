import javax.swing.*;

import java.sql.*;

import java.awt.*;


public class Ministatement extends JFrame {
    String pinnumber;
    Ministatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(150,20,150,20);
        add(bank);

        JLabel card = new JLabel("");
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            conn n = new conn();
            ResultSet rs = n.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("CardNumber : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12, 16));
            }

        } catch (Exception e) {
            System.out.println(e);        
    }
    try {
        int bal = 0;
        conn n = new conn();
        ResultSet rs = n.s.executeQuery("select * from deposit where pin = '"+pinnumber+"'");
        while(rs.next()){
            mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            if(rs.getString("type").equals("Deposit")){
                bal += Integer.parseInt(rs.getString("amount"));
            }else{
                bal -= Integer.parseInt(rs.getString("amount"));
            }
        }
        balance.setText("Your current Balance is Rs "+bal);
    } catch (Exception e) {
        System.out.println(e);
    }
    mini.setBounds(20, 140, 400, 200);

        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }
    public static void main(String[] args) {
        Ministatement m = new Ministatement("");
    }
}
