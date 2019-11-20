package sistema.claudia.dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.Tag;

public class Calendario {
	private ArrayList<Evento> eventos;
	private int senha;
	
	public Calendario(int senhaDoLogin) {
		List<Evento> eventos = new ArrayList<>();
		senha = senhaDoLogin;
	}
	
	public void adicionar(String nome, String descricao, Tag[] tag, String dataHoraInicio, String dataHoraFim) {
		Evento e = new Evento(nome, descricao, tag, dataHoraInicio, dataHoraFim);
		eventos.add(e);
	}
	
	public void remover(Evento e) {
		if(eventos.contains(e) && e != null) {
			eventos.remove(e);
		}
	}
	
	public Evento buscarPorNome(String nome) {
		if(nome != null) {
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
}
