package br.com.festonomico.service;

import br.com.festonomico.modelo.Usuario;
/**
 * Classe responsável por prover serviços de inclusão, 
 * alteração e exclusão de Usuários e objetos relacionados
 * @author andersonmartins
 *
 */
public interface UsuarioService {

	public Usuario obterUsuarPorId(int id);
	
	public void salvarUsuario(Usuario usuario);
	
	public void excluirUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
	
	int obterIdUsuarioPorEmailNome(String email, String nome);

	
}
