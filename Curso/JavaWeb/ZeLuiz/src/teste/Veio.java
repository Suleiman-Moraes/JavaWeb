package teste;

public class Veio {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("A__________________________");
		for (int i = 0; i < 10; i++) {
			for (int j = 10; j > i; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("B__________________________");
		for (int i = 0; i < 10; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 10; j > i; j--) {
				System.out.print("*");
				
			}
			System.out.print("\n");
		}
		System.out.println("C__________________________");
		for (int i = 0; i < 10; i++) {
			for (int j = 10; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("D__________________________");
	}
}
