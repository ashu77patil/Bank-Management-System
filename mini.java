package BankManagementsys;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class mini extends JFrame implements ActionListener{
	
	String pin;
	JLabel l1,l2,l3,l4;
	JButton b1;
	
	
	mini(String pin){
		this.pin = pin;
		super("Mini Statement");
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
		Image i2 = i1.getImage().getScaledInstance(1550, 860, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Atmimage = new JLabel(i3);
		Atmimage.setBounds(0, 0, 1550, 860);
		add(Atmimage);
		
		l1 = new JLabel();
		l1.setBounds(20, 140, 400, 20);
		Atmimage.add(l1);
		
		
		l2 = new JLabel("Katori Bank");
		l2.setFont(new Font("System",Font.BOLD,22));
		l2.setBounds(150, 20, 400, 20);
		Atmimage.add(l2);
		
		
		l3 = new JLabel();
		l3.setBounds(20, 80, 400, 20);
		Atmimage.add(l3);
		
		
		l4 = new JLabel();
		l4.setBounds(20, 400, 400, 20);
		Atmimage.add(l4);
		
		
		
		try {
			connection con = new connection();
			ResultSet rs = con.st.executeQuery("Select * from login where pin = '"+pin+"'");
			while(rs.next()) {
				l2.setText("account no :"+rs.getString("accno").substring(0,4) + "xxxxxxxxx"+rs.getString("accno").substring(12));
				
			}
			
			
			
		}catch(Exception e9) {
			e9.printStackTrace();
		}
		
		try {
			connection con = new connection();
			ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pin+"'");
			int balance = 0;
			while(rs.next()) {
				l1.setText(l1.getText() + "<html>" + rs.getString(Date)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+rs.getString(type)+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+rs.getString(amount)+"<>br<br><html>");
				
			
				if(rs.getString(type).equals(deposit)) {
					balance += Integer.parseInt(rs.getString(amount));
				}else {
					balance -= Integer.parseInt(rs.getString(amount));
					
				}	
			}
			l4.setText("your total balance is "+balance);
			
		}catch(Exception e10) {
			e10.printStackTrace();
			
			
		}
		
		b1 = new JButton("Exit");
		b1.setBounds(300, 600, 100, 20);
		b1.addActionListener(this);
		Atmimage.add(b1);
		
		
		setLayout(null);
		setLocation(0, 0);
		setSize(1550, 1080);
		setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new main_screen(pin);
		
	}
	public static void main(String[] args) {
		new mini("");

	}

	

}
