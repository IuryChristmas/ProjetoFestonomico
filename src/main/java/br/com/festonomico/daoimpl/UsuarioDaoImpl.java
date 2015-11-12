package br.com.festonomico.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.festonomico.dao.UsuarioDao;
import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Usuario;
import br.com.festonomico.serviceImpl.UsuarioServiceImpl;

/**
 * Classe responsável pelas implementações dos métodos de comunicao com a tabela Usuario
 * 
 * @author anderson.martins
 *
 */
public class UsuarioDaoImpl implements UsuarioDao {
	
	/*	4 etapas
	 * Abre conexão com o banco
	 * Executa SQL
	 * Recebe retorno
	 * Fecha conexão com o banco
	 */
	
	Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);
	
	Connection con = null;
	
	public UsuarioDaoImpl() {
		// TODO: instanciar conexão jdbc
		con = new ConnectionFactory().getConnection();
	}
	
	@Override
	public Usuario obterUsuarPorId(int id) {
		String sql = "select *from usuario where id=?";
		Usuario usuario = new Usuario();
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				usuario.setCodUsuario(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return usuario;
	}

	@Override
	public void salvarUsuario(Usuario usuario) {
		String sql = "insert into usuario"
				+ " (email,nome,senha)"
				+ " values (?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		String sql = "delete from usuario where id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		
	}

	@Override
	public void editarUsuario(Usuario usuario)  {
		String sql = "update usuario set nome=?, email=?, senha=? "
				+ "where id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}

}
