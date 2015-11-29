package br.com.festonomico.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns="/festonomica")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * essa var parametro, vai receber o valor "logica" 
		 * que vai ser enviado pelo formul�rio ou ser� setado direto por uma das l�gicas
		 * ex: na l�gica RemoveProdutoLogica eu estou setando o valor de l�gica direto l�
		 */
		String parametro = request.getParameter("logica");
		//LEMBRETE: O nomeDaClasse DEVE ESTAR DE ACORDO COM A ORGANIZA��O DOS PACOTES DO PROJETO DE VOC�S
		String nomeDaClasse = "br.com.festonomico.logica." + parametro;
		
		try{
			//eu esqueci o que o Class.forName faz, mas ele vai receber o noem da classe
			//justamente pra poder buscar a classe correta.
			Class classe = Class.forName(nomeDaClasse);
			/*
			 * aqui n�s estamos instanciando a Logica
			 * o classe.newInstance() � meio auto explicativo quanto a isso
			 * a var pagina vai receber logica que possu� um �nico m�todo chamado executa
			 * o m�todo executa ele que � o respons�vel por implementar o request, response
			 * d� uma olhada na interface Logica que t� no pacote: br.com.festonomico.logica
			 */
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			//faz o redirecionamento
			request.getRequestDispatcher(pagina).forward(request, response);
			//tratamento da exce��o
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	}

}