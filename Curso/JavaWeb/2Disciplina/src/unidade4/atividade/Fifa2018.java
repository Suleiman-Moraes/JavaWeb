package unidade4.atividade;

import java.util.Set;
import java.util.TreeSet;

public class Fifa2018 {
	static Set<Jogador> lista = new TreeSet<>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Jogador aux = new Jogador("Jogador" + (i+1), (100 - i), "Sport Recife", "Brasil");
			lista.add(aux);
		}
		Jogador aux1 = null;
		Jogador aux2 = null;
		for (Jogador i : lista) {
			if(i.getNome().equals("Jogador3")) aux1 = new Jogador(i);
			else if(i.getNome().equals("Jogador8")) aux2 = new Jogador(i);
			
			if(aux1 != null && aux2 != null) break;
		}
		System.out.println("Comparacao1"+aux1.compareTo(aux2));
		System.out.println("Comparacao2"+aux2.compareTo(aux1));
		System.out.println("Comparacao3"+aux1.compareTo(aux1));
		System.out.println(lista);
		Jogador[] list = new Jogador[5];
		byte conta = 0;
		byte cont = 0;
		for (Jogador i : lista) {
			if(conta >= (lista.size() - 5)) {
				list[cont] = new Jogador(i);
				cont ++;
			}
			conta ++;
		}
		System.out.println(list);
		for (int i = list.length - 1; i >= 0; i--) {
			System.out.println(list[i]);
		}
	}
}
