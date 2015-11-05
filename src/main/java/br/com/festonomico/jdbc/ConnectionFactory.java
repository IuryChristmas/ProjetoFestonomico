package br.com.festonomico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		Connection con = null;
		try{			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/dsw";
			con = DriverManager.getConnection(url,"root","123456");
		}catch(SQLException ex){
			System.out.println("Erro ao conectar o banco");
			ex.getMessage();
		}catch(ClassNotFoundException ex){
			System.out.println("Driver de conexão não encontrado");
			ex.getMessage();
		}		
		return con;
	}

}
