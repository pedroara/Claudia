package sistema.claudia.negocio;

import java.util.ArrayList;

public class Tag { 
	
	//Atributos:
	private String nome;
	public ArrayList <Evento> eventos;
	
	//Construtores:
	public Tag(String nome) {
		this.nome = nome;
		eventos = new ArrayList<Evento>();
	}
	
	public Tag() {
		
		nome = new String();
		eventos = new ArrayList<Evento>();
		
	}

	public ArrayList<Evento> getEventos(){
		return eventos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
