package sistema.teste;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.dados.RepositorioUsuario;
import sistema.claudia.negocio.Escolaridade;
import sistema.claudia.negocio.Usuario;

public class Teste {

	public static void main (String[] arg) {
		RepositorioUsuario repoUsers = new RepositorioUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int senha = 123;
		Calendario calendario = new Calendario(senha);
		LocalDateTime aniverTeste = LocalDateTime.of(1999, Month.MAY, 7, 02, 30);
		RepositorioTag reposTag = new RepositorioTag();
		Usuario testeUser = new Usuario("NomeTeste", aniverTeste.format(formatter), Escolaridade.MEDIO, calendario, reposTag );
		repoUsers.adicionarUsuario(testeUser);
		LocalDateTime dataTesteInicio = LocalDateTime.of(2012, Month.NOVEMBER, 29, 00, 00);
		LocalDateTime dataTesteFim = LocalDateTime.of(2012, Month.NOVEMBER, 30, 00, 00);
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).calendario.adicionar("Evento de teste", "Descricao de teste", dataTesteInicio.format(formatter), dataTesteFim.format(formatter) );
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).reposTag.adicionarTag("tagDeTeste");
		repoUsers.getUsuarioPeloNome(testeUser.getNome()).reposTag.adicionarEventoNaTag(reposTag.buscarTagPeloNome("tagDeTeste"), calendario.BuscarEventoPeloNome("Evento de teste"));;
		
		
		
		
		
	}
		
	
	
	
	
}
