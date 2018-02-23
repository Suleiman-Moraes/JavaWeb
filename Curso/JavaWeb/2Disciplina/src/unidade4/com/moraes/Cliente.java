package unidade4.com.moraes;

public class Cliente {
	String cpf;
	String nome;
	String email;
	
	public Cliente(String cpf, String nome, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}