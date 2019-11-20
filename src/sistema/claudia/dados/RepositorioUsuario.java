package sistema.claudia.dados;

import java.util.ArrayList;

import sistema.claudia.negocio.Usuario;

public class RepositorioUsuario {
	
	
	private ArrayList<Usuario> repoUser;
	
	
	public RepositorioUsuario() {
		repoUser = new ArrayList<Usuario>();
	}
	
	public void adicionarUsuario(Usuario user) {
		repoUser.add(user);
	}
	
	public Usuario getUsuarioPeloNome(String nome) {
		for(int i = 0 ; i < repoUser.size(); i++) {
			if(nome == repoUser.get(i).getNome()) {
				return repoUser.get(i);
			}
		}
		return null;
	}

}
