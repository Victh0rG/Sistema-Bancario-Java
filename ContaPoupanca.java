class ContaPoupanca extends ContaBancaria {
	private double taxaRendimento;

	public ContaPoupanca(String numeroConta, double saldo, double taxaRendimento) {
		super(numeroConta, saldo);
		this.taxaRendimento = taxaRendimento;
	}

	public double calcularRendimento() {
		return getSALDO() * taxaRendimento;
	}
}
