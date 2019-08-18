package validators;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class PreValidatorTest {

   private final PreValidador preValidador;

   public PreValidatorTest() {
      this.preValidador = new PreValidador();
   }

   @Test
   public void dadoUmaInscricaoNulaQuandoValidaRetornaErro() {
      final Optional<Erro> e = this.preValidador.validateKeyEvent('2', null);
      Assert.assertTrue(e.isPresent());
      Assert.assertEquals(e.get(), Erro.NULO);
   }

   @Test
   public void dadoOnumero9QuandoValidaRetornaSucesso() {
      final Optional<Erro> e = this.preValidador.validateKeyEvent('9', "1357");
      Assert.assertFalse(e.isPresent());
   }

   @Test
   public void dadoUmaLetraBQuandoValidaRetornaErro() {
      final Optional<Erro> e = this.preValidador.validateKeyEvent('b', "a35");
      Assert.assertTrue(e.isPresent());
      Assert.assertEquals(e.get(), Erro.IMPARES);
   }

   @Test
   public void dadoOnumero1QuandoValidaRetornaSucesso() {
      final Optional<Erro> e = this.preValidador.validateKeyEvent('1', "9753");
      Assert.assertFalse(e.isPresent());
   }

   @Test
   public void dadoUmaNumerosEspecialQuandoValidaRetornaErro() {
      final Optional<Erro> e = this.preValidador.validateKeyEvent('%', "$&");
      Assert.assertTrue(e.isPresent());
      Assert.assertEquals(e.get(), Erro.IMPARES);
   }

}
