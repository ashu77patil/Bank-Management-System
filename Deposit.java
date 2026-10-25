package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class Deposit extends JFrame implements ActionListener{
	String pin;

	JTextField t1;
	JButton b1,b2;
	Deposit(String pin){
		this.pin = pin;
		super("Deposit");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1220, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel atmimage = new JLabel(i3);
		atmimage.setBounds(0, 0, 1500, 1000);
		add(atmimage);
		
		
		JLabel l1 = new JLabel("Enter Amount You Want To Deposit");
		l1.setFont(new Font("elephant",Font.BOLD,12));
		l1.setForeground(Color.white);
		l1.setBounds(480,180,290, 30);
		atmimage.add(l1);
		t1 = new JTextField();
		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.white);
		t1.setBounds(480, 220, 250, 20);
		atmimage.add(t1);
		
		b1 = new JButton("Deposit");
		b1.setBackground(Color.CYAN);
		b1.setBounds(700, 400, 100, 30);
		b1.addActionListener(this);
		atmimage.add(b1);
		b2 = new JButton("back");
		b2.setBackground(Color.CYAN);
		b2.setBounds(700, 450, 100, 30);
		b2.addActionListener(this);
		atmimage.add(b2);
		
		
		setSize(1520,1080);
		setLayout(null);
		setLocation(0, 0);
		setVisible(true);
	}
	
	

@Override
public void actionPerformed(ActionEvent e) {
	try{
		String amount =  t1.getText();
	    Date date = new Date();
		if(e.getSource() ==b1) {
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter Amount To Deposit");
			}else {
				connection con4 = new connection();
				con4.st.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
				JOptionPane.showMessageDialog(null, "Rs."+amount+"Deposited Sucessfully");
				setVisible(false);
				new main_screen(pin);
				
				
			}
			
		}else if(e.getSource()==b2) {
			setVisible(false);
			new main_screen(pin);
		}
		
	}catch(Exception e3) {
		e3.printStackTrace();
	}
	
	
	
}

public static void main(String[] args) {
	new Deposit("");
	
}
	
}