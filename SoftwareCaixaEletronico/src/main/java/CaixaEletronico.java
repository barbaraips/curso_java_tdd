class CaixaEletronico {

	private static Hardware hardware;
	private static ServicoRemoto servicoRemoto;

	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		CaixaEletronico.hardware = hardware;
		CaixaEletronico.servicoRemoto = servicoRemoto;
	}

	public String logar(String senha) {
		int idConta;
		try {
			idConta = hardware.pegarNumeroDaContaCartao();
		} catch (Exception e) {
			return "Falha de funcionamento do hardware";
		}
		ContaCorrente conta = servicoRemoto.recuperarConta(idConta);
		String senhaConta = conta.getSenha();
		if (senhaConta.equals(senha))
			return "Usuário Autenticado";

		return "Não foi possível autenticar o usuário";
	}

	public String saldo(ContaCorrente contaCorrente) {
		return ("O saldo é R$ " + contaCorrente.getSaldo());
	}

	public String sacar(ContaCorrente conta, double valorParaSaque) {
		double saldoAtual = conta.getSaldo();
		if (valorParaSaque <= saldoAtual) {
			try {
				hardware.entregarDinheiro(valorParaSaque);
			} catch (Exception e) {
				return "Falha de funcionamento do hardware";
			}
			conta.setSaldo(saldoAtual - valorParaSaque);
			servicoRemoto.persistirConta(conta);
			return "Retire seu dinheiro.";
		} else {
			return "Saldo insuficiente.";
		}
	}

	public String depositar(ContaCorrente conta, double valorParaDeposito) {
		double saldoAtual = conta.getSaldo();
		try {
			hardware.lerEnvelope();
		} catch (Exception e) {
			return "Falha de funcionamento do hardware";
		}
		conta.setSaldo(saldoAtual + valorParaDeposito);
		servicoRemoto.persistirConta(conta);
		return "Depósito recebido com sucesso.";
	}

}
