package sistema.claudia.negocio;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import sistema.claudia.dados.Calendario;
import sistema.claudia.exceptions.EventoJaExistenteException;
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
	
	public void remover(Evento e) {
		
	}
	
	public ArrayList<Evento> editRecebendoDia (LocalDateTime diaPraProcurar){
		ArrayList<Evento> eventoos = new ArrayList<Evento>();
		for(int i = 0; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().equals(diaPraProcurar)) {
				eventoos.add(calendario.getEventos().get(i));
			}
		}
		return eventoos;
	}
	
	public ArrayList<Evento> getListDomingo(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.SUNDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSegunda(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.MONDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListTerca(){
		ArrayList<Evento> eventossDoDia = new ArrayList<Evento>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.TUESDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListQuarta(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.WEDNESDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListQuinta(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.THURSDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSexta(){
		ArrayList<Evento> eventossDoDia = new  ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.FRIDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSabado(){
		ArrayList<Evento> eventossDoDia = new  ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			LocalDateTime.now().getDayOfWeek();
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.SATURDAY) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListNomeEventoDoDia (LocalDateTime dia) {
		ArrayList<Evento> eventosDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(dia.getMonthValue() == calendario.getEventos().get(i).getDataHoraInicio().getMonthValue() && dia.getDayOfMonth() == calendario.getEventos().get(i).getDataHoraInicio().getDayOfMonth() && dia.getYear() == calendario.getEventos().get(i).getDataHoraInicio().getYear()) {
				eventosDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventosDoDia;
	}
	
	public void adicionarEvento(String nome, String descricao, String dataHoraInicio, String dataHoraFim) throws EventoJaExistenteException {
		calendario.adicionar(nome, descricao, dataHoraInicio, dataHoraFim);;
	}

	public Calendario getCalendario() {
		return calendario;
	}
	
	
}