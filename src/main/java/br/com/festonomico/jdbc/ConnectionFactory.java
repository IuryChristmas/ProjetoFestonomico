package br.com.festonomico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe responsável pela conexão com o banco de dados
 * @author andersonmartins
 *
 */
public class ConnectionFactory {	
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver"; 
	
	private static final String URL = "jdbc:mysql://198.71.227.94:3306/festonomico";
	
	private static final String USER = "festonomico";
	
	private static final String PASS = "100anos";
	
	//programa � pra funcionar com o banco online, mesmo sem estar funcionando no computador
	
	/*private static final String URL = "jdbc:mysql://localhost/festonomico";
	private static final String USER = "root";
	private static final String PASS = "root";*/
	
	public Connection getConnection(){
		Connection con = null;
		try{			
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL,USER,PASS);
		}catch(SQLException ex){
			System.out.println("Erro ao conectar o banco");
			ex.getMessage();
		}catch(ClassNotFoundException ex){
			System.out.println("Driver de conexao nao encontrado");
			ex.getMessage();
		}		
		return con;
		
	}

}
