package servicos;

import org.junit.Assert;
import org.junit.Test;

import model.Candidato;
import servicos.CandidatoServico;

public class CandidatoServicoTest {

   private final CandidatoServico servico;

   public CandidatoServicoTest() {
      this.servico = new CandidatoServico();
   }

   /*
    * Caso de teste 1
    */
   @Test
   public void dadoUmaInscricaoEmBrancoQuandoBuscaPosicaoRetornaErro(){
      try {
          this.servico.registrarCandidato("");
          Assert.fail("Expected IllegalArgumentException");
       } catch (final IllegalArgumentException e) {
          Assert.assertEquals("A inscricao deve ter 5 caracteres.",
                e.getMessage());
       }
   }
   
   @Test
   public void dadoNuloQuandoBuscaPosicaoRetornaErro(){
      try {
          this.servico.registrarCandidato(null);
          Assert.fail("Expected IllegalArgumentException");
       } catch (final IllegalArgumentException e) {
          Assert.assertEquals("A inscricao deve ter 5 caracteres.",
                e.getMessage());
       }
   }
   
   @Test
   public void dadoUmaInscricaoComEspacosQuandoBuscaPosicaoRetornaErro(){
      try {
          this.servico.registrarCandidato("    ");
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
      final Candidato candidato = this.servico.registrarCandidato("13579");
      Assert.assertEquals(1, candidato.getPosicao());
   }
   
   /*
    * Caso de teste 3
    */
   @Test
   public void dadoa35bQuandoBuscaPosicaoRetornaErro() {
      try {
         this.servico.registrarCandidato("a35b");
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.",
               e.getMessage());
      }
   }
   
   /*
    * Caso de teste 4
    */
   @Test
   public void dado97531QuandoBuscaPosicaoRetorna120() {
      final Candidato candidato = this.servico.registrarCandidato("97531");
      Assert.assertEquals(120, candidato.getPosicao());
   }
   
   /*
    * Caso de teste 5
    */
   @Test
   public void dadoUmaInscricaoComNumerosEspeciaisQuandoBuscaPosicaoRetornaErro(){
      try {
          this.servico.registrarCandidato("$&¨%");
          Assert.fail("Expected IllegalArgumentException");
       } catch (final IllegalArgumentException e) {
          Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.",
                e.getMessage());
       }
   }
   
   /*
    * Caso de teste 6
    */
   @Test
   public void dado75913QuandoBuscaPosicaoRetorna89() {
      try {
         this.servico.registrarCandidato("89");
         Assert.fail("Expected IllegalArgumentException");
      } catch (final IllegalArgumentException e) {
         Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.",
               e.getMessage());
      }
   }
}
