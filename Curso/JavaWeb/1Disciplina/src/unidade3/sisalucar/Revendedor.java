package unidade3.sisalucar;

public enum Revendedor {
	ABCVEICULOS("101010/0001", "Rua das Perdizes, 1500", "Volkswagen"), 
	SIMAOVEIUCULOS("1010101/0001", "Av. Morumbi, 2500", "Honda"), 
	EMANUELVEICULOS("111111/0001", "Av. das Nações, 100", "Toyota");
	
	String cnpj;
	String endereco;
	String fabricante;
	
	private Revendedor(String cnpj, String endereco, String fabricante) {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.fabricante = fabricante;
	}
}
