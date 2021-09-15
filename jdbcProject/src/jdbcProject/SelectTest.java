package jdbcProject;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		System.out.println("Driver registered.....");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Newuser123");
		System.out.println("Connected to the database "+conn);
	}

}
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver registered.....");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Newuser123");
			System.out.println("Connected to the database "+conn);
			
			Statement statement= conn.createStatement();
			System.out.println("Statement created : "+statement);
			
			Scanner scan =new Scanner(System.in);
			System.out.println("Enter job to search");
			String v_job = scan.nextLine();
			
			ResultSet rs = statement.executeQuery("select * from Emp where job= "+"'"+v_job+"'");
			
			while(rs.next())
			{
				System.out.println("Emp number: "+rs.getInt(1));
				System.out.println("Emp name: "+rs.getString(2));
				System.out.println("Emp job: "+rs.getString(3));
				System.out.println("Emp manager: "+rs.getString(4));
				System.out.println("Emp joining: "+rs.getString(5));
				System.out.println("Emp salary: "+rs.getInt(6));
				System.out.println("Emp comm: "+rs.getInt(7));
				System.out.println("Emp dept: "+rs.getInt(8));
				System.out.println("---------------------------------------------");
			}
			
			Scanner scan2 = new Scanner(System.in);
            System.out.println("Enter starting date : ");
            String fromDate = scan2.nextLine();

            Scanner scan3 = new Scanner(System.in);
            System.out.println("Enter ending date   : ");
            String toDate = scan3.nextLine();

            //ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between '01-Jan-81' and '31-Dec-81'");
            ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between "+"'"+fromDate+"'"+" and "+"'"+toDate+"'");
            while(dateRs.next())
			{
            System.out.println("Emp number: "+dateRs.getInt(1));
			System.out.println("Emp name: "+dateRs.getString(2));
			System.out.println("Emp job: "+dateRs.getString(3));
			System.out.println("Emp manager: "+dateRs.getString(4));
			System.out.println("Emp joining: "+dateRs.getString(5));
			System.out.println("Emp salary: "+dateRs.getInt(6));
			System.out.println("Emp comm: "+dateRs.getInt(7));
			System.out.println("Emp dept: "+dateRs.getInt(8));
			System.out.println("---------------------------------------------");
			}
            
            
			rs.close();
			conn.close();
			statement.close();
			System.out.println("db closed........");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}