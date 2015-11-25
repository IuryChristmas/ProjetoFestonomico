package br.com.festonomico.dao;

import br.com.festonomico.modelo.Usuario;

/**
 * Classe respons�vel pelas assinaturas dos m�todos de comunica��o com a tabela Usuario
 * 
 * @author anderson.martins
 *
 */
public interface UsuarioDao {
	
	Usuario obterUsuarPorId(int id);
	
	void salvarUsuario(Usuario usuario);
	
	void excluirUsuario(Usuario usuario);
	
	void editarUsuario(Usuario usuario);

}
