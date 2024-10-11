package billing_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Billing_app {
	 private static final String url = "jdbc:mysql://localhost:3306/billing_system";
	    private static final String username = "root";
	    private static final String password = "root";

	public static void main(String[] args) {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
		try {
			Connection con=DriverManager.getConnection(url, username, password);
			Scanner sc =new Scanner(System.in);
			Customer_info customer=new Customer_info(sc,con);
			product pro=new  product(sc,con);
			customer.registration();
			//customer.display();
			//pro.billing();
			//pro.details();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
