package validadores;

import java.util.Optional;

public class PreValidador {
   private static final int MAXIMUM_SIZE = 5;
   private String mensagem;

   private Optional<Erro> validateKeyEvent(final String inscricao) {

      if (inscricao == null) {
         return Optional.of(Erro.NULO);
      }
      final char lastChar = inscricao.charAt(inscricao.length() - 1);

      if (!Character.isDigit(lastChar)) {
         return Optional.of(Erro.IMPARES);
      }

      if (inscricao.length() > MAXIMUM_SIZE) {
         return Optional.of(Erro.QUANTIDADE);
      }

      if (this.isNotValidChar(lastChar)) {
         return Optional.of(Erro.IMPARES);
      }

      return Optional.empty();
   }

   private boolean isNotValidChar(final char value) {
      return (value != '1') && (value != '3') && (value != '5') && (value != '7') && (value != '9');
   }

   public boolean isValid(final String inscricao) {
      final Optional<Erro> opErro = this.validateKeyEvent(inscricao);
      opErro.ifPresent(erro -> this.mensagem = erro.toString());
      return !opErro.isPresent();
   }

   public String getErros() {
      return this.mensagem;
   }
}
