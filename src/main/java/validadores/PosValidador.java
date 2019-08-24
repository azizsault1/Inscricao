package validadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosValidador {

   private static final String REPETICAO = "^(?:(.)(?!.*?\\1))*$";
   private static final String TAMANHO = ".{5}";
   private static final String NUMEROS_VALIDOS = "[13579]*";
   private static final String NUMEROS_INVALIDOS = "[13579]{5}";

   public boolean isValid(final String inscricao) {
      return (inscricao != null) && inscricao.matches(REPETICAO) && inscricao.matches(NUMEROS_INVALIDOS);
   }

   private List<Erro> getError(final String inscricao) {
      if (inscricao == null) {
         return Arrays.asList(Erro.QUANTIDADE);
      }

      final List<Erro> erros = new ArrayList<>();
      if (!inscricao.matches(REPETICAO)) {
         erros.add(Erro.REPETIDOS);
      }
      if (!inscricao.matches(NUMEROS_VALIDOS)) {
         erros.add(Erro.IMPARES);
      }
      if (!inscricao.matches(TAMANHO)) {
         erros.add(Erro.QUANTIDADE);
      }
      return erros;
   }

   public String getErros(final String inscricao) {
      final StringBuilder result = new StringBuilder();
      for (final Erro erro : this.getError(inscricao)) {
         result.append(erro.toString());
      }
      return result.toString();
   }
}
