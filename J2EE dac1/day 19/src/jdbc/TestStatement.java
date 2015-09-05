/*
 * Objective -- using Statement API with Text console
 * query = select * from my_emp 
 */
package jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//import oracle.jdbc.OracleDriver;

public class TestStatement {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		Connection cn = null;
		FileReader fin = null;
		Statement st = null;
		ResultSet rst = null;

		try {
			sc = new Scanner(System.in);
			System.out.println("Enter property file details");
			fin = new FileReader(sc.next());
			Properties p = new Properties();
			p.load(fin);
			System.out.println("props " + p);
			// load jdbc drvr class
			Class.forName(p.getProperty("jdbc.drivers"));
			// String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
			String dbURL = p.getProperty("jdbc.url");
			// lab pc dbURL="jdbc:oracle:thin:@localhost:1521:xe
			cn = DriverManager.getConnection(dbURL,
					p.getProperty("jdbc.username"),
					p.getProperty("jdbc.password"));
			// cn --> st
			st = cn.createStatement();// rst attached to this st --- type
										// forward & read only
			String sql = "select * from my_emp";
			rst = st.executeQuery(sql);// parsing--syntax chk--compile-exec
			// rst handling
			while (rst.next())
				System.out.printf(
						"Emp Id %d Name %10s Salary %.1f Join Date %s %n",
						rst.getInt(1), rst.getString(2),
						rst.getDouble("salary"), rst.getDate(6));
			// System.out.println("connection inst " + cn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rst != null)
				rst.close();
			if (st != null)
				st.close();
		
			if (cn != null)
				cn.close();
			if (fin != null)
				fin.close();
			if (sc != null)
				sc.close();

		}

	}

}
