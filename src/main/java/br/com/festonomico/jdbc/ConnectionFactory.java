package br.com.festonomico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver"; 
	
	private static final String URL = "jdbc:mysql://localhost/dsw";
	
	private static final String USER = "root";
	
	private static final String PASS = "123456";
	
	public Connection getConnection(){
		Connection con = null;
		try{			
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL,USER,PASS);
		}catch(SQLException ex){
			System.out.println("Erro ao conectar o banco");
			ex.getMessage();
		}catch(ClassNotFoundException ex){
			System.out.println("Driver de conex�o n�o encontrado");
			ex.getMessage();
		}		
		return con;
	}

}
