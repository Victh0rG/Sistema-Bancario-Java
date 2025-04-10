
public interface MovimentacaoBancaria {

	public void DEPOSITAR(double valor);

	public boolean SACAR(double valor) throws SaldoInsuficienteException;

	public boolean TRANSFERIR(ContaBancaria destino, double valor) throws SaldoInsuficienteException;
}
