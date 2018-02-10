package unidade3;

public class Conta {
	int numero;
	double saldo;
	double limite;
	String nome;
	
	public boolean saca(double valor) {
		return false;
	}
	public void deposita(Conta destino, double valor) {
		
	}
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		
		conta1.deposita(conta2, 50);
	}
}
