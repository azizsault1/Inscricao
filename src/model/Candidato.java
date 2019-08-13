package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidato {
   private static final int QUANTIDADE_MENOS_UM = 4;
   private final String inscricao;
   private final String posicao;

   public Candidato(final String inscricao) {
      this.inscricao = inscricao;
      this.posicao = this.calculaPosicao();
   }

   private List<Character> getNumerosEmOrdem() {
      return new ArrayList<>(Arrays.asList('1', '3', '5', '7', '9'));
   }

   public String getPosicao() {
      return this.posicao;
   }

   private String calculaPosicao() {

      final List<Character> numerosEmOrdem = this.getNumerosEmOrdem();

      int resultado = 1;
      for (int posicaoNumero = 0; posicaoNumero < QUANTIDADE_MENOS_UM; posicaoNumero++) {
         final int p = numerosEmOrdem.indexOf(this.inscricao.charAt(posicaoNumero));
         numerosEmOrdem.remove(p);
         final int fatorial = this.fatorial(QUANTIDADE_MENOS_UM - posicaoNumero);

         final int v = (p * fatorial);

         if (v > 0) {
            resultado = resultado + v;
         }
      }

      return String.valueOf(resultado);
   }

   private int fatorial(final int number) {
      if (number <= 1) {
         return 1;
      } else {
         return number * this.fatorial(number - 1);
      }
   }
}
