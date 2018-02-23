package com.moraes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class ClienteDAO implements IPersistencia<Cliente>, CriaCliente{
	private Cliente cliente = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String usuario = "curso_java";
	private static String senha = "schema";
	private static Connection conexao;

	public ClienteDAO() throws SQLException {conectar();}
	public ClienteDAO(Cliente cliente) throws SQLException {
		this.cliente = cliente;
		conectar();
	}
	@Override
	public String insert() throws SQLException {
		PreparedStatement statement = conexao.prepareStatement("insert into cliente values (?, ?, ?)");
		statement.setLong(1, cliente.getCpf());
		statement.setString(2, cliente.getNome());
		statement.setString(3, cliente.getEmail());
		statement.executeUpdate();
		conexao.commit();
		conexao.close();
		return "Dados inseridos com sucesso!";
	}

	@Override
	public String delete(long codigo) throws SQLException {
		String sql = "delete from cliente where cpf="+codigo;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados deletados com sucesso!";
	}

	@Override
	public String update() throws SQLException {
		String sql = "update cliente set nome='"+cliente.getNome()+"',email='"+cliente.getEmail()+"' where cpf="+cliente.getCpf();
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados alterados com sucesso!";
	}

	@Override
	public Cliente getSingle(long codigo) throws Exception {
		String tudo = "";
		String sql = "SELECT * FROM cliente where cpf="+codigo;
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) 
			return criacao(rs.getLong(1), rs.getString(2), rs.getString(3));
		
		return null;
	}

	@Override
	public List<Cliente> getAll() throws Exception {
		String tudo = "";
		String sql = "SELECT * FROM cliente";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Cliente> lista = new LinkedList<>();
		while (rs.next()) {
			cliente = criacao(rs.getLong(1), rs.getString(2), rs.getString(3));
			lista.add(cliente);
		}
		return lista;
	}

	@Override
	public boolean exixte(long codigo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void conectar() throws SQLException {
		conexao = DriverManager.getConnection(url, usuario, senha);
		conexao.setAutoCommit(false);
	}
}
