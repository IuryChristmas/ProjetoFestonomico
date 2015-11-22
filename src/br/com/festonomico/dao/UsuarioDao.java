package br.com.festonomico.dao;

import java.sql.SQLException;

import br.com.festonomico.modelo.Usuario;

/**
 * Classe respons�vel pelas assinaturas dos m�todos de comunica��o com a tabela Usuario
 * 
 * @author anderson.martins
 *
 */
public interface UsuarioDao {
	
	public Usuario obterUsuarPorId(int id);
	
	public void salvarUsuario(Usuario usuario);
	
	public void excluirUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);

}
