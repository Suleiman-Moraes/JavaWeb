package unidade2;

public class Macarrao {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int soma = x +y;
		int aa = 0;
		System.out.println("");
		for (int i = 4; i <= 20; i++) {
			x = y;
			y = soma;
			soma = x + y;
			aa = aa + soma;
			System.out.print(soma + " ");
		}
		System.out.println(aa);
	}
}
