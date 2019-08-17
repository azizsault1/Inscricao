package validators;

import java.awt.event.KeyEvent;
import java.util.Optional;

public class PreValidador {
   private static final int MAXIMUM_SIZE = 5;

   public Optional<Erro> validateKeyEvent(final KeyEvent e, final String text) {
      if (!Character.isDigit(e.getKeyChar())) {
         e.consume();
         return Optional.of(Erro.IMPARES);
      }
      if (text.length() > MAXIMUM_SIZE) {
         e.consume();
         return Optional.of(Erro.QUANTIDADE);
      }
      if (this.isNotValidChar(e.getKeyChar())) {
         e.consume();
         return Optional.of(Erro.IMPARES);
      }

      if (text.indexOf(e.getKeyChar()) >= 0) {
         e.consume();
         return Optional.of(Erro.QUANTIDADE);
      }
      
      return Optional.empty();
   }

   private boolean isNotValidChar(final char value) {
      return (value != '1') && (value != '3') && (value != '5') && (value != '7') && (value != '9');
   }
}
