package servicos;

import org.junit.Assert;
import org.junit.Test;

import model.Candidato;

public class CandidatoServicoTest {

   private final CandidatoServico servico;

   public CandidatoServicoTest() {
      this.servico = new CandidatoServico();
   }

   /*
    * Caso de teste 1
    */
   @Test
   public void dadoUmaInscricaoEmBrancoQuandoBuscaPosicaoRetornaErro() {
      try {
         final Candidato candidato = new Candidato("");
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter 5 caracteres.", e.getMessage());
      }
   }

   @Test
   public void dadoNuloQuandoBuscaPosicaoRetornaErro() {
      try {
         final Candidato candidato = null;
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("O candidato nao pode ser nulo.", e.getMessage());
      }
   }

   @Test
   public void dadoUmaInscricaoComEspacosQuandoBuscaPosicaoRetornaErro() {
      try {
         final Candidato candidato = new Candidato("    ");
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao nao deve ter numeros repetidos.A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.",
               e.getMessage());
      }
   }

   /*
    * Caso de teste 2
    */
   @Test
   public void dado13579QuandoBuscaPosicaoRetorna1() {
      final Candidato candidato = new Candidato("13579");
      final Candidato result = this.servico.registrarCandidato(candidato);
      Assert.assertEquals(1, result.getPosicao());
   }

   /*
    * Caso de teste 3
    */
   @Test
   public void dadoa35bQuandoBuscaPosicaoRetornaErro() {
      try {
         final Candidato candidato = new Candidato("a35b");
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.", e.getMessage());
      }
   }

   /*
    * Caso de teste 4
    */
   @Test
   public void dado97531QuandoBuscaPosicaoRetorna120() {
      final Candidato candidato = new Candidato("97531");
      final Candidato result = this.servico.registrarCandidato(candidato);
      Assert.assertEquals(120, result.getPosicao());
   }

   /*
    * Caso de teste 5
    */
   @Test
   public void dadoUmaInscricaoComNumerosEspeciaisQuandoBuscaPosicaoRetornaErro() {
      try {
         final Candidato candidato = new Candidato("$&%");
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.", e.getMessage());
      }
   }

   /*
    * Caso de teste 6
    */
   @Test
   public void dado75913QuandoBuscaPosicaoRetorna89() {
      try {
         final Candidato candidato = new Candidato("89");
         this.servico.registrarCandidato(candidato);
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.", e.getMessage());
      }
   }
}
