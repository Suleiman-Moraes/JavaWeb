package unidade6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaFL extends JFrame implements ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;

	public JanelaFL() {
		this.setTitle("Paçoca");
		this.setSize(300, 300);
		this.getContentPane().setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		JanelaFL janela = new JanelaFL();
		
		JButton b1, b2;
		
		b1 = new JButton("Butão 1");
		b2 = new JButton("Butão 2");
		b1.addActionListener(janela);
		b2.addActionListener(janela);
		janela.getContentPane().add(b1);
		janela.getContentPane().add(b2);
		janela.setVisible(true);
		janela.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println("--> " + comando);
	}

}
