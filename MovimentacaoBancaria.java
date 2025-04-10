
public interface MovimentacaoBancaria {

	 void depositar(double valor);

	 boolean sacar(double valor) throws SaldoInsuficienteException;

	 boolean transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException;
}
