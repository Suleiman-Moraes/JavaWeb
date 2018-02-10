package teste;

import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Exercicio01 {
	static Formatter fmt = new Formatter(System.out);
	public static void main(String[] args) {
		try {
			System.out.println("Para sair digite uma letra.");
			
			Scanner leia = new Scanner(System.in);
			
			System.out.println("Quantos dados irá jogar?");
			int qtdDados = leia.nextInt();
			
			System.out.println("Quantas vezes vai jogar o dado ?");
			int repet = leia.nextInt();
			
			imprimir(dado(qtdDados, repet), qtdDados, repet);
			
			main(null);
		} catch (Exception e) {
			System.out.println("\n\nFim!!");
			fmt.close();
		}
	}
	public static int[] dado(int qtdDados, int repet) {
		int[] vet = new int[(qtdDados * 6) - (qtdDados-1)];
		
		for (int i = 0; i < repet; i++) {
			int a = 0;
			for (int j = 0; j < qtdDados; j++) {
				a += gerador(); 
			}
			a = a+ qtdDados;
			vet[(a-qtdDados)] ++;
		}
		return vet;
	}
	public static void imprimir(int[] vet, int qtdDados, int repet) {
		int soma = 0;
		for (int i = 0; i < vet.length; i++) {
			fmt.format((i+qtdDados)+ " == "+vet[i] + "             Percentual: %.2f ", percent(vet[i], repet));
			System.out.println("%");
			soma = soma + vet[i];
		}
		System.out.println("\nVezes que jogou o(s) "+qtdDados+" dado(s) == " + soma + " vezes.");
	}
	public static int gerador() {
		Random gerador = new Random();
		return gerador.nextInt(6);
	}
	
	public static float percent(int a, int repet) {
		return (float) a/repet * 100;
	}
}
