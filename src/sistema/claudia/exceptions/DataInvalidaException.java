package sistema.claudia.exceptions;

import java.time.LocalDateTime;

public class DataInvalidaException extends Exception {
	LocalDateTime dataHora;
	
	public DataInvalidaException(LocalDateTime dataHora) {
		super("Os campos de" + dataHora + "possuem valores inválidos.");
		this.dataHora = dataHora;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}

}
