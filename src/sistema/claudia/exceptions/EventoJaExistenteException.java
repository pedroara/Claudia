package sistema.claudia.exceptions;

public class EventoJaExistenteException extends Exception{
	private String nome;
	
	public EventoJaExistenteException(String nome) {
		super("O evento" + nome + "já existe");
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
