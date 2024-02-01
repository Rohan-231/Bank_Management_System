import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    Balance(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        conn c = new conn();
        int balance =0;
            try {
                ResultSet rs = c.s.executeQuery("Select * from deposit where pin = '"+pinnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("Your account balance is Rs '"+balance+"'");
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        label.add(text);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        label.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        Balance bb = new Balance("");
    }
}
