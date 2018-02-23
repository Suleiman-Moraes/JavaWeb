package unidade4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		for (int i = 10; i >= 0; i--) {
			lista.add(i);
		}
		System.out.println(lista);
		Collections.sort(lista);
		System.out.println(lista);
	}
}
