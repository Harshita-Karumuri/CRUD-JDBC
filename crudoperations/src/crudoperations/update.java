package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String username="root";
    private static final String password="root";
    private static final String url="jdbc:mysql://localhost:3306/registration";
    private static Connection conn;
    private static PreparedStatement pmst;
   
    public static void main(String[] args) {
		try {
			Scanner scr=new Scanner(System.in);
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter tablename");
			String sql="update "+scr.next()+" set id=?, name=?,email=?, password=?, where id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter id");
			pmst.setInt(1, scr.nextInt());
			System.out.println("enter name");
			pmst.setString(2, scr.next());
			System.out.println("enter email");
			pmst.setString(3, scr.next());
			System.out.println("enter password");
			pmst.setString(4, scr.next());
			System.out.println("provide id");
			pmst.setInt(5, scr.nextInt());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("updated");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			scr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
