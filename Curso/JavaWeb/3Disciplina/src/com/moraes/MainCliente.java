package com.moraes;

import java.util.List;
import java.util.Scanner;

public class MainCliente {
	static Scanner leia = new Scanner(System.in);
	
	static long cpf = 0;
	static String nome = ""; 
	static String email = "";
	
	static Cliente cliente;
	static ClienteDAO clienteDAO;
	
	public static void main(String[] args) {
		try {
			saida(chamaMetodo(combobox()));
			main(null);
		} catch (Exception e) {
			System.out.println("Finalizado!");
		}
	}
	
	private static void criarCliente() throws Exception {
		leia.nextLine();
		
		System.out.println("Nome: ");
    	nome = leia.nextLine();
    	
    	System.out.println("Email: ");
    	email = leia.nextLine();
    	
    	System.out.println("CPF: ");
    	cpf = leia.nextLong();
    	
    	leia.nextLine();
		
		cliente = new Cliente(cpf, nome , email);
    }
    private static long pegarCpf() {
    	System.out.println("CPF: ");
    	return leia.nextLong();
    }
    private static int combobox() {
    	System.out.println("\n\n\nSistema de gerencialmente de Clientes\n"
				+ "==================================================================================");
		System.out.println("Digite [1] para Consultar Todos os Clientes");
		System.out.println("Digite [2] para Consultar um Cliente Especifico");
		System.out.println("Digite [3] para Cadastrar um novo Cliente");
		System.out.println("Digite [4] para Alterar um Cliente");
		System.out.println("Digite [5] para Excluir um Cliente");
		System.out.println("Digite [!(Número)] para Sair\n"
				+ "==================================================================================");
		return leia.nextInt();
    }
    private static String chamaMetodo(int combobox) throws Exception {
    	switch (combobox) {
		case 3:{
			criarCliente();
			clienteDAO = new ClienteDAO(cliente);
			return clienteDAO.insert();
		}
		case 5:{
			clienteDAO = new ClienteDAO();
			return clienteDAO.delete(pegarCpf());
		}
		case 4:{
			criarCliente();
			clienteDAO = new ClienteDAO(cliente);
			return clienteDAO.update();
		}
		case 2:{
			clienteDAO = new ClienteDAO();
			return texto(clienteDAO.getSingle(pegarCpf()));
		}
		case 1:{
			clienteDAO = new ClienteDAO();
			return texto(clienteDAO.getAll());
		}
		default : {
			throw new Exception("Fim");
		}
    	}
    	
    }
    private static void saida(String texto) {
    	System.out.println(texto);
    }
    private static String texto(List<Cliente> list) {
    	String tudo = "";
    	for(Cliente x : list) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
    private static String texto(Cliente ...cliente) {
    	String tudo = "";
    	for(Cliente x : cliente) {
    		tudo += x.toString();
    		tudo += ("\n=================================================================\n\n");
     	}
    	return tudo;
    }
}
