package validators;

import org.junit.Assert;
import org.junit.Test;

public class PosValidadorTest {

   @Test
   public void DadoUmaInscricaorVaziaQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscricao deve ter 5 caracteres.", posValidador.getError());
   }

   @Test
   public void DadoUmaInscricaoComMenosDe5CaracteresQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("135");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscricao deve ter 5 caracteres.", posValidador.getError());
   }

   @Test
   public void DadoUmaInscricaoComValoresParesQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("24680");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", posValidador.getError());
   }

   @Test
   public void DadoUmaInscricaoComValoresRepetidosQuandoValidarRetornaErro() {
      final PosValidador posValidador = new PosValidador("33333");
      Assert.assertFalse(posValidador.isValid());
      Assert.assertEquals("A inscricao nao deve ter numeros repetidos.", posValidador.getError());
   }

   @Test
   public void DadoUmaInscricaoComValoresValidosQuandoValidarSucesso() {
      final PosValidador posValidador = new PosValidador("13579");
      Assert.assertTrue(posValidador.isValid());
      Assert.assertTrue(posValidador.getError().isEmpty());
   }
}
