package unidade2;


import java.io.FileInputStream;
import java.io.IOException;

public class StreamApp {

	public static void byteStream() throws IOException {
		FileInputStream entrada = new FileInputStream("C:\\Users\\Veronika\\Documents\\Mada\\Curso\\JavaWeb\\2Disciplina\\src\\unidade2\\dados.txt");
		int cont = 0;
		while((entrada.read()) != -1) 
			cont++;
		System.out.println("Número de caracters é: "+cont);
		entrada.close();
	}
	
	public static void caracterStream(char letra) throws IOException {
		FileInputStream entrada = new FileInputStream("C:\\Users\\Veronika\\Documents\\Mada\\Curso\\JavaWeb\\2Disciplina\\src\\unidade2\\dados.txt");
		int cont = 0;
		int c;
		while((c = entrada.read()) != -1) if(c == letra) cont++;
		System.out.println("Número de vezes que a letra informada foi encontrada : "+cont);
		entrada.close();
	}
	
	public static void main(String[] args) {
		try {
			byteStream();
			System.out.println("Letra: ");
			char letra = (char) System.in.read();
			caracterStream(letra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
