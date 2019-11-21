package sistema.claudia.dados;

import java.util.ArrayList;

import sistema.claudia.negocio.Usuario;

public class RepositorioUsuario {
	
	
	private ArrayList<Usuario> repoUser;
	
	public RepositorioUsuario() {
		repoUser = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getRepoUser(){
		return repoUser;
	}
	
	public void adicionarUsuario(Usuario user) {
		repoUser.add(user);
	}
	
	public void removerUsuario(Usuario user) {
		for(Usuario u: repoUser) {
			if(user.equals(u)) {
				repoUser.remove(u);
			}
		}
	}
	
//	public Usuario getUsuarioPeloNome(String nome) {
//		if(repoUser != null) {
//			for(int i = 0 ; i < repoUser.size(); i++) {
//				if(nome == repoUser.get(i).getNome() && repoUser.get(i) != null) {
//					return repoUser.get(i);
//				}
//			}
//		}
//		return null;
//	}
	
	public Usuario getUsuarioPeloNome(String nome) {
		if(repoUser != null) {
			for(Usuario u: repoUser) {
				if(u.getNome().equals(nome)) {
					return u;
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private Usuario login (String nomeDoUsuario,  int senha){
		for(int  i = 0; i < repoUser.size() ; i++) {
			if(nomeDoUsuario.equals(repoUser.get(i).getNome())) {
				if(senha == repoUser.get(i).getSenha()) {
					return repoUser.get(i);
				}
			}
		}
		return repoUser.get(0);
	}
	
}
