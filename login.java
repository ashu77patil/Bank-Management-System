package BankManagementsys;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class login extends JFrame implements ActionListener{
	    JLabel label1,label2 ,label3;
	    JPasswordField passwordfield3;
	    JTextField textfield2;
	    JButton button1,button2,button3;
	    


	    login() {
		super("Bank Management System");
		
		/*ImageIcon i1 = new ImageIcon(getClass().getResource("/icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(350,20,100,100);
		add(Image);*/
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(650,350,100,100);
		add(Image);
		
		
		label1 = new JLabel("WELCOME USER");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("ELEPHANT",Font.BOLD,12));
		label1.setBounds(30, 10, 100, 40);
		add(label1);
		
		label2 = new JLabel("Card No:");
		label2.setForeground(Color.white);
		label2.setFont(new Font("Ralway", Font.BOLD, 22));
		label2.setBounds(380, 40, 250, 50);
		add(label2);
	    
		textfield2 = new JTextField(15);
		textfield2.setBounds(480, 40, 250, 50);
		textfield2.setFont(new Font("Elephant",Font.BOLD,20));
		add(textfield2);
		
		
		label3 = new JLabel("PIN :");
		label3.setForeground(Color.white);
		label3.setFont(new Font("Ralway", Font.BOLD,22));
		label3.setBounds(400, 100, 250, 50);
		add(label3);
		
		passwordfield3 = new JPasswordField("15");
		passwordfield3.setFont(new Font("Elephant",Font.BOLD,22));
		passwordfield3.setBounds(480, 100, 250, 50);
		add(passwordfield3);
		
		button1 = new JButton("SIGN IN");
		button1.setBounds(450, 150, 100, 30);
		button1.setFont(new Font("Elephant", Font.BOLD,10));
		button1.addActionListener(this);
		add(button1);
		
		button2 = new JButton("Clear");
		button2.setBounds(550, 150, 100, 30);
		button2.setFont(new Font("Elephanr", Font.BOLD,10));
		button2.setBackground(Color.BLUE);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("SIGN UP");
		button3.setBounds(650, 150, 150, 30);
		button3.setFont(new Font("ELEPHANR", Font.BOLD,10));
		button3.setBackground(Color.YELLOW);
		button3.addActionListener(this);
		add(button3);
		
		
		
		
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
		Image i22 = i11.getImage().getScaledInstance(850, 480, java.awt.Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i22);
		JLabel Image2 = new JLabel(i33);
		Image2.setBounds(0,0,850,480);
		add(Image2);
		
		setLayout(null);
		setSize(850,480);
		setLocation(350,200);
		setVisible(true);
		
		
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getSource()== button1) {
					connection con = new connection();
					String accno = textfield2.getText();
					String pin = passwordfield3.getText();
					String q = "select * from login where Accountno = '"+accno+"' and pin = '"+pin+"'";
					ResultSet rs = con.st.executeQuery(q);
					if(rs.next()) {
						setVisible(false);
						new main_screen(pin);
					}else {
						JOptionPane.showMessageDialog(null, "incorrect PIN or AccNo.");
					}
				
			}else if(e.getSource()== button2){
				textfield2.setText("");
				passwordfield3.setText("");
				
			}else if(e.getSource()== button3){
				new signup();
				setVisible(false);
				
			}
			
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		}


	public static void main(String[] args){
		new login();
		
		
	}}




