package jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//import oracle.jdbc.OracleDriver;

public class TestDBConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		Connection cn = null;
		FileReader fin = null;

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

			System.out.println("connection inst " + cn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cn != null)
				cn.close();
			if (fin != null)
				fin.close();
			if (sc != null)
				sc.close();

		}

	}

}
