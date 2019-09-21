import java.sql.*;
import java.util.Scanner;

public class TestDatabase {

	public static void main(String[] args)
	{
			Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps =null;
		//load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
		//conection
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ashwini");
		
		System.out.println("Connection is done...");
		
			System.out.println("\n 1.insert");
			System.out.println("Enter your choice :");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the id,name,salary");
				ps=con.prepareStatement("insert into jdbc values(?,?,?)");
				ps.setInt(1, sc.nextInt());
				ps.setString(2, sc.next());
				ps.setInt(3, sc.nextInt());
				int i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("Recored save...");
				}
				break;
			}
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
