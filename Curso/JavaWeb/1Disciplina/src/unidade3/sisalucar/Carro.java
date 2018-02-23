package unidade3.sisalucar;

public class Carro {
	
	long idCarro;
	String placa;
	String fabricante;
	String modelo;
	int ano;
	String cor;
	float valorDiario;
	Revendedor revendedor;
	
	public Carro(long idCarro, String placa, String fabricante, String modelo, int ano, String cor, float valorDiario, Revendedor revendedor) {
		this.idCarro = idCarro;
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.valorDiario = valorDiario;
		this.revendedor = revendedor;
	}
	public Carro(){}
}
