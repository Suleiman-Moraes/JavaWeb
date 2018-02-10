package unidade5.com.moraes;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;

import org.omg.Messaging.SyncScopeHelper;

public class LojaVirtual {
	static Map<Cliente, List<Curso>> pagamentos = new HashMap<>();
	static Scanner leia = new Scanner(System.in);
	
	public static void listarCurso(List<Curso> lista) {
		//lista.forEach(p -> System.out.println(p.getCdcurso()+"<=>"+p.getNome()));
		lista.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		//Criar cursos disponiveis
		Curso java = new Curso(1, "Java8", 2000, Paths.get("/java8"));
		Curso oracle = new Curso(2, "Oracle",2500, Paths.get("/oracle"));
		Curso php = new Curso(3, "PHP", 1500, Paths.get("/php"));
		
		//Cadastro cliente
		Cliente toe = new Cliente("123.456.789-00", "Antonio", "toe@email.com");
		
		//Criar lista de curso do cliente
		List<Curso> cursoToe = new LinkedList<>();
		
		//fazer checkout dos cursos
		int op = 0;
		while(op != 4) {
			System.out.println("Nome do curso: [1 J][2 O][3 P]");
			op = leia.nextInt();
			
			if(op == 1) cursoToe.add(java);
			else if(op == 2) cursoToe.add(oracle);
			else if(op == 3) cursoToe.add(php);
			else op = 4;
		}
		leia.close();
		
		pagamentos.put(toe, cursoToe);
		System.out.println(pagamentos);
		//listar(pagamentos);
		Consumer<List<Curso>> consumer = LojaVirtual::listarCurso;
	}
	
	public static <T> List<T> ordenar(List<T> t) {
		return (List<T>) t.stream().sorted();
	}
	
	private static double valor = 0;
	public static double receita(Map<Cliente, Curso> mapa) {
		
		mapa.forEach((k,v) -> valor += v.getValor());
		return valor;
	}
	public static Map<Integer, Cliente> listar(Map<Cliente, Curso> mapa) {
		Map<Integer, Cliente> map = new TreeMap<>();
		mapa.forEach((k,v) -> map.put((int) v.getValor(), k));
		
		map.forEach((k,v) -> System.out.println(k+"  "+ v));
		return map;
	}
}