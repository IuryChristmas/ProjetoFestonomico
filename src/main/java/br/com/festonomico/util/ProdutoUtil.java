package br.com.festonomico.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.festonomico.modelo.Produto;
import br.com.festonomico.modeloTO.ProdutoTO;

/**
 * Classe util para métodos de conversão do Objeto Produto
 * @author andersonmartins
 *
 */
public class ProdutoUtil {

	private static DecimalFormat df ;
	
	public static List<ProdutoTO> toProduto(List<Produto> produtos) {
		List<ProdutoTO> listaExibir = new ArrayList<ProdutoTO>();
		if(!produtos.isEmpty() && produtos!= null) {
			for (Produto produto : produtos) {
				ProdutoTO produtoTO = new ProdutoTO();
				produtoTO.setId(produto.getId());
				produtoTO.setNome(produto.getNome());
				produtoTO.setPreco(restringirCasaDecimal(produto.getPreco()));
				produtoTO.setQuantidade(restringirCasaDecimal(produto.getQuantidade()));
				produtoTO.setTipoFesta(produto.getTipoFesta());
				
				listaExibir.add(produtoTO);
			}
		}
		
		return listaExibir;
	}
	
	/**
	 * Método para restringir para duas casas decimais
	 * 
	 * @param valor (Double)
	 * @return String
	 */
	public static String restringirCasaDecimal(Double valor){
		df = new DecimalFormat("0.##");
		
		String valorExibir = df.format(valor);
		
		return valorExibir;
	}

}
