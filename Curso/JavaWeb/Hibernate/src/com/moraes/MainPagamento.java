package com.moraes;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainPagamento {
static Scanner leia = new Scanner(System.in);
	
	static long cpf = 0;
	static long cdCurso = 0; 
	static String data;
	
	static Pagamento pagamento;
	static PagamentoId pagamentoId;
	static PagamentoDAO pagamentoDAO;
	
	public static void main(String[] args) {
		try {
			saida(chamaMetodo(combobox()));
			main(null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Finalizado!");
		}
	}
	
	private static void criarPagamento() throws Exception {
		try {
			leia.nextLine();
			
			System.out.println("Codigo do Curso: ");
	    	cdCurso = leia.nextLong();
	    	
	    	leia.nextLine();
	    	
	    	System.out.println("Data: ");
	    	data = leia.nextLine();
	    	
	    	System.out.println("CPF: ");
	    	cpf = leia.nextLong();
	    	
	    	leia.nextLine();
			pagamentoId = new PagamentoId(cpf, cdCurso);
			pagamento = new Pagamento(pagamentoId , data);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    private static long pegarCpf() {
    	System.out.println("CPF: ");
    	return leia.nextLong();
    }
    private static long pegarCdCurso() {
    	System.out.println("Código do Curso: ");
    	return leia.nextLong();
    }
    private static int combobox() {
    	System.out.println("\n\n\nSistema de gerenciamento de Pagamentos\n"
				+ "==================================================================================");
		System.out.println("Digite [1] para Consultar Todos os Pagamentos");
		System.out.println("Digite [2] para Consultar um Pagamento Especifico");
		System.out.println("Digite [3] para Cadastrar um novo Pagamento");
		System.out.println("Digite [4] para Alterar um Pagamento");
		System.out.println("Digite [5] para Excluir um Pagamento");
		System.out.println("Digite [!(Número)] para Sair\n"
				+ "==================================================================================");
		return leia.nextInt();
    }
    private static String chamaMetodo(int combobox) throws Exception {
    	pagamentoId = new PagamentoId(cpf, cdCurso);
    	pagamentoDAO = new PagamentoDAO();
    	switch (combobox) {
		case 3:{
			criarPagamento();
			pagamentoDAO.persist(pagamento);
			return "Dados inseridos com Sucesso";
		}
		case 5:{
			pagamentoDAO.delete(pagamento);
			return "Dados deletados com sucesso";
		}
		case 4:{
			criarPagamento();
			pagamentoDAO.merge(pagamento);
			return "Dados alterados com Sucesso";
		}
		case 2:{
			return texto(pagamentoDAO.find(pagamentoId));
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
    private static String texto(List<Pagamento> list) {
    	String tudo = "";
    	for(Pagamento x : list) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
    private static String texto(Pagamento ...paga) {
    	String tudo = "";
    	for(Pagamento x : paga) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
}
