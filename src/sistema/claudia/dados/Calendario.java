package sistema.claudia.dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sistema.claudia.negocio.Evento;

public class Calendario {
	private ArrayList<Evento> eventos;
	
	public Calendario() {
		eventos = new ArrayList<Evento>();
		Evento natal = new Evento ("Natal", "Feriado comercial", "25-12-2019 00:00", "26-12-2019 00:00");
		eventos.add(natal);
	}
	
	public Evento BuscarEventoPeloNome (String nome) {
		if(eventos != null) {
			for (int i = 0 ; i < eventos.size() ; i++) {
				if(eventos.get(i).getNome() == nome) {
					return eventos.get(i);
				}
			}	
		}
		return null;
	}
	
	
	public ArrayList<Evento> getEventos(){
		return eventos;
	}
	
	public void adicionar(String nome, String descricao, String dataHoraInicio, String dataHoraFim) {
		if(eventos != null) {

			Evento evento = new Evento(nome, descricao, dataHoraInicio, dataHoraFim);
			eventos.add(evento);	
			
		}
	}
	public void remover(Evento e) {
		if(eventos.contains(e) && e != null) {
			eventos.remove(e);
		}
	}
	
	public Evento buscarPorNome(String nome) {
		if(eventos != null) {
			for(Evento ev: eventos) {
				if(ev.getNome().equals(nome)) {
					return ev;
				}
			}
		}
		return null;
	}
	
	public void editar(Evento e) {
		//TODO
	}
	
	public Evento[] buscarPorData(LocalDateTime data) {
		List<Evento> datasBuscadas = new ArrayList<>();
		
		if(data != null) {
			for(Evento ev: eventos) {
				if(ev.getDataHoraInicio().equals(data)) {
					datasBuscadas.add(ev);
				}
			}
			if(datasBuscadas != null) {
				Evento[] resultado = new Evento[datasBuscadas.size()];
				
				for(int i=0; i<datasBuscadas.size(); i++) {
					resultado[i] = datasBuscadas.get(i);
				}
				return resultado;
			}
		}
		return null;
	}
	
	public void filtrarPorTag() {
		//TODO
	}
	
	public boolean existe(Evento e) {
		for(Evento busca: eventos) {
			if(busca == e) {
				return true;
			}
		}
		return false;
	}
}
