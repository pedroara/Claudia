package classesbasicas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
	private String nome;
	private LocalDate dataDeNascimento;
	private Escolaridade escolaridade;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Usuario(String nome, String dataDeNascimento, Escolaridade escolaridade) {
		this.nome = nome;
		this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
		this.escolaridade = escolaridade;
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
	
	
	
	

}
