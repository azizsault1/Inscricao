package validators;

import java.util.Optional;

public class PreValidador {
   private static final int MAXIMUM_SIZE = 5;

   public Optional<Erro> validateKeyEvent(final char nextChar, final String text) {

      if (text == null) {
         return Optional.of(Erro.NULO);
      }

      if (!Character.isDigit(nextChar)) {
         return Optional.of(Erro.IMPARES);
      }
      if (text.length() > MAXIMUM_SIZE) {
         return Optional.of(Erro.QUANTIDADE);
      }

      return Optional.empty();
   }
}
