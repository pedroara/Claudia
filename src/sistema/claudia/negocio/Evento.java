package sistema.claudia.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import sistema.claudia.dados.RepositorioTags;

public class Evento {
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	private String nome;
	private String descricao;
	protected Tag[] tag;
		
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
	public Evento(String nome, String descricao, Tag[] tag, String dataHoraInicio, String dataHoraFim) {
		this.nome = nome;
		this.descricao = descricao;
		this.tag = tag;
		this.dataHoraInicio = LocalDateTime.parse(dataHoraInicio, formatter);
		this.dataHoraFim = LocalDateTime.parse(dataHoraFim, formatter);	
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = LocalDateTime.parse(dataHoraInicio, formatter);
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = LocalDateTime.parse(dataHoraFim, formatter);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tag[] getTag() {
		return tag;
	}

	public void setTag(Tag[] tag) {
		this.tag = tag;
	}
		
	public void ajustarRepeticao() {
		//TODO
	}
	
	public void removerTag(Tag tag) {
		
		ArrayList<Tag> buscaTag = new ArrayList<>();
		
		for(Tag k: this.tag) {
			buscaTag.add(k);
		}
		
		for(int i = 0; i <= buscaTag.size(); i++) {
			
			if(buscaTag.get(i) == tag) {
				buscaTag.remove(i);
				break;
			}
		}

		Tag[] novaTag = new Tag[buscaTag.size()];
		
		for(int i = 0; i <= (novaTag.length - 1); i++) {
			novaTag[i] = buscaTag.get(i);	
		}
		
		this.tag = novaTag;
	}
	
	public void adicionarTag(Tag tag) {
		if(this.tag != null && !contem(tag)) {
			
			Tag[] novaTag = new Tag[this.tag.length + 1];
			
			for(int i = 0; i <= (this.tag.length - 1); i++) {
				novaTag[i] = this.tag[i];
			}
			
			novaTag[novaTag.length - 1] = tag;
			this.tag = novaTag;
			
		} else {
			
			this.tag = new Tag[1];
			this.tag[0] = tag;
		}
	}
}
