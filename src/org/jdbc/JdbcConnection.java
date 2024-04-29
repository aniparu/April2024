package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {

	public static void main(String[] args) {

		// 1. Load the driver

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Connect to database
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");

			// 3. Write a SQL query
			String sql = "Select * from student";

			// 4. Prepare the statement
			PreparedStatement ps = c.prepareStatement(sql);

			// 5. execute query
			ResultSet rs = ps.executeQuery();

			// 6. Iterate the results
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int cid = rs.getInt("cid");
				System.out.println(sid);
				System.out.println(sname);
				System.out.println(cid);

			}

			// 7. Close the db connection
			c.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
}
