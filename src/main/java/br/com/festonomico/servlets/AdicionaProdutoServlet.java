package br.com.festonomico.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

@WebServlet("/adicionaProduto")
public class AdicionaProdutoServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		//recebe os parametros da pagina jsp
		String nome = request.getParameter("nome");
		String quantidade = request.getParameter("quantidade");
		String preco = request.getParameter("valor");
		//instancia Produto e seta os valores com os parametros recebidos da pagina jsp
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setQuantidade(Integer.parseInt(quantidade));
		produto.setPreco(Double.parseDouble(preco));
		//instancia ProdutoDAO e salva no BD os dados
		ProdutoDao dao = new ProdutoDaoImpl();
		dao.insereProduto(produto);
		RequestDispatcher rd = request.getRequestDispatcher("produto-adicionado.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/produto-adicionado.jsp");
		rd.forward(request, response);
	}
	
}
