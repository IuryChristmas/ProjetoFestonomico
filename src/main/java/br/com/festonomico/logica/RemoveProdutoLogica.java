package br.com.festonomico.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

public class RemoveProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(request.getParameter("id")));
		ProdutoDao dao = new ProdutoDaoImpl();
		dao.removeProduto(produto);
		
		return "festonomica?logica=ListaProdutoLogica";
	}

}
