package br.com.festonomico.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Produto;
import br.com.festonomico.modelo.TipoFesta;

/**
 * Classe responsável por prover a implementação dos métodos
 * de comunicação com a tabela produto
 * @author andersonmartins
 *
 */
public class ProdutoDaoImpl implements ProdutoDao {

	Logger LOG = Logger.getLogger(ProdutoDaoImpl.class);
	
	Connection con = null;
	
	public ProdutoDaoImpl(){
		con = new ConnectionFactory().getConnection();
	}	
	/**
	 * Método de inserção de produto na tabela produto_exibir
	 * 
	 * @param produto
	 * @exception SQLException
	 */
	@Override
	public void insereProduto(Produto produto){
		String sql = "insert into produto_exibir"
				+ " (nome,quantidade_por_pessoa,preco_unitario,tipo_festa)"
				+ " values (?,?,?,?)";

		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());
			stmt.setString(4, produto.getTipoFesta().getDescricao());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		
	}
	//lista todos produtos do sistema
	@Override
	public List<Produto> getLista(String IdSessao){
		String sql = "select * from produto_exibir where id_sessao =?";
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
						
			stmt.setString(1, IdSessao);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getDouble("quantidade_por_pessoa"));
				produto.setPreco(rs.getDouble("preço_unitario"));
				String tipoFesta = rs.getString("tipo_festa");
				
				if (tipoFesta.equalsIgnoreCase(TipoFesta.ADULTA.getDescricao())) {
					produto.setTipoFesta(TipoFesta.ADULTA);
				}else if(tipoFesta.equalsIgnoreCase(TipoFesta.INFANTIL.getDescricao())) {
					produto.setTipoFesta(TipoFesta.INFANTIL);
				}else{
					produto.setTipoFesta(TipoFesta.TODOS);
				}
				
				produtos.add(produto);
			
			}
			rs.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		
		return produtos;
	}
	//seleciona produto especifico para edi��o
	@Override
	public List<Produto> getProduto(int id){
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			String sql = "select * from produto where cod_produto=?";

			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("cod_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco_unitario"));
				produto.setQuantidade(rs.getInt("quantidade_por_pessoa"));
				String tipoFesta = rs.getString("tipo_festa");
				
				if (tipoFesta.equals(TipoFesta.ADULTA.getDescricao())) {
					produto.setTipoFesta(TipoFesta.ADULTA);
				}else if(tipoFesta.equals(TipoFesta.INFANTIL.getDescricao())) {
					produto.setTipoFesta(TipoFesta.INFANTIL);
				}
				
				produtos.add(produto);		
			}
			rs.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return produtos;
	}
	//respons�vel pela edi��o
	@Override
	public void alteraProduto(Produto produto){
		String sql = "update produto_exibir set nome=?, quantidade_por_pessoa=?, preco_unitario=?, tipo_festa=? "
				+ "where id_produto=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());
			stmt.setString(4, produto.getTipoFesta().getDescricao());
			stmt.setInt(5, produto.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
	//remove produto
	@Override
	public void removeProduto(Produto produto){
		String sql = "delete from produto where cod_produto=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, produto.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Método que faz a chamada da procedure
	 * 
	 * @exception SQLException
	 * @param idSessao 
	 */
	@Override
	public void callProcedure(String idSessao) {
		//	CALL carregarBase('b2a1c3e5d5');
		String sql = "CALL carregarBase(?)";
		
		try {
			CallableStatement stmt = con.prepareCall(sql);
			
			stmt.setString(1, idSessao);
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
	
}
