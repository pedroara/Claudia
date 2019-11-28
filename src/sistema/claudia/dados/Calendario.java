package sistema.claudia.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sistema.claudia.negocio.Evento;

public class Calendario implements Serializable{
	private ArrayList<Evento> eventos;
	
	private static Calendario instance;
	
	public Calendario() {
		setEventos(eventos = new ArrayList<Evento>());
		//Evento natal = new Evento ("Natal", "Feriado comercial", "25-12-2019 00:00", "26-12-2019 00:00");
		Evento domingao = new Evento ("Domingao do Faustao", "Feriado mundial", "24-11-2019 00:00", "24-11-2019 23:59");
		Evento segundao = new Evento ("Tela Quente" , "qq cosa" , "25-11-2019 00:00", "25-11-2019 23:59");
		Evento terca = new Evento ("Terça Pop" , "qq cosa" , "26-11-2019 00:00", "26-11-2019 23:59");
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
		
		salvarArquivo();
	}
	
	public ArrayList<Evento> BuscarEventoPeloNome (String nome) {
		ArrayList<Evento> list = new ArrayList<Evento>();
		for (int i = 0 ; i < eventos.size() ; i++) {
			if(eventos.get(i).getNome().equalsIgnoreCase(nome)) {
				list.add(eventos.get(i));
			}
		}
		return list;
	}
	
	
	public ArrayList<Evento> getEventos(){
		return eventos;
	}
	
	public void setEventos(ArrayList<Evento> eventos){
		this.eventos = eventos;
	}
	
	public void adicionar(String nome, String descricao, String dataHoraInicio, String dataHoraFim) {
		if(eventos != null) {

			Evento evento = new Evento(nome, descricao, dataHoraInicio, dataHoraFim);
			eventos.add(evento);	
			
		}
	}
	
	public void adicionarPorEvento(Evento e) {
		if(eventos != null && e != null) {
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
		for(int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i) == e && eventos != null && eventos.get(i) != null && e != null) {
				return true;
			}
		}
		return false;
	}
	
	public static Calendario getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static Calendario lerDoArquivo() {
        Calendario instanciaLocal = null;
        
        File in = new File("eventos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (Calendario) o;
        } catch (Exception e) {
            instanciaLocal = new Calendario();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }

        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("eventos.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { oos.close(); } catch (IOException e) {/*Silent*/}
            }
        }
    }
}
