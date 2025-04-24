
class ContaCorrente extends ContaBancaria {
	private double limiteChequeEspecial;

	public ContaCorrente(String numeroConta, double saldo, double limiteChequeEspecial) {
		super(numeroConta, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@Override
	public boolean sacar(double valor) throws SaldoInsuficienteException {
		// falso se valor maior que saldo c/ limite
		if (valor > getSaldo() + limiteChequeEspecial) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
		}
		// falso se valor nulo
		if (valor == 0) {
			throw new SaldoInsuficienteException("Informe valor para o saque.");
		}
		setSaldo(getSaldo() - valor);
		return true;
	}
}
