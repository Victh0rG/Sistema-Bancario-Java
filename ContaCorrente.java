
//import java.util.Scanner;

class ContaCorrente extends ContaBancaria {
	private double limiteChequeEspecial;

	public ContaCorrente(String numeroConta, double saldo, double limiteChequeEspecial) {
		super(numeroConta, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@Override
	public void SACAR(double valor) throws SaldoInsuficienteException {
		if (valor > getSALDO() + limiteChequeEspecial) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
		}
		setSaldo(getSALDO() - valor);
	}
}
