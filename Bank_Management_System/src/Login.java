import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;
public class Login extends JFrame implements ActionListener{
    JButton signin,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    

    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icons/SBI-logo.svg (1).jpg"));
        setIconImage(icon1.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/SBI-logo.svg (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to SBI");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card NO.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(125, 150, 375, 30);
        add(cardno);

        cardTextField = new JTextField(15);
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        pinLabel.setBounds(125, 220, 375, 30);
        add(pinLabel);

        pinTextField = new JPasswordField(15);
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Arial", Font.BOLD, 14));
        signin.setBounds(300, 300, 100, 30);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430, 300, 100, 30);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300, 350, 230, 30);
        add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);
        clear.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource()==signin){
            conn n = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'"; 
            try {
                ResultSet s = n.s.executeQuery(query);
                if(s.next()){
                    setVisible(false);
                    Transactions t = new Transactions(pinnumber);
                    t.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Cardnumber or PIN");
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }else if(e.getSource()==signup){
            setVisible(false);
            Signup1 s = new Signup1();
            s.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Login l = new Login();
    }
    
}
 