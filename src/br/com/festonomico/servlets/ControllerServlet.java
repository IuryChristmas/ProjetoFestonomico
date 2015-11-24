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
@WebServlet("/festonomica")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * essa var parametro, vai receber o valor "logica" 
		 * que vai ser enviado pelo formulário ou será setado direto por uma das lógicas
		 * ex: na lógica RemoveProdutoLogica eu estou setando o valor de lógica direto lá
		 */
		String parametro = request.getParameter("logica");
		//LEMBRETE: O nomeDaClasse DEVE ESTAR DE ACORDO COM A ORGANIZAÇÃO DOS PACOTES DO PROJETO DE VOCÊS
		String nomeDaClasse = "br.com.festonomico.logica." + parametro;
		
		try{
			//o class.forName vai carregar a classe desejada
			Class classe = Class.forName(nomeDaClasse);
			/*
			 * aqui nós estamos instanciando a Logica
			 * o classe.newInstance() é meio auto explicativo quanto a isso
			 * a var pagina vai receber logica que possuí um único método chamado executa
			 * o método executa ele que é o responsável por implementar o request, response
			 * dá uma olhada na interface Logica que tá no pacote: br.com.festonomico.logica
			 */
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			//faz o redirecionamento
			request.getRequestDispatcher(pagina).forward(request, response);
			//tratamento da exceção
		}catch(Exception e){
			System.out.println("a lógica lançou uma exceção " + e);
		}
	
	}

}
