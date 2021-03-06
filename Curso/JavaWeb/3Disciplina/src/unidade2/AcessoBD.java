package unidade2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AcessoBD {
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String usuario = "curso_java";
	static String senha = "schema";
	static Connection conexao;
	
	public static void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	}
	
	public static void main(String[] args){
		try {
			conectar();
			mostrarMetaInfoDB();
			cunsultarCliente();
			conexao.close();
		} catch (SQLException e) {
			//conexao.close();
			e.printStackTrace();
		}
	}
	
	public static void cunsultarCliente() throws SQLException {
		String consulta = "SELECT * FROM cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(consulta);
		while (rs.next()) {
			JOptionPane.showMessageDialog(null, "CPF: " + rs.getInt(1) + "\nNome: " + rs.getString(2) + "\nEmail: " + rs.getString(3), 
					"CunsultarCliente", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
public static void mostrarMetaInfoDB() throws SQLException {
		DatabaseMetaData meta = conexao.getMetaData();
		String fabricanteDB = meta.getDatabaseProductName();
		String versaoDB = meta.getDatabaseProductVersion();
		
		JOptionPane.showMessageDialog(null, fabricanteDB + "<==>" + versaoDB, "MostrarMetaInfoDB", JOptionPane.INFORMATION_MESSAGE);
	}
}
