
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
		// inversao de if
		if (valor == 0) {
			System.out.println("Deposite um valor maior que zero!");
		}

		saldo += valor;
		System.out.println("o valor do Saldo é : " + saldo);
	}


	@Override
	public boolean sacar(double valor) throws SaldoInsuficienteException {
		// inversao de if
		if (valor == 0 || valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para o saque.");

		}

		saldo -= valor;
		System.out.println("Seu saldo é : " + saldo);
		return true;
	}

	@Override
	public boolean transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
		if (!sacar(valor)) {
			throw new SaldoInsuficienteException("Transferência falhou. Saldo insuficiente.");
        }
		destino.depositar(valor);
		System.out.println("Transferência de R$" + valor + " realizada com sucesso de "
				+ numeroConta + " para " + destino.numeroConta);
		return true;
	}

}
