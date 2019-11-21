package sistema.claudia.negocio;

import sistema.claudia.dados.RepositorioTag;
import sistema.claudia.exceptions.CampoVazioException;

public class ControladorTag {
	//Em processo
	private RepositorioTag tags;
	
	public ControladorTag(RepositorioTag tags) {
		this.tags = tags;
	}
	
	public void adicionarTag(String nome) throws CampoVazioException {
		if(nome != null && tags.buscarTagPeloNome(nome) == null) {
			tags.adicionarTag(nome);
		} else {
			throw new CampoVazioException("Nome");
		}
	}
	
	public void removerTag(int index, Tag tag) throws CampoVazioException {
		
	}
}
