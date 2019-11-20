package sistema.teste;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import sistema.claudia.dados.Calendario;
import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.negocio.Escolaridade;
import sistema.claudia.negocio.Usuario;

public class Teste {

	public static void main (String[] arg) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int senha = 123;
		Calendario calendario = new Calendario(senha);
		LocalDateTime aniverTeste = LocalDateTime.of(1999, Month.MAY, 7, 02, 30);
		RepositorioTag reposTag = new RepositorioTag();
		Usuario testeUser = new Usuario("NomeTeste", aniverTeste.format(formatter), Escolaridade.MEDIO, calendario, reposTag );
		LocalDateTime dataTesteInicio = LocalDateTime.of(2012, Month.NOVEMBER, 29, 00, 00);
		LocalDateTime dataTesteFim = LocalDateTime.of(2012, Month.NOVEMBER, 30, 00, 00);
		//Criando um evento
		testeUser.calendario.adicionar("Evento de teste", "Descricao de teste", dataTesteInicio.format(formatter), dataTesteFim.format(formatter) );
		//Criando uma tag dentro do repositorio de tags, e adicionando o evento recem criado a tag
		reposTag.adicionarTag("tagDeTeste");
		reposTag.adicionarEventoNaTag(reposTag.buscarTagPeloNome("tagDeTeste"), calendario.BuscarEventoPeloNome("Evento de teste"));;
		
		
		
		
	}
		
	
	
	
	
}
