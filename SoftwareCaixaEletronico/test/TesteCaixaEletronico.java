import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TesteCaixaEletronico {

	MockHardware mockHardware;
	MockServicoRemoto mockServicoRemoto;
	private CaixaEletronico caixaEletronico;
	ContaCorrente contaCorrente;

	@BeforeEach
	public void iniciaServico() {
		mockHardware = new MockHardware();
		mockServicoRemoto = new MockServicoRemoto();
		contaCorrente = new ContaCorrente(1, 20.00);
		contaCorrente.setSenha("123456");
		mockServicoRemoto.setContaCorrente(contaCorrente);
		caixaEletronico = new CaixaEletronico(mockHardware, mockServicoRemoto);
	}

	@Test
	void testeSaldo() {
		assertEquals("O saldo é R$ " + contaCorrente.getSaldo(), caixaEletronico.saldo(contaCorrente));
	}

	@Test
	void testeSacarOk() {
		assertEquals("Retire seu dinheiro.", caixaEletronico.sacar(contaCorrente, 10.00));
	}

	@Test
	void testeSacarErro() {
		assertEquals("Saldo insuficiente.", caixaEletronico.sacar(contaCorrente, 30.00));
	}

	@Test
	void testeDepositarOk() {
		assertEquals("Depósito recebido com sucesso.", caixaEletronico.depositar(contaCorrente, 100.00));
	}

	@Test
	public void testeDepositarErro() {
		assertEquals("Falha de funcionamento do hardware", caixaEletronico.depositar(contaCorrente, 100.00));
	}

	@Test
	public void testeLoginOk() {
		assertEquals("Usuário Autenticado", caixaEletronico.logar("123456"));
	}

	@Test
	public void testeLoginErro() {
		assertEquals("Não foi possível autenticar o usuário", caixaEletronico.logar("djoipwiev55"));
	}

}
