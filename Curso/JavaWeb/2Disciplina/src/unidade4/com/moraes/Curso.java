package unidade4.com.moraes;

import java.nio.file.Path;

public class Curso {
	int cdcurso;
	String nome;
	float valor;
	Path url;
	
	public Curso(int cdcurso, String nome, float valor, Path url) {
		super();
		this.cdcurso = cdcurso;
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}
	
	public int getCdcurso() {
		return cdcurso;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}
	public Path getUrl() {
		return url;
	}
	public void setCdcurso(int cdcurso) {
		this.cdcurso = cdcurso;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public void setUrl(Path url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Curso [cdcurso=" + cdcurso + ", nome=" + nome + ", valor=" + valor + ", url=" + url + "]";
	}
}
