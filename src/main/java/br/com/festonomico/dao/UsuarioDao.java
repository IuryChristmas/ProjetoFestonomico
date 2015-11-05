package br.com.festonomico.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.festonomico.modelo.Usuario;

/**
 * Classe respons�vel pelas assinaturas dos m�todos de comunica��o com a tabela Usuario
 * 
 * @author anderson.martins
 *
 */
public interface UsuarioDao {
	
	public Usuario obterUsuarPorId(int id) throws SQLException;
	
	public void salvarUsuario(Usuario usuario) throws SQLException;
	
	public void excluirUsuario(Usuario usuario) throws SQLException;
	
	public void editarUsuario(Usuario usuario) throws SQLException;
	
	int obterIdUsuarioPorEmailNome(String email, String nome) throws SQLException;
	
	List<Usuario> obterTodosUsuarios() throws SQLException;

}
