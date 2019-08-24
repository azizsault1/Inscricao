package servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Candidato;
import validators.PosValidador;

@Service
public class CandidatoServico {

   private static final int QUANTIDADE_MENOS_UM = 4;

   private List<Character> getNumerosEmOrdem() {
      return new ArrayList<>(Arrays.asList('1', '3', '5', '7', '9'));
   }

   public Candidato registrarCandidato(final String inscricao) {
      final PosValidador posValidador = new PosValidador(inscricao);
      if (!posValidador.isValid()) {
         throw new IllegalArgumentException(posValidador.getError());
      }

      return this.calculaPosicao(new Candidato(inscricao));
   }

   private Candidato calculaPosicao(final Candidato candidato) {

      final List<Character> numerosEmOrdem = this.getNumerosEmOrdem();

      int resultado = 1;
      for (int posicaoNumero = 0; posicaoNumero < QUANTIDADE_MENOS_UM; posicaoNumero++) {
         final int p = numerosEmOrdem.indexOf(candidato.getInscricao().charAt(posicaoNumero));
         numerosEmOrdem.remove(p);
         final int fatorial = this.fatorial(QUANTIDADE_MENOS_UM - posicaoNumero);

         final int v = (p * fatorial);

         if (v > 0) {
            resultado = resultado + v;
         }
      }

      candidato.setPosicao(resultado);
      return candidato;
   }

   private int fatorial(final int number) {
      if (number <= 1) {
         return 1;
      } else {
         return number * this.fatorial(number - 1);
      }
   }
}
