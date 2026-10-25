package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class main_screen extends JFrame implements ActionListener {
	String pin;
	JButton b1,b2,b3,b4,b5,b6,b7;
	main_screen(String pin){
		this.pin = pin;
		super("User Dashboard");
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 860, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Atmimage = new JLabel(i3);
		Atmimage.setBounds(0, 0, 1550, 860);
		add(Atmimage);
		
		JLabel t1 = new JLabel("Please Select Your Transaction");
		t1.setFont(new Font("elephant",Font.BOLD,20));
		t1.setBounds(470, 200, 350, 30);
		t1.setForeground(Color.white);
		Atmimage.add(t1);
		
		
		
		b1 = new JButton("Deposit");
		b1.setBounds(410, 280, 150, 40);
		b1.addActionListener(this);
		Atmimage.add(b1);
		
		b2 = new JButton("Cash Withdrawl");
		b2.setBounds(700, 280, 150, 40);
		b2.addActionListener(this);
		Atmimage.add(b2);
		
		b3 = new JButton("Fast Cash");
		b3.setBounds(410, 330, 150, 40);
		b3.addActionListener(this);
		Atmimage.add(b3);
		
		b4 = new JButton("Mini Statement");
		b4.setBounds(700, 330, 150, 40);
		b4.addActionListener(this);
		Atmimage.add(b4);
		
		b5 = new JButton("PIN Change");
		b5.setBounds(410, 380, 150, 40);
		b5.addActionListener(this);
		Atmimage.add(b5);
		
		b6 = new JButton("Bank Enquiry");
		b6.setBounds(700, 380, 150, 40);
		b6.addActionListener(this);
		Atmimage.add(b6);
		
		b7 = new JButton("EXIT");
		b7.setBounds(700, 430, 150, 40);
		b7.addActionListener(this);
		Atmimage.add(b7);
		
		setLayout(null);
		setLocation(0, 0);
		setSize(1550, 1080);
		setVisible(true);
		
		
	}


@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== b1) {
		new Deposit(pin);
		setVisible(false);
		
	}else if (e.getSource() == b2) {
		new withdrawl(pin);
		setVisible(false);
		
	}else if (e.getSource() == b3) {
		new fastcash(pin);
		setVisible(false);
		
		
	}else if (e.getSource() == b4) {
		new mini(pin);
		setVisible(false);
		
	}else if(e.getSource() == b5) {
		new pinchange(pin);
		setVisible(false);
		
	}else if(e.getSource() == b6) {
		new bank_statement(pin);
		setVisible(false);
	}
	
	
	else if(e.getSource()== b7) {
		setVisible(false);
		System.exit(0);
	}
	
	
}
public static void main(String [] args) {
	new main_screen("");
	
	
	
}
}