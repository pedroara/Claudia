package sistema.claudia.dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sistema.claudia.negocio.Evento;

public class Calendario {
	private ArrayList<Evento> eventos;
	
	public Calendario() {
		eventos = new ArrayList<Evento>();
		//Evento natal = new Evento ("Natal", "Feriado comercial", "25-12-2019 00:00", "26-12-2019 00:00");
		Evento domingao = new Evento ("Domingao do Faustao", "Feriado mundial", "24-11-2019 00:00", "24-11-2019 23:59");
		Evento segundao = new Evento ("Tela Quente" , "qq cosa" , "25-11-2019 00:00", "25-11-2019 23:59");
		Evento terca = new Evento ("Ter�a Pop" , "qq cosa" , "26-11-2019 00:00", "26-11-2019 23:59");
		Evento quarta = new Evento ("Dia do bingo qua" , "qq cosa" , "27-11-2019 00:00", "27-11-2019 23:59");
		Evento quinta = new Evento ("Giro de Quinta" , "qq cosa" , "28-11-2019 00:00", "28-11-2019 23:59");
		Evento sexta = new Evento ("Sextou/BlackFriday" , "qq cosa" , "29-11-2019 00:00", "29-11-2019 23:59");
		Evento sabado = new Evento ("Dia de estudar poo" , "qq cosa" , "30-11-2019 00:00", "30-11-2019 23:59");
		
		//eventos.add(natal);
		eventos.add(quarta);
		eventos.add(sexta);
		eventos.add(quinta);
		eventos.add(sabado);
		eventos.add(segundao);
		eventos.add(terca);
		eventos.add(domingao);
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
