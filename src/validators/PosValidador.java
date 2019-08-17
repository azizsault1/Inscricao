package validators;

public class PosValidador {

   private final String inscricao;
   private static final String REPETICAO = "^(?:(.)(?!.*?\\1))*$";
   private static final String TAMANHO = ".{5}";
   private static final String NUMEROS_VALIDOS = "[13579]*";
   private static final String NUMEROS_INVALIDOS = "[13579]{5}";

   public PosValidador(final String inscricao) {
      this.inscricao = inscricao;
   }

   public boolean isValid() {
      return this.inscricao.matches(REPETICAO) && this.inscricao.matches(NUMEROS_INVALIDOS);
   }

   public String getError() {
      final StringBuilder errors = new StringBuilder();

      if (!this.inscricao.matches(REPETICAO)) {
         errors.append("A inscricao nao deve ter numeros repetidos.");
      }
      if (!this.inscricao.matches(NUMEROS_VALIDOS)) {
         errors.append("A inscricao deve ter apenas valores impares.");
      }
      if (!this.inscricao.matches(TAMANHO)) {
         errors.append("A inscricao deve ter 5 caracteres.");
      }
      return errors.toString();
   }

}
