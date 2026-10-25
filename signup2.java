package BankManagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class signup2 extends JFrame implements ActionListener{
	JComboBox religioncombobox, incomecombobox, educationcombobox, occupationcombobox;
	String formno;
	JButton next;
	JTextField nationality,pancardtext,adhartext;
	JLabel label1, label2, label3, label4, label5,label6,label7,label8,label9,label10;
	
	signup2(String formno){
		super("Application Form");
		
		
		this.formno = formno;
		
		label1 = new JLabel("Additional Details");
		label1.setFont(new Font("elephant",Font.BOLD,22));
		label1.setBounds(200, 50, 250, 30);
		add(label1);
		
		label2 = new JLabel("Nationaity:");
		label2.setFont(new Font("elephant",Font.BOLD,22));
		label2.setBounds(100, 100, 250, 30);
		add(label2);
		nationality = new JTextField();
		nationality.setBounds(260, 100, 250, 30);
		nationality.setFont(new Font("elephant",Font.PLAIN,20));
		add(nationality);
		
		label3 = new JLabel("Religion:");
		label3.setFont(new Font("elephant",Font.BOLD,22));
		label3.setBounds(100, 158, 100, 30);
		add(label3);
		String religion[] = {"hindu","muslim","sikh","punjabi","other"};
		religioncombobox = new JComboBox(religion);
		religioncombobox.setFont(new Font("elephant",Font.BOLD,20));
		religioncombobox.setBackground(new Color(252,208,95));
		religioncombobox.setBounds(250, 160, 300, 30);
		add(religioncombobox);
		
		label4 = new JLabel("income");
		label4.setFont(new Font("elephant",Font.BOLD,22));
		label4.setBounds(100, 210, 100, 30);
		add(label4);
		String income[] = {"null","<100000","<500000","upto100000","above10lakhs"};
		incomecombobox = new JComboBox(income);
		incomecombobox.setFont(new Font("elephant",Font.BOLD,22));
		incomecombobox.setBounds(250, 210, 300, 30);
		add(incomecombobox);
		
		label5 = new JLabel("Education");
		label5.setFont(new Font("elephant",Font.BOLD,22));
		label5.setBounds(100, 270, 120, 30);
		add(label5);
		String education[] = {"10th","12th","Graduate","null"};
		educationcombobox = new JComboBox(education);
		educationcombobox.setFont(new Font("elephant",Font.BOLD,22));
		educationcombobox.setBounds(250, 270, 300, 30);
		add(educationcombobox);
		
		label6 = new JLabel("occupation");
		label6.setFont(new Font("elephant",Font.BOLD,22));
		label6.setBounds(100, 320, 150, 30);
		add(label6);
		String occupation[] = {"student","farmer","business","employee"};
		occupationcombobox = new JComboBox(occupation);
		occupationcombobox.setFont(new Font("elephant",Font.BOLD,22));
		occupationcombobox.setBounds(250, 320, 300, 30);
		add(occupationcombobox);
		
		label7 = new JLabel("Pancard No:");
		label7.setFont(new Font("elephant",Font.BOLD,22));
		label7.setBounds(100, 380, 250, 30);
		add(label7);
		pancardtext = new JTextField();
		pancardtext.setBounds(260, 380, 250, 30);
		pancardtext.setFont(new Font("elephant",Font.PLAIN,20));
		add(pancardtext);
		
		label8 = new JLabel("Adhar No:");
		label8.setFont(new Font("elephant",Font.BOLD,22));
		label8.setBounds(100, 440, 250, 30);
		add(label8);
		adhartext = new JTextField();
		adhartext.setBounds(260, 440, 250, 30);
		adhartext.setFont(new Font("elephant",Font.PLAIN,20));
		add(adhartext);
		
		label9 = new JLabel("Form No:");
		label9.setFont(new Font("elephant",Font.BOLD,12));
		label9.setBounds(400, 20, 150, 30);
		add(label9);
		label10 = new JLabel(formno);
		label10.setFont(new Font("elephant",Font.BOLD,12));
		label10.setBounds(500, 20, 80, 30);
		add(label10);
		
		next = new JButton("Next");
		next.setFont(new Font("elephant",Font.BOLD,22));
		next.setBounds(450, 500, 100, 30);
		next.addActionListener(this);
		add(next);
		
		
		
		
		setLayout(null);
		setSize(600, 600);
		setLocation(400, 150);
		getContentPane().setBackground(new Color(255,253,208));
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nation = nationality.getText();
		String religion =(String)religioncombobox.getSelectedItem();
		String income =(String)incomecombobox.getSelectedItem();
		String education =(String)educationcombobox.getSelectedItem();
		String occupation =(String)occupationcombobox.getSelectedItem();
		String pan = pancardtext.getText();
		String adhar = adhartext.getText();
		
		
		try {
			if(pancardtext.getText().equals("") || adhartext.getText().equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Fill all the Fields");
			}else {
				connection con2 = new  connection();
				String q = "insert into signuptwo values('"+formno+"','"+nation+"','"+religion+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"')";
				con2.st.executeUpdate(q);
				new signup3(formno);
				setVisible(false);
				
				
			}
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	
	}
	
	public static void main(String[]args){
		
		new signup2("");
	}
		
	}


