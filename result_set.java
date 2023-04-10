import java.io.*;
import java.sql.*;

public class result_set {

  public static void main(String args[]) throws SQLException {
    Connection con = DriverManager.getConnection(
      "jdbc:mysql://localhost/mydatabase",
      "root",
      "password"
    );

    Statement stmt = con.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_UPDATABLE
    );


    String query = "Select * from Customers";
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      if (rs.getInt("ID") == 5) {
        rs.updateInt("Salary", 11000);
        rs.updateRow();
      }
    }
  }
}
