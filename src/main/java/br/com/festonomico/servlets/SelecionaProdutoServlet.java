package br.com.festonomico.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

@WebServlet("/selecionaProduto")
public class SelecionaProdutoServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ProdutoDao dao = new ProdutoDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produto> produto = dao.getProduto(id);
		
		request.setAttribute("produto", produto);
		
		RequestDispatcher rd = request.getRequestDispatcher("edita-produto.jsp");
		rd.forward(request, response);
	}
	
}
