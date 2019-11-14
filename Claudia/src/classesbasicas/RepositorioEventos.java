package classesbasicas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioEventos {
	private ArrayList<Evento> eventos;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	public RepositorioEventos() {
		List<Evento> eventos = new ArrayList<Evento>();
	}

	public void adicionar(Evento e) {
		if(e != null) {
			eventos.add(e);
		}
	}
	
	public void remover(Evento e) {
		if(eventos.contains(e) && e != null) {
			eventos.remove(e);
		}
	}
	
	public void editar(Evento e) {
		//TODO
	}
	
	public void adicionarTag() {
		//TODO
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
	
	public Evento[] listarPorTag(String tagBusca) {

		ArrayList <Evento> eventosListados = new ArrayList<>();
		
		for(int i = 0; i < eventos.size(); i++) {
			
			if(eventos.get(i).getTag() != null) {
				
				for(int j = 0; j < eventos.get(i).getTag().length; j++) {
					
					if(tagBusca == eventos.get(i).tag[j])
					{
						eventosListados.add(eventos.get(i));
					}
				}
				
			}
			
		}
		
		if(eventosListados != null) {
			Evento[] eventosResultado = new Evento[eventosListados.size()];
			
			for(int j = 0; j < eventosListados.size(); j++) {
					eventosResultado[j] = eventosListados.get(j);
			}
			Arrays.sort(eventosResultado);
			
			return eventosResultado;
		}
		else	return null;
		
    }
	
	public String[] listarTags() {
	ArrayList <String> tags = new ArrayList<>();
			
			for(int i = 0; i < eventos.size(); i++) {
				
				if(eventos.get(i).getTag() != null) {
					
					for(int j = 0; j < eventos.get(i).getTag().length; j++) {
						
						if(!tags.contains(eventos.get(i).tag[j]))
						{
							tags.add(eventos.get(i).tag[j]);
						}
					}
					
				}
				
			}
			
			if(tags != null) {
				String[] tagsResultado = new String[tags.size()];
				
				for(int j = 0; j < tags.size(); j++) {
						tagsResultado[j] = tags.get(j);
				}
				Arrays.sort(tagsResultado);
				
				return tagsResultado;
			}
			else	return null;
		
	}

	public void listarPorData() {
		//TODO
	}
}
