package validators;

import org.junit.Assert;
import org.junit.Test;

public class PreValidatorTest {

   private final PreValidador preValidador;

   public PreValidatorTest() {
      this.preValidador = new PreValidador();
   }

   @Test
   public void dadoUmaInscricaoNulaQuandoValidaRetornaErro() {
      Assert.assertFalse(this.preValidador.isValid("2"));
      final String error = this.preValidador.getErros();
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", error);
   }

   @Test
   public void dadoOnumero9QuandoValidaRetornaSucesso() {
      final String inscricao = "123579";

      Assert.assertFalse(this.preValidador.isValid(inscricao));
      final String error = this.preValidador.getErros();
      Assert.assertEquals("A inscricao deve ter 5 caracteres.", error);
   }

   @Test
   public void dadoUmaLetraBQuandoValidaRetornaErro() {
      final String inscricao = "a35b";

      Assert.assertFalse(this.preValidador.isValid(inscricao));
      final String error = this.preValidador.getErros();
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", error);
   }

   @Test
   public void dadoOnumero1QuandoValidaRetornaSucesso() {
      final String inscricao = "97531";

      Assert.assertTrue(this.preValidador.isValid(inscricao));
   }

   @Test
   public void dadoUmaNumerosEspecialQuandoValidaRetornaErro() {
      final String inscricao = "$&%";

      Assert.assertFalse(this.preValidador.isValid(inscricao));
      final String error = this.preValidador.getErros();
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", error);
   }

   @Test
   public void dadoUmaNumeros2QuandoValidaRetornaErro() {
      final String inscricao = "1352";

      Assert.assertFalse(this.preValidador.isValid(inscricao));
      final String error = this.preValidador.getErros();
      Assert.assertEquals("A inscricao deve ter apenas valores impares.", error);
   }

   @Test
   public void dadoMaisDigitosQue5QuandoValidaRetornaErro() {
      final String inscricao = "13579";

      Assert.assertTrue(this.preValidador.isValid(inscricao));
   }

   @Test
   public void dadoDigito3QuandoValidaRetornaSucesso() {
      final String inscricao = "3";

      Assert.assertTrue(this.preValidador.isValid(inscricao));
   }

   @Test
   public void dadoDigito5QuandoValidaRetornaSucesso() {
      final String inscricao = "5";

      Assert.assertTrue(this.preValidador.isValid(inscricao));
   }

   @Test
   public void dadoDigito7QuandoValidaRetornaSucesso() {
      final String inscricao = "7";

      Assert.assertTrue(this.preValidador.isValid(inscricao));
   }

}
