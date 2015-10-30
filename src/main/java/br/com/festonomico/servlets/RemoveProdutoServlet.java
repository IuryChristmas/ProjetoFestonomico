package br.com.festonomico.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDAO;
import br.com.festonomico.modelo.Produto;

@WebServlet("removeProduto")
public class RemoveProdutoServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(request.getParameter("id")));
		ProdutoDAO dao = new ProdutoDAO();
		dao.removeProduto(produto);
			
		RequestDispatcher rd = request.getRequestDispatcher("selecionaProduto");
		rd.forward(request, response);
	}
	
}
