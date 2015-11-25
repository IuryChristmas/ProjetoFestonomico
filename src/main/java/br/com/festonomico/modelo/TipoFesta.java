package br.com.festonomico.modelo;

public enum TipoFesta {

	INFANTIL(1,"Infantil"),
	//CASAMENTO(2,"Casamento"),
	//QUINZE_ANOS(3,"Quinze anos"),
	ADULTA(2,"Adulta"),
	TODOS(3,"Todos");
	
	String descricao;
	Integer codigo;
	
	private TipoFesta(Integer codigo,String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
}
