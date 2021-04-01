public class MockServicoRemoto implements ServicoRemoto {

	ContaCorrente conta;
	int numeroContaRecebido;
	ContaCorrente contaPersistida;

	public ContaCorrente getContaPersistida() {
		return contaPersistida;
	}

	@Override
	public ContaCorrente recuperarConta(int numeroConta) {
		numeroContaRecebido = numeroConta;
		return conta;
	}

	@Override
	public void persistirConta(ContaCorrente conta) {
		contaPersistida = conta;
	}

	public void setContaCorrente(ContaCorrente conta) {
		this.conta = conta;
	}

	public int getNumeroContaRecebido() {
		return numeroContaRecebido;
	}

}
