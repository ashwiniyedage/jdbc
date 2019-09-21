import java.sql.*;
import java.util.*;

public class TestApplication {

	public static void main(String[] args)
	{
			int ch1;
			int eid;
			String name,y;
			int sal;
			Connection con=null;
			PreparedStatement ps =null;
			Scanner sc=new Scanner(System.in);
			ResultSet rs=null;
			Statement st=null;
		//step1-load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");  //forName() is static method
			
		//step2-connection to db
			try {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ashwini");
				System.out.println("Connection is done.....");
		 do{
				System.out.println("\n1.Insert \n2.Delete \n3.Update \n4.Search \n5.Display \n6.Exit");
				System.out.println("Enter your choice :");
				int ch=sc.nextInt();	
				switch(ch)
				{
				case 1:
					System.out.println("Enter the id,name,salary");
					ps=con.prepareStatement("insert into emp71 values(?,?,?)");
					ps.setInt(1, sc.nextInt());
					ps.setString(2, sc.next());
					ps.setInt(3, sc.nextInt());
					int i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("Recored save...");
					}
					break;
				case 2:
					ps=con.prepareStatement("delete from emp71 where emp_id=?");
					System.out.println("Enter the emp id which u want to delete");
					eid=sc.nextInt();
					ps.setInt(1, sc.nextInt());
					i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("Record deleted....");
					}
					break;
				case 3:
					//update
					
					System.out.println("Enter the empid to update new salary");
					//eid=sc.nextInt();
					//sal=sc.nextInt();
					ps=con.prepareStatement("update emp71 set salary=? where emp_id=?");
					ps.setInt(1, sc.nextInt());
					ps.setInt(2, sc.nextInt());
					i=ps.executeUpdate();
					if(i>0)
					{
						System.out.println("Record updated....");
					}
					break;
				case 4:
					//search
					System.out.println("Enter the emp id which u want to search :");
					eid=sc.nextInt();  
					ps=con.prepareStatement("select * from emp71 where emp_id=?");
					ps.setInt(1, eid);
					rs=ps.executeQuery();
					if(rs.next())//next points to 1st row
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
					}
					else
					{
						System.out.println("Recrd not fouond...");
					}
					break;
				case 5:
					//Display
					String str="select * from emp71";
					st=con.createStatement();
					rs=st.executeQuery(str);
					while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
						}
					break;
				case 6:
					return;
				/*default:
					System.out.println("Exit");*/
				}
				System.out.println("Do u want to continue..?(press 1)");
				ch1=sc.nextInt();
			}while(ch1==1);
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
	