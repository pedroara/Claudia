package sistema.claudia.negocio;

import sistema.claudia.dados.RepositorioUsuario;
import sistema.claudia.exceptions.CampoVazioException;

public class ControladorUsuario {
	private RepositorioUsuario users;
	
	public ControladorUsuario(RepositorioUsuario users) {
		this.users = users;
	}
	
	public void adicionarUsuario(Usuario user) throws CampoVazioException {
		if(user != null) {
			users.adicionarUsuario(user);
		} else {
			throw new IllegalArgumentException("Usuário inválido ou vazio.");
		}
	}
	
	public void removerUsuario(Usuario user) throws CampoVazioException {
		if(user != null) {
			users.removerUsuario(user);
		} else {
			throw new IllegalArgumentException("Usuário inválido ou vazio.");
		}
	}
	
	public Usuario getUsuarioPeloNome(String nome) throws CampoVazioException {
		if(nome != null && users.getUsuarioPeloNome(nome) != null) {
			return users.getUsuarioPeloNome(nome);
		}
		if(nome == null) {
			throw new CampoVazioException("Nome");
		} else {
			throw new IllegalArgumentException("Usuário não existe.");
		}
	}
}
