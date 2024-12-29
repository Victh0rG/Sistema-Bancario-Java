
public class Usuario {

	public String nome;
	public int idade;
	public int cpf;

	public Usuario(String nome, int idade, int cpf) {

		this.cpf = cpf;
		this.idade = idade;
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public int getCpf() {
		return cpf;
	}

}
