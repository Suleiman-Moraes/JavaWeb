package unidade2.persistencia;

import unidade2.model.Curso;

public interface CriaCurso {
	public default Curso criacao(long cdCurso, String nome, float valor, String url) throws Exception{
		return new Curso(cdCurso, nome, valor, url);
	}
}
