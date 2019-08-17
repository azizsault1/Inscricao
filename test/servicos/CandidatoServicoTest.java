package servicos;

import org.junit.Assert;
import org.junit.Test;

import model.Candidato;

public class CandidatoServicoTest {

	private final CandidatoServico servico;

	public CandidatoServicoTest() {
		this.servico = new CandidatoServico();
	}

	@Test
	public void dado75913QuandoBuscaPosicaoRetorna89() {
		try {
			this.servico.executa("89");
			Assert.fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			Assert.assertEquals("A inscricao deve ter apenas valores impares.A inscricao deve ter 5 caracteres.",
					e.getMessage());
		}
	}

	@Test
	public void dado13579QuandoBuscaPosicaoRetorna1() {
		final Candidato candidato = this.servico.executa("13579");
		Assert.assertEquals(1, candidato.getPosicao());
	}

	@Test
	public void dado97531QuandoBuscaPosicaoRetorna120() {
		final Candidato candidato = this.servico.executa("97531");
		Assert.assertEquals(120, candidato.getPosicao());
	}

}
