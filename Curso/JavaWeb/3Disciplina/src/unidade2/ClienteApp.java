package unidade2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClienteApp {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";
	static Connection conexao;
	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			conectar();
			
			char op = '0';
			long cpf = 0;
			String nome = ""; 
			String email = "";
			
			System.out.println("\n\n\nSistema de gerencialmente de Clientes\n"
					+ "==================================================================================");
			System.out.println("Digite [1] para Consultar Todos os Clientes");
			System.out.println("Digite [2] para Consultar um Cliente Especifico");
			System.out.println("Digite [3] para Cadastrar um novo Cliente");
			System.out.println("Digite [4] para Alterar um Cliente");
			System.out.println("Digite [5] para Excluir um Cliente");
			System.out.println("Digite [!(Número)] para Sair\n"
					+ "==================================================================================");
			op = leia.next().charAt(0);
			
			switch (op) {
			case '1':{//Consultar Todos
				System.out.println("[1] Consutar Todos.");
				cunsultarTodos();
				main(null);
				break;
			}
			case '2':{//Consultar um Cliente Especifico
				System.out.println("[2] Consultar um Cliente Especifico.\nInforme CPF:");
				cpf = leia.nextLong();
				cunsultar(cpf);
				main(null);
				break;
			}
			case '3':{//Cadastrar
				System.out.println("[3] Cadastrar um novo Cliente.");
				System.out.println("Nome: ");
				nome = leia.next();
				System.out.println("Email: ");
				email = leia.next();
				System.out.println("CPF: ");
				cpf = leia.nextLong();
				inserir(cpf, nome, email);
				System.out.println();
				main(null);
				break;
			}
			case '4':{//Alterar
				System.out.println("[4] Aterar um Cliente.");
				System.out.println("Nome: ");
				nome = leia.next();
				System.out.println("Email: ");
				email = leia.next();
				System.out.println("CPF: ");
				cpf = leia.nextLong();
				alterar(cpf, nome, email);
				System.out.println();
				main(null);
				break;
			}
			case '5':{//Excluir
				System.out.println("[5] Excluir um Cliente.\nInforme CPF:");
				cpf = leia.nextLong();
				excluir(cpf);
				System.out.println();
				main(null);
				break;
			}
			default:
				System.out.println("Fim!");
				break;
			}
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	}
	
	public static void desconectar() throws SQLException {conexao.close();}
	
	public static void cunsultarTodos() throws SQLException {
		String sql = "SELECT * FROM cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		byte cont = 0;
		while (rs.next()) {
			System.out.println("CPF: " + rs.getInt(1) + "\nNome: " + rs.getString(2) + "\nEmail: " + rs.getString(3) + "\n");
			System.out.println("=================================================================\n\n");
			cont ++;
		}
		System.out.println("Numero de clientes listados: "+ cont + "\n\n");
	}
	
	public static void cunsultar(long cpf) throws SQLException {
		String sql = "SELECT * FROM cliente where cpf="+cpf;
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) 
			System.out.println("CPF: " + rs.getInt(1) + "\nNome: " + rs.getString(2) + "\nEmail: " + rs.getString(3));
	}
	
	public static void inserir(long cpf, String nome, String email) throws SQLException {
		String sql = "insert into cliente values ("+cpf+",'"+nome+"','"+email+"')";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		conexao.commit();
	}
	
	public static void alterar(long cpf, String nome, String email) throws SQLException {
		String sql = "update cliente set nome='"+nome+"',email='"+email+"' where cpf="+cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}
	
	public static void excluir(long cpf) throws SQLException {
		String sql = "delete from cliente where cpf="+cpf;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
	}
	
}
