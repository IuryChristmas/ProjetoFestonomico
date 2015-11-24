package br.com.festonomico.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

public class ListaProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		String idSession = request.getSession().getId();
		ProdutoDao dao = new ProdutoDaoImpl();
		dao.callProcedure(idSession);
		List<Produto> produtos = dao.getLista();
		
		request.setAttribute("produtos", produtos);
		return "lista-produtos.jsp";
	}

}
