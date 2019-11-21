package sistema.claudia.negocio;

import java.time.LocalDateTime;
import sistema.claudia.dados.Calendario;
import sistema.claudia.exceptions.DataInvalidaException;
import sistema.claudia.exceptions.EventoJaExistenteException;
import sistema.claudia.negocio.Evento;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class ControladorCalendario {
	
	private Calendario calendario;
	
	public ArrayList<Evento> getArrayEvento(){
		return calendario.getEventos();
	}
	
	public ControladorCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	public void cadastrar(Evento e) throws EventoJaExistenteException {
		if(e == null) {
			throw new IllegalArgumentException("Evento vazio");
		} else {
			if(!calendario.existe(e)) {
				calendario.adicionar(e.getNome(),
						e.getDescricao(),
						e.dataToString(e.getDataHoraInicio()),
						e.dataToString(e.getDataHoraFim()));
			} else {
				throw new EventoJaExistenteException(e.getNome());
			}
		}
	}
	
	public void remover(Evento e) throws EventoJaExistenteException {
		if(e != null && calendario.existe(e)) {
			calendario.remover(e);
		} else {
			throw new IllegalArgumentException("Evento não existe");
		}
	}
	
	public Evento[] buscarPorData(LocalDateTime data) throws DataInvalidaException {
		if(data.isSupported(ChronoField.DAY_OF_MONTH)
				&& data.isSupported(ChronoField.MONTH_OF_YEAR)
				&& data.isSupported(ChronoField.YEAR)) {
			return calendario.buscarPorData(data);
		} else {
			throw new DataInvalidaException(data);
		}
	}
	
	public boolean existe(Evento e) {
		return calendario.existe(e);
	}

}
