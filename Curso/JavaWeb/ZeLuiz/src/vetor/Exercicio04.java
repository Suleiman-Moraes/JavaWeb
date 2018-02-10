package vetor;

import java.util.Scanner;

public class Exercicio04 {
	static int array[] = new int[5];
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
		System.out.println("Digite a "+(cont + 1)+"ª de [0 - 5]: ");
		x = leia.nextInt();
		if(x < 1 || x > 5) throw new Exception("Nota Invalida");
		array[x-1] ++;
		cont ++;
		if(cont == 20) imprimir();
		else entrada();
	}
	
	public static void imprimir() throws Exception {
		for (int i = 0; i < array.length; i++) {
			
			System.out.print("Nota: " + (i + 1) + " == ");
			System.out.print(array[i]);
			
			System.out.println(" ");
		}
		System.out.println("Porcentagem de notas 4 == "+porcentagem(4)+" e 5 == "+porcentagem(5));
	}
	
	public static double porcentagem(int x) {
		x = x - 1;
		return array[x]/20.0 * 100;
	}
}
