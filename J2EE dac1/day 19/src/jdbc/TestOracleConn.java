package jdbc;

import java.sql.*;
//import oracle.jdbc.OracleDriver;

public class TestOracleConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//load jdbc drvr class 
		Class.forName("oracle.jdbc.OracleDriver");
		String dbURL="jdbc:oracle:thin:@localhost:1521:orcl";
		//lab pc   dbURL="jdbc:oracle:thin:@localhost:1521:xe
		try(Connection cn=DriverManager.getConnection(dbURL, "scott", "tiger"))
		{
			System.out.println("connected to Oracle");
		} catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
