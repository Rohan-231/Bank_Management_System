import java.util.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JRadioButton male,female,married,unmarried;
    JButton nexButton;
    JComboBox religion,category,occupation,education,income;
    String formno;
    Signup2(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form : Page 2");
        JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 150, 30);
        add(name);

        String religionvalues[] = {"Hindu","Muslim","Sikh","Christian","Others"};

        religion = new JComboBox(religionvalues);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String categoryvalues[] = {"General","OBC","SC","ST","Others"};

        category = new JComboBox(categoryvalues);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomevalues[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Up To 10,00,000"};

        income = new JComboBox(incomevalues);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 320, 200, 30);
        add(email);

        String educationalvalues[] = {"Metrics","Graduation","Post-Graduation","Doctorate","Others"}; 

        education = new JComboBox(educationalvalues);
        education.setBounds(300,320,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationvalues[] = {"Salarised","Self-employed","Businessmen","Others"};

        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("Pan Number : ");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number : ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        married = new JRadioButton("Yes");
        married.setBounds(300, 540, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("No");
        unmarried.setBounds(450,540, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup senior = new ButtonGroup();
        senior.add(married);
        senior.add(unmarried);        

        JLabel pincode = new JLabel("Existing Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 300, 30);
        add(pincode);

        male = new JRadioButton("Yes");
        male.setBounds(300, 590, 90, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("No");
        female.setBounds(450,590, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup account = new ButtonGroup();
        account.add(male);
        account.add(female);

        nexButton = new JButton("Next");
        nexButton.setBackground(Color.BLACK);
        nexButton.setForeground(Color.WHITE);
        nexButton.setFont(new Font("Arial", Font.BOLD, 14));
        nexButton.setBounds(620, 660, 80, 30);        
        nexButton.addActionListener(this);
        add(nexButton);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem(); 
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String senior = null;
        if(married.isSelected()){
            senior = "Yes";
        }
        else if(unmarried.isSelected()){
            senior = "No";
        }
        
        String existing = null;
        if(male.isSelected()){
            existing = "Yes";
        }
        else if(female.isSelected()){
            existing = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            
                conn n = new conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+senior+"','"+existing+"')";
                n.s.execute(query); 
                setVisible(false);
                Signup3 s = new Signup3(formno);
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }

    public static void main(String[] args) {
        Signup2 s= new Signup2("");
    }
}
