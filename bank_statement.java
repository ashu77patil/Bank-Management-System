package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class bank_statement extends JFrame implements ActionListener{
	JLabel l2;
	JButton b1;
	String pin;
	int balance;
	bank_statement(String pin){
		this.pin = pin;
	
		super("Bank Statement");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1220, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel atmimage = new JLabel(i3);
		atmimage.setBounds(0, 0, 1500, 1000);
		add(atmimage);
		
		
		JLabel l1 = new JLabel("Your current balance is");
		l1.setFont(new Font("elephant",Font.BOLD,12));
		l1.setForeground(Color.white);
		l1.setBounds(480,180,350, 30);
		atmimage.add(l1);
		
        l2  = new JLabel();
		l2.setFont(new Font("elephant",Font.BOLD,12));
		l2.setForeground(Color.white);
		l2.setBounds(480,220,290, 30);
		atmimage.add(l2);
		
		b1 = new JButton("Back");
		b1.setBackground(Color.CYAN);
		b1.setBounds(700, 400, 100, 30);
		b1.addActionListener(this);
		atmimage.add(b1);
		
		try {
			connection con = new connection();
			ResultSet rs = con.st.executeQuery("select * from bank where pin is '"+pin+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
					
					
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
				}
			}catch(Exception e6) {
			
			
			e6.printStackTrace();
		}
		
		l2.setText(""+ balance);
		
		setSize(1520,1080);
		setLayout(null);
		setLocation(0, 0);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	setVisible(false);
	new main_screen(pin);
		
	}

	public static void main(String[] args) {
		new bank_statement("");

	}



}
