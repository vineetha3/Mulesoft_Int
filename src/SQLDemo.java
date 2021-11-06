import java.sql.*;

public class SQLDemo {
	
	public static void main(String[] args)
	{
		try {
			
		
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:product.db");
		if(con!=null)
		{
			System.out.println("Yes !");
			Statement stmt = con.createStatement();
			//int r = stmt.executeUpdate("create table products(Num int primary key, Name text)");
			//System.out.println(r);
			PreparedStatement pstmt =con.prepareStatement("insert into products values(?,?)");
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Vinz");
			
			int r = pstmt.executeUpdate();
			ResultSet rs = stmt.executeQuery("select * from products");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			
			con.close();
		}
		
		else
		{
			System.out.println("No !");
		}
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
