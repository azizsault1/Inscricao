package validators;

import java.awt.event.KeyEvent;

public class PreValidator {
   private static final int MAXIMUM_SIZE = 5;

   public void validateKeyEvent(final KeyEvent e, final String text) {
      if (!Character.isDigit(e.getKeyChar())) {
         e.consume();
         return;
      }
      if (text.length() > MAXIMUM_SIZE) {
         e.consume();
         return;
      }
      if (this.isNotValidChar(e.getKeyChar())) {
         e.consume();
         return;
      }

      if (text.indexOf(e.getKeyChar()) >= 0) {
         e.consume();
         return;
      }
   }

   private boolean isNotValidChar(final char value) {
      return (value != '1') && (value != '3') && (value != '5') && (value != '7') && (value != '9');
   }
}
