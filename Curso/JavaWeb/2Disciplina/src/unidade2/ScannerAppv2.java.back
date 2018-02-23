package unidade2;

import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ScannerAppv2 {
	public static void main(String[] args) {
		try {
			Scanner leia = new Scanner(new FileReader("C:\\Users\\Veronika\\Documents\\Mada\\Curso\\JavaWeb\\2Disciplina\\src\\unidade2\\numeros.txt"));
			double soma = 0;
			String valor;
			while(leia.hasNext()) {
				valor = leia.next();
				soma = soma + Double.parseDouble(valor);
			}
			
			leia.close();
			JOptionPane.showMessageDialog(null, "Soma " + soma);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
