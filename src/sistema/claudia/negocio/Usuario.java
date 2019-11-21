package sistema.claudia.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.negocio.Escolaridade;

public class Usuario {
	private String nome;
	private String login;
	private int senha;
	private LocalDate dataDeNascimento;
	private Escolaridade escolaridade;
	private Calendario calendario;
	public RepositorioTag reposTag;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Calendario getCalendar() {
			return calendario;
	}
	
	public Usuario(String nome, String dataDeNascimento, Escolaridade escolaridade, Calendario calendario, RepositorioTag reposTag) {
		this.calendario = calendario;
		this.reposTag = reposTag;
		this.nome = nome;
		this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
}
