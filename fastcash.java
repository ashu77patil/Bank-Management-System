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

public class fastcash extends JFrame implements ActionListener{
	
		String pin;
		JButton b1,b2,b3,b4,b5,b6;
		fastcash(String pin){
			this.pin = pin;
			super("FAST Cash");
			
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
			Image i2 = i1.getImage().getScaledInstance(1550, 860, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel Atmimage = new JLabel(i3);
			Atmimage.setBounds(0, 0, 1550, 860);
			add(Atmimage);
			
			JLabel t1 = new JLabel("Please Select Your Amount");
			t1.setFont(new Font("elephant",Font.BOLD,20));
			t1.setBounds(470, 200, 350, 30);
			t1.setForeground(Color.white);
			Atmimage.add(t1);
			
			
			
			b1 = new JButton("Rs.100");
			b1.setBounds(410, 280, 150, 40);
			b1.addActionListener(this);
			Atmimage.add(b1);
			
			b2 = new JButton("RS.500");
			b2.setBounds(700, 280, 150, 40);
			b2.addActionListener(this);
			Atmimage.add(b2);
			
			b3 = new JButton("Rs.1000");
			b3.setBounds(410, 330, 150, 40);
			b3.addActionListener(this);
			Atmimage.add(b3);
			
			b4 = new JButton("RS.5000");
			b4.setBounds(700, 330, 150, 40);
			b4.addActionListener(this);
			Atmimage.add(b4);
			
			b5 = new JButton("Rs.10000");
			b5.setBounds(410, 380, 150, 40);
			b5.addActionListener(this);
			Atmimage.add(b5);
			
			b6 = new JButton("Back");
			b6.setBounds(700, 380, 150, 40);
			b6.addActionListener(this);
			Atmimage.add(b6);

			setLayout(null);
			setLocation(0, 0);
			setSize(1550, 1080);
			setVisible(true);
			
			
		}
		
		
	
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b6) {
		setVisible(false);
		new main_screen(pin);
		
	}else {
		String amount =((JButton)e.getSource()).getText().substring(4);
		connection con = new connection();
		Date date = new Date();
		
		try {
			
			ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pin+"'");
			int balance = 0;
			while(rs.next()) {
				if(rs.getString(type).equals(deposit)) {
					balance += Integer.parseInt(rs.getString(amount));
				}else {
					balance -= Integer.parseInt(rs.getString(amount));
					
				}
			}String num = "17";
			
			if(e.getSource() != b6 && balance << Integer.parseInt(amount));
			{JOptionPane.showMessageDialog(null, "Insufficient Balance");
			return;
			
			
			
		}con.st.executeUpdate("insert into bank values( '"+pin+"','"+date+"','withdraw','"+amount+"')");
				
			JOptionPane.showMessageDialog(null,"RS. "+amount+"Debited sucessfully");
			
			
			
		}catch(Exception e8) {
			e8.printStackTrace();
		}
		
		
		setVisible(false);
		new main_screen(pin);
		
	}
	
}

	public static void main(String[] args) {
		new fastcash("");

	}

	

}
