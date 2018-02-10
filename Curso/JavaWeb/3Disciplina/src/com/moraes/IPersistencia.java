package com.moraes;

import java.sql.SQLException;
import java.util.List;

public interface IPersistencia<T> {
	String insert()throws SQLException;
	String delete(long codigo)throws SQLException;
	String update()throws SQLException;
	T getSingle(long codigo)throws Exception;
	List<T> getAll()throws Exception;
	boolean exixte(long codigo)throws SQLException;
	void conectar() throws SQLException;
}
