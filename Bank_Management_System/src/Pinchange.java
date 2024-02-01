import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Pinchange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);
        

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);

        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 320, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        label.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        label.add(pin);

        JLabel rpintext = new JLabel("Re-Enter New PIN");
        rpintext.setForeground(Color.WHITE);
        rpintext.setBounds(165, 360, 180, 25);
        rpintext.setFont(new Font("System", Font.BOLD, 16));
        label.add(rpintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        label.add(repin);

        change = new JButton("Change");
        change.setBounds(255,485,150,30);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("Back");
        back.setBounds(255,520,150,30);
        back.addActionListener(this);
        label.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change ){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                }
                conn n = new conn();
                String query1 = "update deposit set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'"; 
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                n.s.executeUpdate(query1);
                n.s.executeUpdate(query2);
                n.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        Pinchange p = new Pinchange("");
    }
}
