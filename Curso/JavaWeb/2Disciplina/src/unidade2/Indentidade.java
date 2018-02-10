package unidade2;

import java.applet.Applet;
import java.io.Serializable;

public class Indentidade extends Applet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		int m[][] = new int[3][3];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i == j) m[i][j] = 1;
				else m[i][j] = 0;
				
				System.out.print(m[i][j]);
			}
			System.out.println("\n====");
		}
	}
}
