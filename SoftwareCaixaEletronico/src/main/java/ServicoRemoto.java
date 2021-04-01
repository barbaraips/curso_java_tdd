public interface ServicoRemoto {

	ContaCorrente recuperarConta(int id);

	void persistirConta(ContaCorrente conta);

}
