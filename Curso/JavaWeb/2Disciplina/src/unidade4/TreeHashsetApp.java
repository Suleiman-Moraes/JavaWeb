package unidade4;

import java.util.LinkedHashSet;

public class TreeHashsetApp {

	public static void main(String[] args) {
			LinkedHashSet<String> lista = new LinkedHashSet<>();
			
			lista.add("Vermelho");
			lista.add("Verde");
			lista.add("Verde");
			lista.add("Amarelo");
			
			System.out.println(lista);
		}
}
