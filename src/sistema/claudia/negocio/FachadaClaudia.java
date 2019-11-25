package sistema.claudia.negocio;


import java.time.LocalDateTime;
import java.util.ArrayList;

import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioUsuario;
import sistema.claudia.exceptions.CampoVazioException;
import sistema.claudia.exceptions.EventoJaExistenteException;
import sistema.claudia.negocio.ControladorCalendario;
import sistema.claudia.negocio.Evento;

public class FachadaClaudia {
	
//	private ControladorUsuario controladorUsuario;
//	private ControladorTag controladorTag;	
//	public Usuario login(String nick, int senha) throws CampoVazioException {
//	return controladorUsuario.loginDeUsuario(nick, senha);
//}
	
	
	private static FachadaClaudia instance;
	private Calendario calendario;
	
	private FachadaClaudia() {
		//FachadaClaudia.getInstance();
		Calendario calendario = new Calendario();
		this.calendario = new Calendario(); 
	}

	public static FachadaClaudia getInstance() {
        if (instance == null) {
            instance = new FachadaClaudia();
        }
        return instance;
    }
	
	public void setTestes() {
		
	}
	
	public Evento CadastrarEvento(String nome, String descricao, String dataInicio, String dataFim) {
		return new Evento(nome, descricao, dataInicio, dataFim);
	}
	
	public ArrayList<String> getListNomeEventoDoDia (LocalDateTime dia) {
		ArrayList<String> eventosDoDia = new  ArrayList<String>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(dia.getMonthValue() == calendario.getEventos().get(i).getDataHoraInicio().getMonthValue() && dia.getDayOfMonth() == calendario.getEventos().get(i).getDataHoraInicio().getDayOfMonth() && dia.getYear() == calendario.getEventos().get(i).getDataHoraInicio().getYear()) {
				eventosDoDia.add(calendario.getEventos().get(i).getNome());
			}
		}
		return eventosDoDia;
	}
	
	public void adicionarEvento(String nome, String descricao, String dataHoraInicio, String dataHoraFim) throws EventoJaExistenteException {
		calendario.adicionar(nome, descricao, dataHoraInicio, dataHoraFim);;
	}
	
	
}