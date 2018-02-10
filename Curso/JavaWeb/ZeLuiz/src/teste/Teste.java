package teste;

public class Teste {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
