
public interface MovimentacaoBancaria {

<<<<<<< HEAD
	public void DEPOSITAR(double valor);

	public void SACAR(double valor) throws SaldoInsuficienteException;
=======
	 void DEPOSITAR(double valor);

	 boolean SACAR(double valor) throws SaldoInsuficienteException;

	 boolean TRANSFERIR(ContaBancaria destino, double valor) throws SaldoInsuficienteException;
>>>>>>> parent of cd75b71 (refacture: rename methods)
}
