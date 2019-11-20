package sistema.claudia.dados;

import java.util.ArrayList;

import sistema.claudia.negocio.Tag;

public class repositorioTag {

	private ArrayList<Tag> tags;
	
	public repositorioTag() {
		
		tags = new ArrayList<Tag>();
		
	}
	
	public void adicionar (Tag tag) {
		
		this.tags.add(tag);
		
	}  
	
	
	
	
	
}
