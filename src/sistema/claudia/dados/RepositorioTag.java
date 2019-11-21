package sistema.claudia.dados;

import java.util.ArrayList;

import sistema.claudia.negocio.Evento;
import sistema.claudia.negocio.Tag;
import sistema.claudia.dados.Calendario;

public class RepositorioTag {

	private ArrayList<Tag> tags;
	
	public RepositorioTag() {
		
		tags = new ArrayList<Tag>();
		
	}
	
	public void adicionarTag (String nome) {
		
		Tag tag = new Tag(nome);
		this.tags.add(tag);
		
	}  
	
	public Tag buscarTagPeloNome (String nome) {
		for(int i = 0 ; i < tags.size() ; i++) {
			if (tags.get(i).getNome() == nome) {
				return tags.get(i); 
			}
		}
		return null;
	}
	
	public void adicionarEventoNaTag(Tag tag,Evento evento) {
		if(evento != null) {
			tag.getEventos().add(evento);
		}
		
	}
	
	public ArrayList<String> listarTagsExistentes() {
		ArrayList<String> tagsExistentes = new ArrayList<String>(); 
		
		for(int i = 0 ; i < tags.size(); i++) {
			if(tagsExistentes.contains(tags.get(i).getNome())) {
				
			}else {
				tagsExistentes.add(tags.get(i).getNome());
			}
		}
		
		return tagsExistentes;
		
		
	}
	
	public void editarEventoPelaTag(
			Tag tag,
			Calendario cale,
			Evento evento,
			String nome,
			String descricao,
			String inicialDate,
			String finalDate) {

//Os eventos podem ser "iguais" mas existe um na classse Calendario e um no arraylist de eventos da classe Tag:

		//Mudando o evento que ta na tag
		for(int i = 0; i < tag.getEventos().size(); i++) {
			if(evento.equals(tag.getEventos().get(i))) {
				tag.getEventos().get(i).setNome(nome);
				tag.getEventos().get(i).setDescricao(descricao);
				tag.getEventos().get(i).setDataHoraInicio(inicialDate);
				tag.getEventos().get(i).setDataHoraFim(finalDate);
			}
		}
		
		
		//Mudando o evento que ta no calendario
		if(tags != null && cale.getEventos() != null) {
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

	public boolean existeEventoNaTag(String nomeDoEvento, Tag tag) {
		for(int i = 0 ; i < tag.getEventos().size() ; i++) {
			if( nomeDoEvento.contentEquals(tag.getEventos().get(i).getNome()) ) {
				return true;
			}
		}
		return false;
	}
	
	public int indexDoEvento (Evento evento, Tag tag) {
		for(int i = 0 ; i < tag.getEventos().size() ; i++) {
			if(evento.equals(tag.getEventos().get(i))) {
				return i;
			}
		}
		return -1;
	}

	public void removerTag(int index, Tag tag) {
		tag.getEventos().remove(index);
	}
	
	
	
}
