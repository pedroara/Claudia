package classesbasicas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	private String nome;
	private String descricao;
	protected String[] tag;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	public Evento(String nome, String descricao, String[] tag, String dataHoraInicio, String dataHoraFim) {
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

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}
	
	public void ajustarRepeticao() {
		//TODO
	}
}
