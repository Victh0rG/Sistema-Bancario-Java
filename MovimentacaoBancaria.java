
public interface MovimentacaoBancaria {

	public void DEPOSITAR(double valor);

	public void SACAR(double valor) throws SaldoInsuficienteException;
}
