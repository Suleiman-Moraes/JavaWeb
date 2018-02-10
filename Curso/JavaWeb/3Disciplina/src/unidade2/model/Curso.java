package unidade2.model;

public class Curso {
	private long cdCurso = 0;
	private String nome = "";
	private float valor = 0;
	private String url = "";
	
	public Curso() {}
	public Curso(long cdCurso, String nome, float valor, String url) {
		this.cdCurso = cdCurso;
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}
	public Curso(Curso objeto) {
		this.cdCurso = objeto.cdCurso;
		this.nome = objeto.nome;
		this.valor = objeto.valor;
		this.url = objeto.url;
	}
	public long getCdCurso() {
		return cdCurso;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}
	public String getUrl() {
		return url;
	}
	public void setCdCurso(long cdCurso) {
		this.cdCurso = cdCurso;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdCurso ^ (cdCurso >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (cdCurso != other.cdCurso)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Curso [cdCurso=" + cdCurso + ", nome=" + nome + ", valor=" + valor + ", url=" + url + "]";
	}
}
