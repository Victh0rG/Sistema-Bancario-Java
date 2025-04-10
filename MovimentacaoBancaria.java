
public interface MovimentacaoBancaria {

	 void DEPOSITAR(double valor);

	 boolean SACAR(double valor) throws SaldoInsuficienteException;

	 boolean TRANSFERIR(ContaBancaria destino, double valor) throws SaldoInsuficienteException;
}
