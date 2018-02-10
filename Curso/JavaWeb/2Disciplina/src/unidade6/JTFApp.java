package unidade6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JTFApp extends JFrame implements ActionListener{

	public static void main(String[] args) {
		JTFApp frame = new JTFApp();
		
		frame.setSize(300, 300);
		frame.setTitle("Paçoca");
		Container cont = frame.getContentPane();
		JTextField tf = new JTextField("Digite Aki");
		tf.addActionListener(frame);
		cont.add(tf, BorderLayout.NORTH);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(rootPane, "Panguas"+ e.getActionCommand().toString(), "Panguao", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
