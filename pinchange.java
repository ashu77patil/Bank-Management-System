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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pinchange extends JFrame implements ActionListener{
	String pin;
	JButton b1,b2;
	JPasswordField p1,p2;
	pinchange(String pin){
		this.pin = pin;
		super("Deposit");
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1220, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel atmimage = new JLabel(i3);
		atmimage.setBounds(0, 0, 1500, 1000);
		add(atmimage);
		
		
		JLabel l1 = new JLabel("Change Your PIN");
		l1.setFont(new Font("elephant",Font.BOLD,22));
		l1.setForeground(Color.white);
		l1.setBounds(480,180,290, 30);
		atmimage.add(l1);
		
		JLabel l2 = new JLabel("Enter New PIN");
		l2.setFont(new Font("elephant",Font.BOLD,12));
		l2.setForeground(Color.white);
		l2.setBounds(480,250,290, 30);
		atmimage.add(l2);
		
		p1 = new JPasswordField();
		p1.setBounds(600, 250, 100, 20);
		atmimage.add(p1);
		
		JLabel l3 = new JLabel("Re-Enter New PIN");
		l3.setFont(new Font("elephant",Font.BOLD,12));
		l3.setForeground(Color.white);
		l3.setBounds(480,300,290, 30);
		atmimage.add(l3);
		
		p2 = new JPasswordField();
		p2.setBounds(600, 300, 100, 20);
		atmimage.add(p2);
		
		b1 = new JButton("Reset PIN");
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
		try {
			char[] pin1 = p1.getPassword();
			char[] pin2 = p2.getPassword();
			
			if (! pin1 .equals(pin2)) {
				JOptionPane.showMessageDialog(null,"pin doesnot matched");
				return;
				
			}
			if(e.getSource()==b1) {
				
			
			if (p1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"enter the PIN");
				return;
				
			}else if(p2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"enter the PIN");
				return;}
			
			
			if(pin1.equals(pin2)) {
			connection con = new connection();
			String q1 = "update bank pin1 = '"+pin1+"' where pin = '"+pin+"'";
			String q2 = "update login pin1 = '"+pin1+"' where pin = '"+pin+"'";
			String q3 = "update signupthree pin1 = '"+pin1+"' where pin = '"+pin+"'";
			con.st.executeUpdate(q1);
			con.st.executeUpdate(q2);
			con.st.executeUpdate(q3);
			JOptionPane.showMessageDialog(null,"PIN changed Sucessfully");
			new main_screen(pin);
			setVisible(false);
			
			
			
			
			}else if(e.getSource()==b2) {
				new main_screen(pin);
				setVisible(false);
			}
			
	        }
	        
		}catch(Exception e7) {
			e7.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new pinchange("");

	}



}
