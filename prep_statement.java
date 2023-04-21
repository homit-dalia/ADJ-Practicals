import java.io.*;
import java.sql.*;

public class prep_statement {

	public static void main(String[] args)
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");  


		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost/mydatabase",
			"root",
			"password"
		  );

		try {
			PreparedStatement stmt=con.prepareStatement("INSERT into EMPLOYEE values(?,?,?)");
			stmt.setString(1,"Homit Dalia");
			stmt.setInt(2,5000);
			stmt.executeUpdate();

			stmt.setString(1,"Homit Dalia");
			stmt.setInt(2,5000);
			stmt.executeUpdate();

            String QUERY = "SELECT id, first, age FROM Registration";
            ResultSet rs = stmt.executeQuery(QUERY);

            while(rs.next()){
                
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.print(", Age: " + rs.getInt("age"));
             }
		}
		catch (Exception e) {
            
			System.out.println(e);
		}
	}
}
