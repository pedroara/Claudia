

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
	private ControladorCalendario controladorCalendario;
	
	private FachadaClaudia() {
		FachadaClaudia.getInstance();
		Calendario calendario = new Calendario();
		this.controladorCalendario = new ControladorCalendario(calendario); 
	}

	public static FachadaClaudia getInstance() {
        if (instance == null) {
            instance = new FachadaClaudia();
        }
        return instance;
    }
	
	public Evento CadastrarEvento(String nome, String descricao, String dataInicio, String dataFim) {
		Evento evento = new Evento(nome, descricao, dataInicio, dataFim);
		return evento;
	}
	
	public ArrayList<String> getListNomeEventoDoDia (LocalDateTime dia) {
		ArrayList<String> eventosDoDia = new  ArrayList<String>();
		for (int i = 0 ; i < controladorCalendario.getArrayEvento().size(); i++) {
			if(dia == controladorCalendario.getArrayEvento().get(i).getDataHoraInicio()) {
				eventosDoDia.add(controladorCalendario.getArrayEvento().get(i).getNome());
			}
		}
		return eventosDoDia;
	}
	
	public void adicionarEvento(Evento e) throws EventoJaExistenteException {
		controladorCalendario.cadastrar(e);
	}
	
	
}