package validators;

public enum Erro {

   QUANTIDADE("A inscricao deve ter 5 caracteres."),
   REPETIDOS("A inscricao nao deve ter numeros repetidos."),
   NULO("A mensagem nao pode ser nula"),
   IMPARES("A inscricao deve ter apenas valores impares.");

   private final String mensagem;

   private Erro(final String mensagem) {
      this.mensagem = mensagem;
   }

   @Override
   public String toString() {
      return this.mensagem;
   }
}
