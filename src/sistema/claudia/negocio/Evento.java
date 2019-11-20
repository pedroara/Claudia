package sistema.claudia.negocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Evento {
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	private String nome;
	private String descricao;
		
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
	public Evento(String nome, String descricao, Tag[] tag, String dataHoraInicio, String dataHoraFim) {
		this.nome = nome;
		this.descricao = descricao;
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

	public void ajustarRepeticao() {
		//TODO
	}
	
	public void removerTag() {
		//TODO
	}
	
	public void adicionarTag() {
		//TODO
	}

	public boolean equals(String obj) {
		if(obj != null && nome != null && obj == nome) {
			return true;
		}
		return false;
	}
	
}
