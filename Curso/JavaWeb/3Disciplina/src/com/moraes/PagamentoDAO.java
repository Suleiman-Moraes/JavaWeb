package com.moraes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;



public class PagamentoDAO implements IPersistencia<Pagamento>{

	private Pagamento pagamento;
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String usuario = "curso_java";
	private static String senha = "schema";
	private static Connection conexao;
	
	public PagamentoDAO(Pagamento pagamento) throws SQLException {
		this.pagamento = pagamento;
		conectar();
	}
	public PagamentoDAO() throws SQLException {conectar();}

	@Override
	public String insert() throws SQLException {
		PreparedStatement statement = conexao.prepareStatement("insert into pagamento values (?, ?, ?)");
		statement.setLong(1, pagamento.getCpf());
		statement.setLong(2, pagamento.getCdCurso());
		statement.setDate(3, pagamento.getData());
		statement.executeUpdate();
		conexao.commit();
		conexao.close();
		return "Dados inseridos com sucesso!";
	}

	@Deprecated
	@Override
	public String delete(long codigo) throws SQLException {
		return null;
	}
	
	
	public String delete(long codigo, long cpf) throws SQLException {
		String sql = "delete from pagamento where cpf='"+cpf+ "' and cdCurso='"+codigo+"'";
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados deletados com sucesso!";
	}

	@Override
	public String update() throws SQLException {
		String sql = "update pagamento set data= to_date('"+pagamento.getData()+
				"', 'YYYY-MM-DD') where cpf='"+pagamento.getCpf()+ "' and cdCurso='"+pagamento.getCdCurso()+"'";
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados alterados com sucesso!";
	}

	@Deprecated
	@Override
	public Pagamento getSingle(long codigo) throws Exception {
		return null;
	}
	
	public Pagamento getSingle(long codigo, long cpf) throws Exception {
		String sql = "SELECT * FROM pagamento where cpf='"+cpf+ "' and cdCurso='"+codigo+"'";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) 
			return new Pagamento(rs.getLong(1), rs.getLong(2), rs.getDate(3));
		
		return null;
	}

	@Override
	public List<Pagamento> getAll() throws Exception {
		String tudo = "";
		String sql = "SELECT * FROM pagamento";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Pagamento> lista = new LinkedList<>();
		while (rs.next()) {
			pagamento = new Pagamento(rs.getLong(1), rs.getLong(2), rs.getDate(3));
			lista.add(pagamento);
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
