package br.com.festonomico.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

public class SelecionaProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		
		ProdutoDao dao = new ProdutoDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produto> produto = dao.getProduto(id);
		
		request.setAttribute("produto", produto);
		
		return "edita-produto.jsp";
	}

}
