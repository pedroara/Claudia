package sistema.teste;

import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.dados.RepositorioUsuario;
import sistema.claudia.negocio.Escolaridade;
import sistema.claudia.negocio.Usuario;

public class Teste {

	public static void main (String[] arg) {
		RepositorioUsuario repoUsers = new RepositorioUsuario();
		int senha = 123;
		Calendario calendario = new Calendario(senha);
		RepositorioTag reposTag = new RepositorioTag();
		Usuario testeUser = new Usuario("NomeTeste", "07-05-1999", Escolaridade.MEDIO, calendario, reposTag );
		repoUsers.adicionarUsuario(testeUser);
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario.adicionar("Evento de teste", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario.buscarPorNome("Evento de teste").toString();
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).reposTag.adicionarTag("tagDeTeste");
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).reposTag.adicionarEventoNaTag(reposTag.buscarTagPeloNome("tagDeTeste"), calendario.BuscarEventoPeloNome("Evento de teste"));
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).reposTag.editarEventoPelaTag(reposTag.buscarTagPeloNome("tagDeTeste"), repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario, repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario.BuscarEventoPeloNome("Evento de teste"), "Evento de teste sendo testado", "A descricao de teste sendo testada", "29-11-2019 00:00", "30-11-2019 00:00");
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario.buscarPorNome("Evento de teste sendo testado").toString();
		
		
		
		
	}
		
	
	
	
	
}
