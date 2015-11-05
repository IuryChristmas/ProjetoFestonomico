package br.com.festonomico.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.festonomico.dao.UsuarioDao;
import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Usuario;

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
	
	Connection con = null;
	
	public UsuarioDaoImpl() {
		// TODO: instanciar conexão jdbc
		con = new ConnectionFactory().getConnection();
	}
	
	@Override
	public Usuario obterUsuarPorId(int id) {
		String sql = "select *from usuario where id=?";
		Usuario usuario = new Usuario();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
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
			throw new RuntimeException(e);
		}
		return usuario;
	}

	@Override
	public void salvarUsuario(Usuario usuario) {
		String sql = "insert into usuario"
				+ " (id,email,nome,senha)"
				+ " values (?,?,?,?)";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		String sql = "delete from usuario where id=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getCodUsuario());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		String sql = "update usuario set nome=?, email=?, senha=? "
				+ "where id=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	}

}
