package unidade2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class Avaliacao extends JApplet implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		System.out.println("Inicializando...");
	}
	
	@Override
	public void paint(Graphics g) {
		String notas = JOptionPane.showInputDialog(null, "Informe a nota?");
		float nota = Float.parseFloat(notas);
		
		if(nota < 0 || nota > 100) {
			JOptionPane.showMessageDialog(null, "Nota Inválida");
			
			paint(null);
		}else {
			if(nota < 50) JOptionPane.showMessageDialog(null, "Insuficiente");
			
			else if(nota < 70) JOptionPane.showMessageDialog(null, "Regular");
			
			else if(nota < 90) JOptionPane.showMessageDialog(null, "Bom");
			
			else JOptionPane.showMessageDialog(null, "Exelente");
			
			System.exit(0);
		}
	}
	
	@Override
	public void start() {
		System.out.println("Executando...");
	}
	
	@Override
	public void stop() {
		System.out.println("Parando...");
	}
	
	@Override
	public void destroy() {
		System.out.println("Eliminando...");
	}
}
