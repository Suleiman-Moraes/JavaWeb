package unidade2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Suleiman {
	public static void main(String[] args) {
		/*Scanner leia = new Scanner(System.in);
		System.out.println("Digite um valor entre 1 a 10: ");
		int x = leia.nextInt();
		if(x > 10 || x < 1) {
			System.out.println("Panguas");
			main(null);
		}else {
			System.out.println("Ta na Disney?");
			char d = leia.next().charAt(0);
			if(d == 's') main(null);
			else System.out.println("Arregou!");
		}*/
		int vetor[] = {1,2,3,4,5,6,7,8,9,10};
		for (int i : vetor) {
			System.out.println("aaaaaaaaaaaa"+i);
		}
		double piru = 35.4893849384938;
		JOptionPane.showInputDialog(null, "Meu piru = %.2f",piru);
		System.out.println(piru);
	}
}
