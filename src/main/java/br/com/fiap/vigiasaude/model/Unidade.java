package br.com.fiap.vigiasaude.model;

public class Unidade{
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
	private String cep;
	private String estado;
	private String cidade;
	private String cnes;
	private TipoUnidade tipo;
	
	public Unidade() {}
	
	public Unidade(Long id, String nome, String email, String senha, String telefone, String endereco, String cep,
			String estado, String cidade, String cnes, TipoUnidade tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.cnes = cnes;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCep() {
		return cep;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCnes() {
		return cnes;
	}

	public TipoUnidade getTipo() {
		return tipo;
	}

}
