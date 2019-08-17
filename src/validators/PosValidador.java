package validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosValidador {

	private final String inscricao;
	private static final String REPETICAO = "^(?:(.)(?!.*?\\1))*$";
	private static final String TAMANHO = ".{5}";
	private static final String NUMEROS_VALIDOS = "[13579]*";
	private static final String NUMEROS_INVALIDOS = "[13579]{5}";

	public PosValidador(final String inscricao) {
		this.inscricao = inscricao;
	}

	public boolean isValid() {
		return this.inscricao != null && this.inscricao.matches(REPETICAO) && this.inscricao.matches(NUMEROS_INVALIDOS);
	}

	private List<Erro> getError() {
		if (this.inscricao == null) {
			return Arrays.asList(Erro.QUANTIDADE);
		}

		List<Erro> erros = new ArrayList<>();
		if (!this.inscricao.matches(REPETICAO)) {
			erros.add(Erro.REPETIDOS);
		}
		if (!this.inscricao.matches(NUMEROS_VALIDOS)) {
			erros.add(Erro.IMPARES);
		}
		if (!this.inscricao.matches(TAMANHO)) {
			erros.add(Erro.QUANTIDADE);
		}
		return erros;
	}

	public String getErros() {
		StringBuilder result = new StringBuilder();
		for (Erro erro : this.getError()) {
			result.append(erro.toString());
		}
		return result.toString();
	}
}
