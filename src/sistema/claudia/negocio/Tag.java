package sistema.claudia.negocio;

import java.util.ArrayList;

public class Tag { 
	
	//comentario de teste :)
	//tes testes teste
	
	//Atributos:
	private String nome;
	private ArrayList <Evento> eventos;
	
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
