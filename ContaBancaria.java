
public class ContaBancaria implements MovimentacaoBancaria {
	private String numeroConta;
	private double saldo;

	public ContaBancaria(String numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public void depositar(double valor) {
		if (valor != 0) {

			saldo += valor;

			System.out.println("o valor do Saldo é : " + saldo);
		} else {
			System.out.println("Deposite um valor maior que zero!");
		}
	}

	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		if (valor != 0 || valor < saldo) {
			saldo -= valor;

			System.out.println("Seu saldo é : " + saldo);
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente para o saque");
		}
	}

}
