package com.moraes;

import java.util.List;
import java.util.Scanner;

public class Main2 {
static Scanner leia = new Scanner(System.in);
	
	static long cdCurso = 0;
	static String nome = ""; 
	static float valor = 0;
	static String url = "";
	
	static Curso curso;
	static CursoDAO cursoDAO;
	
	public static void main(String[] args) {
		try {
			saida(chamaMetodo(combobox()));
			main(null);
		} catch (Exception e) {
			System.out.println("Finalizado!");
		}
	}
	
	private static void criarCurso() throws Exception {
		leia.nextLine();
		
		System.out.println("Nome: ");
    	nome = leia.nextLine();
    	
    	System.out.println("Email: ");
    	url = leia.nextLine();
    	
    	System.out.println("C�digo: ");
    	cdCurso = leia.nextLong();
    	
    	System.out.println("Valor: R$");
    	valor = leia.nextFloat();
    	
    	leia.nextLine();
		
		curso = new Curso(cdCurso, nome , valor, url);
    }
    private static long pegarCodigo() {
    	System.out.println("C�digo: ");
    	return leia.nextLong();
    }
    private static int combobox() {
    	System.out.println("\n\n\nSistema de gerenciamento de Cursos\n"
				+ "==================================================================================");
		System.out.println("Digite [1] para Consultar Todos os Cursos");
		System.out.println("Digite [2] para Consultar um Curso Especifico");
		System.out.println("Digite [3] para Cadastrar um novo Curso");
		System.out.println("Digite [4] para Alterar um Curso");
		System.out.println("Digite [5] para Excluir um Curso");
		System.out.println("Digite [!(N�mero)] para Sair\n"
				+ "==================================================================================");
		return leia.nextInt();
    }
    private static String chamaMetodo(int combobox) throws Exception {
    	switch (combobox) {
		case 3:{
			criarCurso();
			cursoDAO = new CursoDAO(curso);
			return cursoDAO.insert();
		}
		case 5:{
			cursoDAO = new CursoDAO();
			return cursoDAO.delete(pegarCodigo());
		}
		case 4:{
			criarCurso();
			cursoDAO = new CursoDAO(curso);
			return cursoDAO.update();
		}
		case 2:{
			cursoDAO = new CursoDAO();
			return texto(cursoDAO.getSingle(pegarCodigo()));
		}
		case 1:{
			cursoDAO = new CursoDAO();
			return texto(cursoDAO.getAll());
		}
		default : {
			throw new Exception("Fim");
		}
    	}
    	
    }
    private static void saida(String texto) {
    	System.out.println(texto);
    }
    private static String texto(List<Curso> list) {
    	String tudo = "";
    	for(Curso x : list) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
    private static String texto(Curso ...curso) {
    	String tudo = "";
    	for(Curso x : curso) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
}
