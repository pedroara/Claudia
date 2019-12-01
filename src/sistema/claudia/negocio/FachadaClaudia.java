package sistema.claudia.negocio;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
		this.calendario.salvarArquivo();
		return new Evento(nome, descricao, dataInicio, dataFim);
	}
	
	public void remover(Evento e) {
		
		calendario.remover(e);
		this.calendario.salvarArquivo();
		
	}
	
	public ArrayList<Evento> getListDomingo(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.SUNDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSegunda(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.MONDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListTerca(){
		ArrayList<Evento> eventossDoDia = new ArrayList<Evento>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.TUESDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListQuarta(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.WEDNESDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListQuinta(){
		ArrayList<Evento> eventossDoDia = new ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.THURSDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSexta(){
		ArrayList<Evento> eventossDoDia = new  ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.FRIDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
				eventossDoDia.add(calendario.getEventos().get(i));
			}
		}
		return eventossDoDia;
	}
	
	public ArrayList<Evento> getListSabado(){
		ArrayList<Evento> eventossDoDia = new  ArrayList<>();
		for (int i = 0 ; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getDataHoraInicio().getDayOfWeek() == DayOfWeek.SATURDAY 
					&& LocalDateTime.now().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH) ==
					calendario.getEventos().get(i).getDataHoraInicio().getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
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
	
	public ArrayList<Evento> buscarPorNome(String name) {
		return calendario.BuscarEventoPeloNome(name);
	}
	
	public void editarEvento(Evento ev, String nome, String descricao, String dataHoraInicio, String dataHoraFim) {
		for(int i = 0; i < calendario.getEventos().size(); i++) {
			if(calendario.getEventos().get(i).getNome().contentEquals(ev.getNome()) && calendario.getEventos().get(i).getDataHoraInicio().equals(ev.getDataHoraInicio())) {
				if(ev.getNome() != null) {
					calendario.getEventos().get(i).setNome(nome);	
				}
				if(ev.getDescricao() != null) {
					calendario.getEventos().get(i).setDescricao(descricao);
				}
				if(ev.getDataHoraInicio() != null) {
					calendario.getEventos().get(i).setDataHoraInicio(dataHoraInicio);
				}
				if(ev.getDataHoraFim() != null) {
					
				}
				calendario.getEventos().get(i).setDataHoraFim(dataHoraFim);	
				this.calendario.salvarArquivo();
			}
		}		
	}
	
	public void adicionarEvento(String nome, String descricao, String dataHoraInicio, String dataHoraFim) throws EventoJaExistenteException {
		calendario.adicionar(nome, descricao, dataHoraInicio, dataHoraFim);
		this.calendario.salvarArquivo();
	}

	public Calendario getCalendario() {
		return calendario;
	}
	
	
}