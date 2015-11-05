package br.com.festonomico.serviceImpl;

import java.sql.SQLException;

import br.com.festonomico.dao.UsuarioDao;
import br.com.festonomico.daoimpl.UsuarioDaoImpl;
import br.com.festonomico.modelo.Usuario;
import br.com.festonomico.service.UsuarioService;

/**
 * Classe responsável por prover serviços de inclusão, 
 * alteração e exclusão de Usuários e objetos relacionados
 * @author andersonmartins
 *
 */
public class UsuarioServiceImpl implements UsuarioService{

	private	UsuarioDao dao = new UsuarioDaoImpl();

	@Override
	public Usuario obterUsuarPorId(int id) {
		Usuario usuario = new Usuario();
		
		try {
			usuario = getDao().obterUsuarPorId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usuario;
	}

	@Override
	public void salvarUsuario(Usuario usuario) {

		validarCamposObrigatorios(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		
		try {
			getDao().salvarUsuario(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		if(usuario.getCodUsuario()==null || usuario.getCodUsuario().equals("") || usuario.getCodUsuario()<=0) {
			int codUsuario = obterIdUsuarioPorEmailNome(usuario.getEmail(), usuario.getNome());
			usuario.setCodUsuario(codUsuario);
		}
		
		try {
			getDao().editarUsuario(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		boolean camposValidos = validarCamposObrigatorios(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		if(camposValidos) {
			try {
				getDao().editarUsuario(usuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int obterIdUsuarioPorEmailNome(String email, String nome) {
		int retorno = 0;
		return retorno;
	}
	
	/**
	 * Valida se os campos obrigatórios foram preenchidos;
	 * @param email
	 * @param nome
	 * @param senha
	 * @return
	 */
	private boolean validarCamposObrigatorios(String email, String nome, String senha) {
		if(email!= null && !email.equals("")
				&& senha!=null && !senha.equals("")
				&& nome!=null && !nome.equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
	public UsuarioDao getDao() {
		return dao;
	}

}
