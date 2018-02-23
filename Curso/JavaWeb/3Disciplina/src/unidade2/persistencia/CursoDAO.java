package unidade2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unidade2.model.Curso;

public class CursoDAO implements IPersistencia, CriaCurso{

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
	public String novo() throws SQLException {
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
	public String alterar() throws SQLException {
		String sql = "update curso set nome='"+curso.getNome()+"', url='"+curso.getUrl()+"', valor="+curso.getValor()+" where cdcurso="+curso.getCdCurso();
		Statement statement = conexao.createStatement();
		statement.executeUpdate(sql);
		conexao.commit();
		return "Dados alterados com sucesso!";
	}

	@Override
	public String visualisarUm(long codigo) throws SQLException {
		String tudo = "";
		String sql = "SELECT * FROM curso where cdcurso="+codigo;
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) 
			tudo += ("Código do Curso: " + rs.getLong(1) + "\nNome: " + rs.getString(2) + "\nValor: R$ " + rs.getFloat(3) + "\nURL: " + rs.getString(4));
		return tudo;
	}

	@Override
	public String visualisarTodos() throws SQLException {
		String tudo = "";
		String sql = "SELECT * FROM curso";
		Statement statement = conexao.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		byte cont = 0;
		while (rs.next()) {
			tudo += ("Código do Curso: " + rs.getLong(1) + "\nNome: " + rs.getString(2) + "\nValor: R$ " + rs.getFloat(3) + "\nURL: " + rs.getString(4) + "\n");
			tudo += ("=================================================================\n\n");
			cont ++;
		}
		return tudo += ("Numero de cursos listados: "+ cont + "\n\n");
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
