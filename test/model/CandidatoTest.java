package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CandidatoTest {

   @Test
   void dado75913QuandoBuscaPosicaoRetorna89() {
      final Candidato candidato = new Candidato("75913");
      Assert.assertEquals("89", candidato.getPosicao());
   }

   @Test
   void dado13579QuandoBuscaPosicaoRetorna1() {
      final Candidato candidato = new Candidato("13579");
      Assert.assertEquals("1", candidato.getPosicao());
   }

   @Test
   void dado97531QuandoBuscaPosicaoRetorna120() {
      final Candidato candidato = new Candidato("97531");
      Assert.assertEquals("120", candidato.getPosicao());
   }

}
