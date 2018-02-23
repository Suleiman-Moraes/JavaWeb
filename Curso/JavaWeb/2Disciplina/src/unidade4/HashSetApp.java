package unidade4;

import java.util.HashSet;

public class HashSetApp {
	public static void main(String[] args) {
		HashSet<String> lista = new HashSet<>();
		
		lista.add("Vermelho");
		lista.add("Verde");
		lista.add("Verde");
		lista.add("Amarelo");
		
		System.out.println(lista);
	}
}
