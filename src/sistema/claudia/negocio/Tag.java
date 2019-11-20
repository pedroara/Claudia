package sistema.claudia.negocio;

import java.util.ArrayList;
import java.time.LocalDateTime;
import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.repositorioTag;

public class Tag {
	
	private String nome;
	private ArrayList <Evento> eventos;
	
	public Tag(String nome) {
		this.nome = nome;
		eventos = new ArrayList<Evento>();
	}
	
	public Tag() {
		
		nome = new String();
		eventos = new ArrayList<Evento>();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarEventoNaTag(Evento evento) {
		eventos.add(evento);
	}
	
	public boolean existeEventoNaTag(String nomeDoEvento) {
		for(int i = 0 ; i < eventos.size() ; i++) {
			if( nomeDoEvento.contentEquals(eventos.get(i).getNome()) ) {
				return true;
			}
		}
		return false;
	}
	
	public int indexDoEvento (Evento evento) {
		for(int i = 0 ; i < eventos.size() ; i++) {
			if(evento.equals(eventos.get(i))) {
				return i;
			}
		}
		return -1;
	}

	public void removerTag(int index) {
		eventos.remove(index);
	}
	
	
	public void editarEventoPelaTag(Calendario cale,
									Evento evento,
									String nome,
									String descricao,
									String inicialDate,
									String finalDate) {
		
		//Os eventos podem ser "iguais" mas existe um na classse Calendario e um no arraylist de eventos da classe Tag:
		
		//Mudando o evento que ta na tag
		for(int i = 0; i < eventos.size(); i++) {
			if(evento.equals(eventos.get(i))) {
				eventos.get(i).setNome(nome);
				eventos.get(i).setDescricao(descricao);
				eventos.get(i).setDataHoraInicio(inicialDate);
				eventos.get(i).setDataHoraFim(finalDate);
			}
		}
		//Mudando o evento que ta no calendario
		for(int i = 0 ; i < cale.getEventos().size() ; i++) {
			if(evento.equals(cale.getEventos().get(i))) {
				cale.getEventos().get(i).setNome(nome);
				cale.getEventos().get(i).setDescricao(descricao);
				cale.getEventos().get(i).setDataHoraInicio(inicialDate);
				cale.getEventos().get(i).setDataHoraFim(finalDate);
			}
		}
		
		
	}
	
	
}
