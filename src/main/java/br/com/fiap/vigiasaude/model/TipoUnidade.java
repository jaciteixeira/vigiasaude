package br.com.fiap.vigiasaude.model;

public class TipoUnidade {

	private Long id;
	private String descricao;
	
	public TipoUnidade() {}

	public TipoUnidade(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
