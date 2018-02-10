package vetor;

import java.util.Scanner;

public class Exercicio02 {
	static int array[] = new int[11];
	static Scanner leia = new Scanner(System.in);
	static int cont = 0;
	
	public static void main(String[] args) throws Exception {
		try {
			entrada();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			main(null);
		}
	}
	public static void entrada() throws Exception {
		int x = 0;
		System.out.println("Digite a "+(cont + 1)+"ª de [0 - 100]: ");
		x = leia.nextInt();
		if(x < 0 || x > 100) throw new Exception("Nota Invalida");
		array[x/10] ++;
		cont ++;
		if(cont == 20) imprimir();
		else entrada();
	}
	
	public static void imprimir() throws Exception {
		for (int i = 0; i < array.length; i++) {
			
			if(i == 10) System.out.printf("%5d: ", 100);
			
			else System.out.printf("%02d - %02d: ", i * 10, i * 10 + 9);
			
			for (int j = 0; j < array[i]; j++) System.out.print("*");
			
			System.out.println(" ");
		}
	}
}
