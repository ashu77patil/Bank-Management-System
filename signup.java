package BankManagementsys;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signup extends JFrame implements ActionListener{
	
	Random ran = new Random();
	long first4 =(ran.nextLong() % 9000L) + 1000L;
	String first = " " + Math.abs(first4);
	
	JButton next;
    JDateChooser datechooser;
    JRadioButton r1,r2,m1,m2;
    JTextField textname,fname,address,pincode,city,email;
	
	
	signup(){
		super("Application Form");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(150, 80, 150, 120);
		add(Image);
		JLabel label1 = new JLabel("Application NO." + first);
		label1.setBounds(450, 20, 450, 50);
		label1.setFont(new Font("Raleway", Font.BOLD,32));
		add(label1);
		
		JLabel label2 = new JLabel("PERSONAL DETAILS");
		label2.setBounds(320,120,300,100);
		label2.setFont(new Font("elephant",Font.BOLD,22));
		add(label2);
		
		JLabel label3 = new JLabel("Name:");
		label3.setBounds(200, 200, 100 ,30);
		label3.setFont(new Font("Elephant",Font.BOLD,22));
		add(label3);
		textname = new JTextField();
		textname.setBounds(420, 200, 230, 30);
		textname.setFont(new Font("elephant",Font.PLAIN,25));
		add(textname);
		
		JLabel label4 = new JLabel("Father's Name:");
		label4.setBounds(200, 260, 200, 30);
		label4.setFont(new Font("elephant",Font.BOLD,22));
		add(label4);
		fname = new JTextField();
		fname.setBounds(420, 260, 230, 30);
		fname.setFont(new Font("Elephant",Font.PLAIN,22));
		add(fname);
		
		JLabel label5 = new JLabel("Date Of Birth :");
		label5.setFont(new Font("Elephant",Font.BOLD,22));
		label5.setBounds(200, 320, 200, 30);
		add(label5);
		datechooser = new JDateChooser();
		datechooser.setForeground(new Color(105,105,105));
		datechooser.setBounds(420, 320, 200, 30);
		add(datechooser);
		
		JLabel label6 = new JLabel("Gander")	;
		label6.setFont(new Font("Elephant",Font.BOLD,22));
		label6.setBounds(200, 380, 200, 30);
		add(label6);
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Elephant",Font.BOLD,22));
		r1.setBounds(400, 380, 200, 30);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Elephant",Font.BOLD,22));
		r2.setBounds(550, 380, 200, 30);
		add(r2);
		ButtonGroup genderbutton = new ButtonGroup();
		genderbutton.add(r1);
		genderbutton.add(r2);
		
		JLabel label7 = new JLabel("Email :");
		label7.setFont(new Font("Elephant",Font.BOLD,22));
		label7.setBounds(200, 430, 230, 30);
		add(label7);
		email = new JTextField();
		email.setFont(new Font("Elephant",Font.PLAIN,22));
		email.setBounds(420, 430, 230, 30);
		add(email);
		
		JLabel label8 = new JLabel("Address");
		label8.setFont(new Font("Elephant",Font.BOLD,22));
		label8.setBounds(200, 500, 230, 30);
		add(label8);
		address = new JTextField();
		address.setFont(new Font("elephant",Font.PLAIN,22));
		address.setBounds(420, 500, 230, 30);
		add(address);
		
		JLabel label9 = new JLabel("City");
		label9.setFont(new Font("Elephant",Font.BOLD,22));
		label9.setBounds(200, 560, 230, 30);
		add(label9);
		city = new JTextField();
		city.setFont(new Font("elephant",Font.PLAIN,22));
		city.setBounds(420, 560, 230, 30);
		add(city);
		
		JLabel label10 = new JLabel("Pincode");
		label10.setFont(new Font("Elephant",Font.BOLD,22));
		label10.setBounds(200, 620, 230, 30);
		add(label10);
		pincode = new JTextField();
		pincode.setFont(new Font("elephant",Font.PLAIN,22));
		pincode.setBounds(420, 620, 230, 30);
		add(pincode);
		
		JLabel label11 = new JLabel("marriage status");
		label11.setBounds(200, 680, 230, 30);
		label11.setFont(new Font("elephant",Font.BOLD,22));
		add(label11);
		m1 = new JRadioButton("Married");
		m1.setFont(new Font("Elephant",Font.BOLD,22));
		m1.setBounds(420, 680, 200, 30);
		add(m1);
		m2 = new JRadioButton("Single");
		m2.setBounds(580, 680, 200, 30);
		m2.setFont(new Font("Elephant",Font.BOLD,22));
		add(m2);
		ButtonGroup marritalstatus = new ButtonGroup();
		marritalstatus.add(m1);
		marritalstatus.add(m2);
		
		next =new JButton("Next");
		next.setFont(new Font("Elephant",Font.BOLD,22));
		next.setBounds(555, 720, 200, 30);
		next.addActionListener(this);
		add(next);
				
		
		
		
		getContentPane().setBackground(new Color(255,253,208));
		setSize(880, 800);
		setLocation(350, 400);
		setLayout(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formno = first;
		String name = textname.getText();
		String fathername = fname.getText();
		String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}else if(r2.isSelected()) {
			gender ="Female";
		}
		String emailid = email.getText();
		String add = address.getText();
		String city1 = city.getText();
		String postalcode = pincode.getText();
		String mstatus = null;
		if(m1.isSelected()) {
			mstatus = "Married";
		}else if(m2.isSelected()) {
			mstatus = "Single";
		}
		
		try {
			if (textname.getText().equals("")) {
				JOptionPane.showInternalMessageDialog(null, "fill all fields");
			}else {
				connection con1 = new connection();
				String q ="insert into Signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+emailid+"','"+add+"','"+city1+"','"+postalcode+"','"+mstatus+"')";
				con1.st.executeUpdate(q);
				new signup2(formno);
				setVisible(false);
			
				
				
				
			}
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new signup();
		
	}


}
