import org.junit.Test;

import static org.junit.Assert.*;

public class PlacarTest {

	@Test
	public void registraPontosTest(){
		String jogador = "barbara";
		int quantidadePontos = 1;
		String tipoPonto = "estrela";

		assertEquals(String.format("O jogador %s recebeu %d %s", jogador, quantidadePontos, tipoPonto),
			Placar.registraPontos(jogador, tipoPonto, quantidadePontos));

	}

	@Test
	public void retornaPontosTest(){
		String jogador = "barbara";
		Placar.retornaPontos(jogador);
	}

	@Test
	public void retornaRankingTest(){
		String tipoPonto = "estrela";
		Placar.retornaRanking(tipoPonto);

	}

}