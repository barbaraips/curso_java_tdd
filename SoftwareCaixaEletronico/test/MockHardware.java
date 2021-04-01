
class MockHardware implements Hardware {

	private int idConta;

	@Override
	public int pegarNumeroDaContaCartao() {
		return idConta;
	}

	@Override
	public void entregarDinheiro(double valor) {

	}

	@Override
	public void lerEnvelope() {

	}

}