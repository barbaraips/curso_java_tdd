public class Placar {

	String jogador;
	int moedas;
	int estrelas;

	public Placar(String jogador, int moedas, int estrelas) {
		this.jogador = jogador;
		this.moedas = moedas;
		this.estrelas = estrelas;
		new Armazenamento();
	}

	public static String registraPontos(String jogador, String tipoPonto, int pontos) {

		try {
			Armazenamento.armazenaPontosJogador(jogador,pontos,tipoPonto);
		} catch (Exception e) {
			return e.getMessage();
		}

		return String.format("O jogador %s recebeu %d %s", jogador, pontos, tipoPonto);
	}

	public static Placar retornaPontos(String jogador) {
		return null;
	}

	public static String retornaRanking(String tipoPonto) {
		return null;
	}
}
