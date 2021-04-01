import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void armazenaPontosTest(){
		String jogador = "barbara";
		int quantidadePontos = 1;
		String tipoPonto = "estrela";

		Armazenamento.armazenaPontosJogador(jogador,quantidadePontos,tipoPonto);

	}

}