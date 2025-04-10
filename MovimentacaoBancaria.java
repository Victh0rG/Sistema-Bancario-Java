
public interface MovimentacaoBancaria {

	public void depositar(double valor);

	public void sacar(double valor) throws SaldoInsuficienteException;
}
