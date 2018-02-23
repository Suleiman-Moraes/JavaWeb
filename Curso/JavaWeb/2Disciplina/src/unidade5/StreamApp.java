package unidade5;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {
	static List<String> funcionarios;

	public static void main(String[] args) {
		funcionarios = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			funcionarios.add("Suleiman" + i);
		}
		//filtrar("s");
		ordenar("s");
		contar("s");
	}

	public static void filtrar(String letra) {
		funcionarios.stream().filter(s->s.toLowerCase().startsWith(letra.toLowerCase())).forEach(System.out::println);
	}

	public static void ordenar(String letra) {
		funcionarios.stream().sorted().filter(s -> s.toLowerCase().startsWith(letra.toLowerCase())).forEach(System.out::println);
	}

	public static void contar(String letra) {
		long contador = funcionarios.stream().filter(s -> s.toLowerCase().startsWith(letra.toLowerCase())).count();
		System.out.println(contador);
	}
}
