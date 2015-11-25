package br.com.festonomico.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionJNDI {
	 
	public static Connection getConnection(){
	 
		Connection con = null;
		
		try {
			InitialContext context = new InitialContext();
	 
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Festonomico");
		
			con = ds.getConnection();
			
		} catch(SQLException e){
			
		} catch (NamingException e) {
			System.out.println("Erro lockup");
			e.getMessage();
		}
		
		return con;
	}

}
