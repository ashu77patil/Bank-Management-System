package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class signup3 extends JFrame implements ActionListener{
	String formno;
	JRadioButton t1,t2;
	JButton submit, cancel;
	JCheckBox s1,s2,s3,s4,s5;
	
	
	signup3(String formno){
		this.formno = formno;
	    
		
		super("Account Details");

		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(60, 40, java.awt.Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(20, 10, 60, 40);
		add(Image);
		
		JLabel text1 = new JLabel("Accounts Details");
		text1.setFont(new Font("elephant",Font.BOLD,15));
		text1.setBounds(90, 24, 150, 30);
		add(text1);
		
		JLabel atype = new JLabel("Accounts Type");
		atype.setFont(new Font("elephant",Font.BOLD,15));
		atype.setBounds(80, 100, 150, 30);
		add(atype);
		t1 = new JRadioButton("Savings");
		t1.setFont(new Font("Elephant",Font.BOLD,15));
		t1.setBounds(250, 100, 180, 30);
		add(t1);
		t2 = new JRadioButton("Current");
		t2.setFont(new Font("Elephant",Font.BOLD,15));
		t2.setBounds(390, 100, 180, 30);
		add(t2);
		ButtonGroup acctype = new ButtonGroup();
		acctype.add(t1);
		acctype.add(t2);
		
		JLabel accno = new JLabel("Account No:");
		accno.setFont(new Font("elephant",Font.BOLD,15));
		accno.setBounds(80, 160, 150, 30);
		add(accno);
		JLabel ano = new JLabel("XXXX-XXXX-XXXX-2609");
		ano.setFont(new Font("elephant",Font.BOLD,15));
		ano.setBounds(250, 160, 250, 30);
		add(ano);
		JLabel atextcap = new JLabel("(Your 16-digit Account No.)");
		atextcap.setFont(new Font("elephant",Font.HANGING_BASELINE,10));
		atextcap.setBounds(80, 175, 250, 30);
		add(atextcap);
		JLabel anocap = new JLabel("(This will be appear on your Passbook)");
		anocap.setFont(new Font("elephant",Font.HANGING_BASELINE,10));
		anocap.setBounds(250, 175, 350, 30);
		add(anocap);
		
		JLabel pintext = new JLabel("PIN:");
		pintext.setFont(new Font("elephant",Font.BOLD,15));
		pintext.setBounds(80, 210, 150, 30);
		add(pintext);
		JLabel pinno = new JLabel("XXXX");
		pinno.setFont(new Font("elephant",Font.BOLD,15));
		pinno.setBounds(250, 210, 150, 30);
		add(pinno);
		
		JLabel servicetext = new JLabel("Service Required:");
		servicetext.setFont(new Font("elephant",Font.BOLD,15));
		servicetext.setBounds(80, 270, 150, 30);
		add(servicetext);
		s1 = new JCheckBox("Net Banking");
		s1.setFont(new Font("Elephant",Font.CENTER_BASELINE,12));
		s1.setBounds(200, 300, 150, 30);
		add(s1);
		s2 = new JCheckBox("ATM");
		s2.setFont(new Font("Elephant",Font.CENTER_BASELINE,12));
		s2.setBounds(80, 300, 100, 30);
		add(s2);
		s3 = new JCheckBox("E-Statement");
		s3.setFont(new Font("Elephant",Font.CENTER_BASELINE,12));
		s3.setBounds(200, 350, 150, 30);
		add(s3);
		s4 = new JCheckBox("ChequeBook");
		s4.setFont(new Font("Elephant",Font.CENTER_BASELINE,12));
		s4.setBounds(80, 350, 150, 30);
		add(s4);
		s5 = new JCheckBox("I Declared That The Above Details Are True As Per My Knowledge",true);
		s5.setFont(new Font("Elephant",Font.CENTER_BASELINE,12));
		s5.setBounds(80, 450, 650, 20);
		add(s5);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("elephant",Font.BOLD,22));
		submit.setBounds(200, 500, 150, 30);
		submit.setBackground(new Color(105,105,105));
		submit.addActionListener(this);
		add(submit);
		cancel = new JButton("cancel");
		cancel.setFont(new Font("elephant",Font.BOLD,22));
		cancel.setBounds(400, 500, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
	
		
		
		
		setSize(600, 600);
		setLayout(null);
		getContentPane().setBackground(new Color(255,253,208));
		setLocation(290,150);
		setVisible(true);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String atype = null;
				if(t1.isSelected()) {
					atype = "savings account";
				}else if(t2.isSelected()) {
					atype = "current account";
				}
				
				
		Random ran = new Random();
		long first7 =(ran.nextLong() % 90000000L) + 14099630000000L;
		String accno = "" + Math.abs(first7);
		
		long first3 = (ran.nextLong() % 9000L) + 1000L;
		String pin= "" + Math.abs(first3);
				
		String check = null;
		if(s1.isSelected()) {
			check = check + "NetBanking";
		}else if(s2.isSelected()) {
			check = check +"ATM";
		}else if(s3.isSelected()) {
			check = check +"E-statement";
		}else if(s4.isSelected()) {
			check = check + "ChequeBook";
		}
		
		try{
			if(e.getSource()==submit) {
				if(atype.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all the fields");
				}else {
					
					connection con3 = new connection();
					String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+accno+"','"+pin+"','"+check+"')";
					String q2 = "insert into login values('"+formno+"','"+accno+"','"+pin+"',)";
					con3.st.executeUpdate(q1);
					con3.st.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "acc no:"+accno+"\n Pin:"+pin);
					new Deposit(pin);
					setVisible(false);
				}
			}else if(e.getSource()==cancel){
				System.exit(0);
			}
			
			
			
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	
	public static void main(String[]args) {
		new signup3("");
		
	}


	

}
