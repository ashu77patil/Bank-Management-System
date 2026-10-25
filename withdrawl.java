package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class withdrawl extends JFrame implements ActionListener {
	String pin;
	JTextField t1;
	JButton b1,b2;
	
	withdrawl(String pin) {
		this.pin = pin;
		super("Withdrawl");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1220, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel atmimage = new JLabel(i3);
		atmimage.setBounds(0, 0, 1500, 1000);
		add(atmimage);
		
		
		JLabel l1 = new JLabel("Maximum Withdrawl Limit Is 10,000");
		l1.setFont(new Font("elephant",Font.BOLD,12));
		l1.setForeground(Color.white);
		l1.setBounds(480,180,350, 30);
		atmimage.add(l1);
		
		JLabel l2 = new JLabel("Enter Amount You Want To Withdraw");
		l2.setFont(new Font("elephant",Font.BOLD,12));
		l2.setForeground(Color.white);
		l2.setBounds(480,220,290, 30);
		atmimage.add(l2);
		
		t1 = new JTextField();
		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.white);
		t1.setBounds(480, 250, 250, 20);
		atmimage.add(t1);
		
		b1 = new JButton("Withdraw");
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
		if(e.getSource()==b1) {
		try {
			String amount = t1.getText();
			Date date = new Date();
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter amount");
				
			}else {
				connection con = new connection();
				ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pin+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
						
						
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
					
					
				}
				if(balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				con.st.executeUpdate("insert into bank values('"+pin+"','"+date+"','withdrawl','"+amount+"')");
				JOptionPane.showMessageDialog(null, "Amount rs. " +amount+ "Deposited sucessfully");
				setVisible(false);
				new main_screen(pin);
				
			}
				
				
				
				
				
				
			
			
		}catch(Exception e5) {
			e5.printStackTrace();
		}
		}else if(e.getSource()==b2) {
			
			setVisible(false);
			new main_screen(pin);
		}
		
	} 


public static void main(String[]args) {
	new withdrawl("");
	
}
}