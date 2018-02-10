package com.moraes;

public interface CriaCurso {
	public default Curso criacao(long cdCurso, String nome, float valor, String url) throws Exception{
		return new Curso(cdCurso, nome, valor, url);
	}
}
