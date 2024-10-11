package billing_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class product {
	private Scanner sc;  //instance varible......
	private Connection con;
	public product(Scanner sc, Connection con) {
		this.sc=sc;
		this.con=con;
		
	}
	public void billing() {
		String pname;
		int qauntity;
		double  price;
		int id;
		System.out.print("--------------Product Items---------------------------------------------------");
		System.out.println("\n------------");
		System.out.println("|          |");
		System.out.println("|  Amul    |");
		System.out.println("|  Milk    |");
		System.out.println("|          |");
		System.out.println("-----------");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\n\nProduct Name:");
		pname=sc.nextLine();
		System.out.println("\n\nEnter  the Price:");
		price=sc.nextDouble();
		System.out.println("\n\nNumber  of  Qauntity:");
		qauntity =sc.nextInt();
		System.out.println("Product ID:");
		id=sc.nextInt();
		String query="INSERT INTO items(pname,price,qnty,id) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, pname);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, qauntity);
            preparedStatement.setInt(4, id);
             preparedStatement.executeUpdate();
            
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void details() {
		int id = 0;
		String pname;
		int quantity=0;
		double price=0;
		
		String details_query="SELECT * FROM items WHERE id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(details_query);
			preparedStatement.setInt(1,id );
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				  price = rs.getDouble("price");
                quantity = rs.getInt("qnty");
               
                //System.out.println(quantity + "\t\t" + price );
                
			}
	double total=quantity*price;
			System.out.println("Total: "+total);
			System.out.println("---------------Thank you for Shopping--------------------");
			System.out.println("Above price are inclusive of all taxes.This is computer generated binvoice and hence no signature required.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
