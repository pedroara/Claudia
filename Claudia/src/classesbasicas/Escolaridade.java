package classesbasicas;

public enum Escolaridade {
	FUNDAMENTAL(1), MEDIO(2), SUPERIOR(3), OUTROS(4);
	
	public int valor;
	
	Escolaridade(int valor){
		this.valor = valor;
	}
}
