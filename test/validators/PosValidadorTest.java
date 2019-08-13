package validators;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PosValidadorTest {

   @Test
   void DadoUmaInscricaorVaziaQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscrição deve ter 5 caracteres.", posValidador.getError());
   }

   @Test
   void DadoUmaInscricaoComMenosDe5CaracteresQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("135");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscrição deve ter 5 caracteres.", posValidador.getError());
   }

   @Test
   void DadoUmaInscricaoComValoresParesQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("24680");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscrição deve ter apenas valores impares.", posValidador.getError());
   }

   @Test
   void DadoUmaInscricaoComValoresRepetidosQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("33333");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscrição não deve ter números repetidos.", posValidador.getError());
   }

   @Test
   void DadoUmaInscricaoComValoresValidosQuandoValidarSucesso() {
      final PosValidador posValidador = new PosValidador("13579");
      Assert.assertTrue(posValidador.isValid());
      Assert.assertTrue(posValidador.getError().isEmpty());
   }
}
