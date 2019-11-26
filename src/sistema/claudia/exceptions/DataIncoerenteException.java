package sistema.claudia.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataIncoerenteException extends Exception {
	private LocalDate dataHora;
	
	public DataIncoerenteException(LocalDate dataHoraFim) {
		super("A data" + dataHoraFim + "n�o condiz com o in�cio do Evento.");
		this.dataHora = dataHoraFim;
	}
	
	public LocalDate getDataHoraFim() {
		return dataHora;
	}
	
}
