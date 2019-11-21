package sistema.claudia.exceptions;

import java.time.LocalDateTime;

public class DataIncoerenteException extends Exception {
	private LocalDateTime dataHora;
	
	public DataIncoerenteException(LocalDateTime dataHoraFim) {
		super("A data" + dataHoraFim + "n�o condiz com o in�cio do Evento.");
		this.dataHora = dataHoraFim;
	}
	
	public LocalDateTime getDataHoraFim() {
		return dataHora;
	}
	
}
