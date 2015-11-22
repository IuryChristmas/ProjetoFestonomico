package br.com.festonomico.serviceImpl.test;

import org.junit.Test;

import br.com.festonomico.modelo.Usuario;
import br.com.festonomico.service.UsuarioService;
import br.com.festonomico.serviceImpl.UsuarioServiceImpl;

public class UsuarioServiceImplTest {

	private UsuarioService usuarioService;
	
	@Test
	public void salvarUsuarioTest() {
		
		usuarioService = new UsuarioServiceImpl();
		
		Usuario usuario = new Usuario();
		usuario.setNome("test 12.11.15");
		usuario.setEmail("test@Gmail.com");
		usuario.setSenha("123112");
		
		usuarioService.salvarUsuario(usuario);
		
	}
	
}
