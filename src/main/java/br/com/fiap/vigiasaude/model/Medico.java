package br.com.fiap.vigiasaude.model;

public class Medico{
	
	private Long id;
	private String nome;
	private String especialidade;
	private String crm;
	private String telefone; 
	private String email;
	private String senha;
	private Unidade unidade;
	
	public Medico() {}

	public Medico(Long id, String nome, String especialidade, String crm, String telefone, String email, String senha,
			Unidade unidade) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.crm = crm;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.unidade = unidade;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Unidade getUnidade() {
		return unidade;
	}
	
}
