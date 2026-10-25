package BankManagementsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
	Connection con;
	Statement st;
	public connection(){
		try {
			con = DriverManager.getConnection("JDBC:mysql://localhost:3306/bankmanagement","root","shihtzi14");
			st = con.createStatement();
			
				
				
				
		}catch(Exception e){
			e.printStackTrace();
			
		}

		
	}
}


