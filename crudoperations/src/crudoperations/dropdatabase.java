package crudoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class dropdatabase {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
    public static void main(String[] args) {
		try {
			Scanner scr = new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("enter database name");
			String sql="drop database "+scr.next();
		    pmst=conn.prepareStatement(sql);
		    
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("database dropped");
			}
			else {
				System.out.println("error");
			}
			pmst.close();
			conn.close();
		}
		catch (Exception e) {
	          e.printStackTrace();
		}
	}
}
