package com.moraes;

import java.util.List;
import java.util.Scanner;

public class MainCurso {
static Scanner leia = new Scanner(System.in);
	
	static long cdCurso = 0;
	static String nome = ""; 
	static long valor = 0;
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
    	
    	System.out.println("Código: ");
    	cdCurso = leia.nextLong();
    	
    	System.out.println("Valor: R$");
    	valor = leia.nextLong();
    	
    	leia.nextLine();
		
		curso = new Curso(cdCurso, nome , valor, url);
    }
    private static long pegarCodigo() {
    	System.out.println("Código: ");
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
		System.out.println("Digite [!(Número)] para Sair\n"
				+ "==================================================================================");
		return leia.nextInt();
    }
    private static String chamaMetodo(int combobox) throws Exception {
    	cursoDAO = new CursoDAO();
    	switch (combobox) {
		case 3:{
			criarCurso();
			cursoDAO.persist(curso);
			return "Dados inseridos com Sucesso";
		}
		case 5:{
			cursoDAO.delete(cursoDAO.find(pegarCodigo()));
			return "Dados deletados com sucesso";
		}
		case 4:{
			criarCurso();
			cursoDAO.merge(curso);
			return "Dados alterados com Sucesso";
		}
		case 2:{
			return texto(cursoDAO.find(pegarCodigo()));
		}
		case 1:{
			return "paçoca";
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
