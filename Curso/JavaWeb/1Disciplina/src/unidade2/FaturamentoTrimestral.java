package unidade2;

import javax.swing.JOptionPane;

public class FaturamentoTrimestral {
	public static void main(String[] args) {
		double vendas_janeiro; // = 15_000;
		double vendas_fevereiro; // = 23_000;
		double vendas_marco; // = 17_000;
		
		vendas_janeiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Infome as vendas de Janeiro.", "VENDAS", JOptionPane.INFORMATION_MESSAGE));
		vendas_fevereiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Infome as vendas de Fevereiro.", "VENDAS", JOptionPane.INFORMATION_MESSAGE));
		vendas_marco = Double.parseDouble(JOptionPane.showInputDialog(null, "Infome as vendas de Março.", "VENDAS", JOptionPane.INFORMATION_MESSAGE));
		
		double faturamento_trimestral = vendas_janeiro + vendas_fevereiro + vendas_marco;
		
		JOptionPane.showMessageDialog(null, "Faturamento Trimestral : R$ "+faturamento_trimestral, "Informação", JOptionPane.INFORMATION_MESSAGE);
	}
}
