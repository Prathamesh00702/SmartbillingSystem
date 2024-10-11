package billing_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Customer_info {
	private Scanner sc;
	private  Connection con;
	private String id, fn,add;

	public Customer_info(Scanner sc, Connection con) {
		this.sc=sc;
		this.con=con;
	}

	public void registration() {
		System.out.print("\t\t\t****-----------Welcome to Bill Management System---------****");
		System.out.println("\n-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t DMART_MULUND ");
		System.out.println("\t\t\t Mulund Goregaon link Road");
		System.out.println("\t\t\t Near Nirmal Nagar mulund(w)");
		System.out.println("\t\t\t Phone: 022-309XXXX");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		System.out.println("\n\nCustomerID:-");
		String id=sc.nextLine();
		System.out.println("\n\nFull Name:-");
		String fn=sc.nextLine();
		//sc.nextLine();
		System.out.println("\n\nAddress:-");
		String add=sc.nextLine();
		
		String query="INSERT INTO customer(id,full_name,address) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, fn);
            preparedStatement.setString(3, add);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registration Successfull!");
            } else {
                System.out.println("Registration Failed!");
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void display() {
		System.out.println("Cutomer ID: ");
		 id=sc.nextLine();
		
		String dis_query="SELECT * FROM customer WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(dis_query);
			preparedStatement.setString(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
                String fn = rs.getString("full_name");
                String add = rs.getString("address");
                System.out.println(id + "\t\t" + fn
                                   + "\t\t" + add);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
