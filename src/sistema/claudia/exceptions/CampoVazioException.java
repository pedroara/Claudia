package sistema.claudia.exceptions;

public class CampoVazioException extends Exception {
	private String dadoUsuario;
	
	public CampoVazioException(String dado) {
		super("O campo" + dado + "deve ser preechido");
		this.dadoUsuario = dado;
	}
	
	public String getDado() {
        return dadoUsuario;
    }
}
