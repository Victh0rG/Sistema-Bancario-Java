
public class ContaBancaria implements MovimentacaoBancaria {
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNUMEROCONTA() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSALDO() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public void DEPOSITAR(double valor) {
        if (valor != 0) {
            saldo += valor;
            System.out.println("o valor do Saldo é : " + saldo);
        } else {
            System.out.println("Deposite um valor maior que zero!");
        }
    }

    @Override
    public boolean SACAR(double valor) throws SaldoInsuficienteException {

        if (valor == 0 || valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque");
        } else {
            saldo -= valor;
            System.out.println("Seu saldo é : " + saldo);
            return true;

        }
    }

    @Override
    public boolean TRANSFERIR(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
        if (!SACAR(valor)) {
            throw new SaldoInsuficienteException("Transferência falhou. Saldo insuficiente.");
        } else {
            destino.DEPOSITAR(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso de "
                    + numeroConta + " para " + destino.numeroConta);
            return true;
        }
    }
}
