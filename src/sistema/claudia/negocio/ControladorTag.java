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
		}
		if(tags.buscarTagPeloNome(nome) == null) {
			throw new IllegalArgumentException("Tag não existe.");
		} else {
			throw new CampoVazioException("Nome");
		}
	}
	
	public void removerTag(Tag tag) throws CampoVazioException {
		if(tag != null && tags.buscarTagPeloNome(tag.getNome()) != null) {
			tags.removerTag(tag);
		}else {
			throw new CampoVazioException("Nome");
		}
	}
	
	public void buscarPeloNome(String nome) throws CampoVazioException {
		if(nome != null) {
			tags.buscarTagPeloNome(nome);
		} else {
			throw new CampoVazioException("Nome");
		}
	}
	
	public void listarTagsExistentes() {
		tags.listarTagsExistentes();
	}
	
	public void adicionarEventoNaTag(Tag tag, Evento evento) throws CampoVazioException{
		if(tags.buscarTagPeloNome(tag.getNome()) != null) {
			tags.adicionarEventoNaTag(tag, evento);
		}
		if(tag.getNome() == null) {
			throw new CampoVazioException("Nome");
		} else {
			throw new IllegalArgumentException("Tag não existe.");
		}
	}
}
