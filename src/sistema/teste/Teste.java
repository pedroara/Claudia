package sistema.teste;

import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.dados.RepositorioUsuario;
import sistema.claudia.negocio.Escolaridade;
import sistema.claudia.negocio.Usuario;

public class Teste {

	public static void main (String[] arg) {
		
//		Calendario calendario = new Calendario();
//		RepositorioTag reposTag = new RepositorioTag();		
//		Evento e = new Evento("Evento de teste", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
//		System.out.println(e.toString());
		
		RepositorioUsuario repoUsers = new RepositorioUsuario();
		repoUsers.adicionarUsuario(new Usuario("UsuarioTeste", "07-05-1999", Escolaridade.MEDIO, new Calendario(), new RepositorioTag() ));
	
		repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar().adicionar("Evento de teste lalala", "Descricao de teste", "29-11-2012 00:00", "30-11-2012 00:00");
		
		
		System.out.println(repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar().buscarPorNome("Evento de teste lalala").toString());			
		
		repoUsers.getUsuarioPeloNome("UsuarioTeste").getTags().adicionarTag("tagDeTeste");		
		repoUsers.getUsuarioPeloNome("UsuarioTeste").getTags().adicionarEventoNaTag(repoUsers.getUsuarioPeloNome("UsuarioTeste").getTags().buscarTagPeloNome("tagDeTeste"), repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar().BuscarEventoPeloNome("Evento de teste lalala"));
		repoUsers.getUsuarioPeloNome("UsuarioTeste").getTags().editarEventoPelaTag(repoUsers.getUsuarioPeloNome("UsuarioTeste").getTags().buscarTagPeloNome("tagDeTeste"), repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar(), repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar().BuscarEventoPeloNome("Evento de teste lalala"), "Evento de teste sendo testado", "A descricao de teste sendo testada", "29-11-2019 00:00", "30-11-2019 00:00");		
		
		System.out.println(repoUsers.getUsuarioPeloNome("UsuarioTeste").getCalendar().buscarPorNome("Evento de teste sendo testado").toString());			
		

		
		
		
		
	}//main
}//class