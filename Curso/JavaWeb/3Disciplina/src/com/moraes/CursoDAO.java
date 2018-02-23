package com.moraes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class CursoDAO implements IPersistencia<Curso>, CriaCurso{

	private Curso curso = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String usuario = "curso_java";
	private static String senha = "schema";
	private static Connection conexao;
	
	public CursoDAO() throws SQLException {
		conectar();
	}
	public CursoDAO(Curso curso) throws SQLException {
		this.curso = curso;
		conectar();
	}
	@Override
	public String insert() throws SQLException {
		PreparedStatement statement = conexao.prepareStatement("insert into curso values (?, ?, ?, ?)");
		statement.setLong(1, curso.getCdCurso());
		statement.setString(2, curso.getNome());
		statement.setFloat(3, curso.getValor());
		statement.setString(4, curso.getUrl());
		statement.executeUpdate();
		conexao.commit();
		conexao.close();
		return "Dados inseridos com sucesso!";
	}

	@Override
	public String delete(long codigo) throws SQLException {
		String sql = "delete from curso where cdcurso="+codigo;
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados deletados com sucesso!";
	}

	@Override
	public String update() throws SQLException {
		String sql = "update curso set nome='"+curso.getNome()+"', url='"+curso.getUrl()+"', valor="+curso.getValor()+" where cdcurso="+curso.getCdCurso();
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados alterados com sucesso!";
	}

	@Override
	public Curso getSingle(long codigo) throws Exception {
		String tudo = "";
		String sql = "SELECT * FROM curso where cdcurso="+codigo;
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) 
			return criacao(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
		return null;
	}

	@Override
	public List<Curso> getAll() throws Exception {
		String tudo = "";
		String sql = "SELECT * FROM curso";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		List<Curso> lista =  new LinkedList<>();
		while (rs.next()) {
			curso = criacao(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
			lista.add(curso);
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
