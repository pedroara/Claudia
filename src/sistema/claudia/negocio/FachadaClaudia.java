package sistema.claudia.negocio;

import sistema.claudia.dados.Calendario;

public class FachadaClaudia {
	
	private boolean logado(String nomeDoUsuarioLogado){
		return true;
	}
	
	private ControladorCalendario controladorCalendario;
	
	private static FachadaClaudia instance;
	
	private FachadaClaudia() {
		Calendario calendar = new Calendario();
		this.controladorCalendario = new ControladorCalendario(calendar);
	}
	
	public static FachadaClaudia getInstance() {
        if (instance == null) {
            instance = new FachadaClaudia();
        }
        return instance;
    }

	
	
	

}
