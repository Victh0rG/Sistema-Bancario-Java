
//import java.util.Scanner;

class ContaCorrente extends ContaBancaria {
	private double limiteChequeEspecial;

	public ContaCorrente(String numeroConta, double saldo, double limiteChequeEspecial) {
		super(numeroConta, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@Override
<<<<<<< HEAD
	public void SACAR(double valor) throws SaldoInsuficienteException {
		if (valor > getSALDO() + limiteChequeEspecial) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
		}
		setSaldo(getSALDO() - valor);
=======
	public boolean SACAR(double valor) throws SaldoInsuficienteException {
		// falso se valor maior que saldo c/ limite
		if (valor > getSALDO() + limiteChequeEspecial) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
		}
		// falso se valor nulo
		if (valor == 0) {
			throw new SaldoInsuficienteException("Informe valor para o saque.");
		}
		setSaldo(getSALDO() - valor);
		return true;
>>>>>>> parent of cd75b71 (refacture: rename methods)
	}
}
