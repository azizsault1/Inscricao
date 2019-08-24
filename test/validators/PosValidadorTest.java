package validators;

import org.junit.Assert;
import org.junit.Test;

public class PosValidadorTest {

   private final PosValidador posValidador;

   public PosValidadorTest() {
      this.posValidador = new PosValidador();
   }

   @Test
   public void DadoUmaInscricaorVaziaQuandoValidarRetornaErro() {
      Assert.assertFalse(this.posValidador.isValid(""));
      Assert.assertEquals("A inscricao deve ter 5 caracteres.", this.posValidador.getErros(""));
   }

   @Test
   public void DadoUmaInscricaoComMenosDe5CaracteresQuandoValidarRetornaErro() {
      Assert.assertFalse(this.posValidador.isValid("135"));
      Assert.assertEquals("A inscricao deve ter 5 caracteres.", this.posValidador.getErros("135"));
   }

   @Test
   public void DadoUmaInscricaoComValoresParesQuandoValidarRetornaErro() {
      Assert.assertFalse(this.posValidador.isValid("24680"));
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", this.posValidador.getErros("24680"));
   }

   @Test
   public void DadoUmaInscricaoComValoresRepetidosQuandoValidarRetornaErro() {
      Assert.assertFalse(this.posValidador.isValid("33333"));
      Assert.assertEquals("A inscricao nao deve ter numeros repetidos.", this.posValidador.getErros("33333"));
   }

   @Test
   public void DadoUmaInscricaoComValoresValidosQuandoValidarSucesso() {
      Assert.assertTrue(this.posValidador.isValid("13579"));
      Assert.assertTrue(this.posValidador.getErros("13579").isEmpty());
   }
}
