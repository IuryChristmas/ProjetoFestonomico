package br.com.festonomico.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDAO;
import br.com.festonomico.modelo.Produto;

@WebServlet("/editaProduto")
public class EditaProdutoServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(request.getParameter("id")));
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(Double.parseDouble(request.getParameter("valor")));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.alteraProduto(produto);
		
		RequestDispatcher rd = request.getRequestDispatcher("listaProduto");
		rd.forward(request, response);
	}
	
}
