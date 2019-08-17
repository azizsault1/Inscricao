package validators;

public enum Erro {

	QUANTIDADE("A inscricao deve ter 5 caracteres."),
	REPETIDOS("A inscricao nao deve ter numeros repetidos."),
	IMPARES("A inscricao deve ter apenas valores impares.");

	private final String mensagem; 
	
	private Erro(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String toString(){
		return this.mensagem;
	}
}
