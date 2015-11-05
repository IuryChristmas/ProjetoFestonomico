package br.com.festonomico.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.festonomico.dao.UsuarioDao;
import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Produto;
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
	public Usuario obterUsuarPorId(int id) throws SQLException {
		String sql = "select *from usuario where cod_usuario=?";
		Usuario usuario = new Usuario();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			usuario.setCodUsuario(rs.getInt("cod_usuario"));
			usuario.setEmail(rs.getString("email"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
		}
		rs.close();
		stmt.close();
		
		return usuario;
	}

	@Override
	public void salvarUsuario(Usuario usuario) throws SQLException {
		String sql = "insert into usuario"
				+ " (email,nome,senha)"
				+ " values (?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, usuario.getEmail());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getSenha());
		
		stmt.execute();
		stmt.close();
	}

	@Override
	public void excluirUsuario(Usuario usuario) throws SQLException {
		String sql = "delete from usuario where cod_usuario=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, usuario.getCodUsuario());
		
		stmt.execute();
		stmt.close();
	}

	@Override
	public void editarUsuario(Usuario usuario) throws SQLException {
		String sql = "update usuario set nome=?, email=?, senha=? "
				+ "where cod_usuario=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, usuario.getCodUsuario());
		stmt.setString(2, usuario.getNome());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		
		stmt.execute();
			stmt.close();
	}

	@Override
	public int obterIdUsuarioPorEmailNome(String email, String nome) {
		String sql = "select cod_usuario from usuario" 
				+ "where email=? and nome=?";
		
		
		return 0;
	}

	@Override
	public List<Usuario> obterTodosUsuarios() throws SQLException {
		List<Usuario> listaRetorno = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		
		PreparedStatement stmt = con.prepareStatement(sql);
					
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Usuario usuario = new Usuario();
			
			usuario.setCodUsuario(rs.getInt("cod_usuario"));
			usuario.setEmail(rs.getString("emai"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			
			listaRetorno.add(usuario);
		
		}
		rs.close();
		stmt.close();
	
		
		return null;
	}

}
