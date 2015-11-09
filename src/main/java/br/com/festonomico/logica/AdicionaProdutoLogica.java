package br.com.festonomico.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.daoimpl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

public class AdicionaProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
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
		
		return "produto-adicionado.jsp";
	}

}
