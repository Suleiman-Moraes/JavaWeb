package unidade2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JApplet;

public class AloMundo extends JApplet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("Inicializando...");
	}
	
	@Override
	public void paint(Graphics g) {
		this.setBackground(Color.GREEN);
		this.setSize(400, 100);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Times new Roman", Font.BOLD,30));
		g.drawString("Versão JVM: "+System.getProperty("java.version"), 20, 20);
		g.drawString("Versão S.O: "+System.getProperty("os.name"), 50, 50);
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
