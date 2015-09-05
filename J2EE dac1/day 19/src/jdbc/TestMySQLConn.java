package jdbc;

import java.sql.*;
//import oracle.jdbc.OracleDriver;

public class TestMySQLConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//load jdbc drvr class 
		Class.forName("com.mysql.jdbc.Driver");
	//	String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
		String dbURL="jdbc:mysql://localhost:3306/testjdbc";
		//lab pc   dbURL="jdbc:oracle:thin:@localhost:1521:xe
		try(Connection cn=DriverManager.getConnection(dbURL, "root", "root"))
		{
			System.out.println("connected to MySQL");
		} catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
