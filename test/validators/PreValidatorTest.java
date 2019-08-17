package validators;

import java.awt.event.KeyEvent;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class PreValidatorTest {
	
	private final PreValidador preValidador;

	public PreValidatorTest() {
		this.preValidador = new PreValidador();
	}
	
	@Test
	/*
	 * Caso de teste 1
	 */
	public void testValidateKeyEvent() {
		KeyEvent event = Mockito.mock(KeyEvent.class);

		Optional<Erro> e = this.preValidador.validateKeyEvent(event, "");
		Assert.assertTrue(e.isPresent());
		Assert.assertEquals(e.get(), Erro.IMPARES);
	}

}
